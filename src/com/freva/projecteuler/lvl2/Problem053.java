package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

//Euler problem #53:
//How many, not necessarily distinct, values of nCr, for 1 ≤ n ≤ 100, are greater than one-million?
//Answer: 4075, Time: 0ms

public class Problem053 implements Problem {
    public Number solve() {
        final int limit = 100;
        final int[][] nCr = new int[limit + 1][limit + 1];

        //Use Pascal's triangle to calculate nCr values, storing values >= 1m as 1m
        int numberOfValuesAboveMillion = 0;
        for (int n = 1; n <= limit; n++) {
            nCr[n][0] = nCr[n][n] = 1;

            for (int r = 1; r < n; r++) {
                nCr[n][r] = nCr[n - 1][r - 1] + nCr[n - 1][r];

                if (nCr[n][r] > 1000000) {
                    nCr[n][r] = 1000000;
                    numberOfValuesAboveMillion++;
                }
            }
        }

        return numberOfValuesAboveMillion;
    }
}
