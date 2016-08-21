package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #75:
//Given that L is the length of the wire, for how many values of L <= 1,500,000 can exactly one integer sided right
//angle triangle be formed?
//Answer: 161667, Time: 29ms

public class Problem075 implements Problem {
    public Number solve() {
        /**
         * Generate pythagorean triples with sides a, b and c, if m and n are co-prime and m-n is odd:
         * a = m^2 - n^2
         * b = 2 * m * n
         * c = m^2 + n^2
         * length = a + b + c = 2 * m * (m + n)
         */

        final int LIMIT = 1_500_000;
        final int[] squares = new int[(int) Math.sqrt(LIMIT / 2) + 1];
        int[] numberOfSolutionsForLength = new int[LIMIT + 1];
        int numberOfLengthsWithSingleSolution = 0;

        for (int k = 1; k < squares.length; k++) {
            squares[k] = k * k;
        }

        for (int m = 2; m < squares.length; m++) {
            for (int n = 1 + m % 2; n < m; n += 2) { // Will always make m-n odd
                if (Functions.greatestCommonDivisor(m, n) != 1) continue;

                int length = 2 * m * (m + n);
                if (length > LIMIT) break;

                for (int r = length; r <= LIMIT; r += length) {
                    numberOfSolutionsForLength[r] += 1;
                }
            }
        }

        for (int r = 0; r <= LIMIT; r++) {
            if (numberOfSolutionsForLength[r] == 1) {
                numberOfLengthsWithSingleSolution++;
            }
        }

        return numberOfLengthsWithSingleSolution;
    }
}