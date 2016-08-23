package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #075:
 * Answer: 161667, Time: 29ms
 *
 * It turns out that 12 cm is the smallest length of wire that can be bent to form an integer sided right angle
 * triangle in exactly one way, but there are many more examples.
 * 12 cm: (3,4,5)
 * 24 cm: (6,8,10)
 * 30 cm: (5,12,13)
 * 36 cm: (9,12,15)
 * 40 cm: (8,15,17)
 * 48 cm: (12,16,20)
 *
 * In contrast, some lengths of wire, like 20 cm, cannot be bent to form an integer sided right angle triangle, and
 * other lengths allow more than one solution to be found; for example, using 120 cm it is possible to form exactly
 * three different integer sided right angle triangles.
 * 120 cm: (30,40,50), (20,48,52), (24,45,51)
 *
 * Given that L is the length of the wire, for how many values of L ≤ 1,500,000 can exactly one integer sided right
 * angle triangle be formed?
 */

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