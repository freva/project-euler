package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #15:
//How many routes are there through a 20x20 grid?
//Answer: 137846528820, Time: 0ms

public class Problem015 implements Problem {
    public Number solve() {
        final int size = 21;
        final long[][] array = new long[size][size];

        for (int i = 0; i < size; i++) {
            array[i][0] = array[0][i] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= i; j++) {
                array[j][i] = array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }

        return array[size - 1][size - 1];
    }
}
