package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #053:
 * Answer: 4075, Time: 0ms
 *
 * There are exactly ten ways of selecting three from five, 12345:
 * 123, 124, 125, 134, 135, 145, 234, 235, 245, and 345
 *
 * In combinatorics, we use the notation, 5C3 = 10. In general,
 * nCr = n! / r!(n−r)!, where r ≤ n, n! = n×(n−1)×...×3×2×1, and 0! = 1.
 *
 * It is not until n = 23, that a value exceeds one-million: 23C10 = 1144066.
 *
 * How many, not necessarily distinct, values of  nCr, for 1 ≤ n ≤ 100, are greater than one-million?
 */

public class Problem053 implements Problem {
    public Number solve() {
        final int limit = 100;
        final int[][] nCr = new int[limit + 1][limit + 1];

        // Use Pascal's triangle to calculate nCr values, storing values >= 1m as 1m
        int numberOfValuesAboveMillion = 0;
        for (int n = 1; n <= limit; n++) {
            nCr[n][0] = nCr[n][n] = 1;

            for (int r = 1; r < n; r++) {
                nCr[n][r] = nCr[n - 1][r - 1] + nCr[n - 1][r];

                if (nCr[n][r] > 1_000_000) {
                    nCr[n][r] = 1_000_000;
                    numberOfValuesAboveMillion++;
                }
            }
        }

        return numberOfValuesAboveMillion;
    }
}
