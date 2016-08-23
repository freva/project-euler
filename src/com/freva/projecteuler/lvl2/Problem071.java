package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #071:
 * Answer: 428570, Time: 0ms
 *
 * Consider the fraction, n/d, where n and d are positive integers. If n < d and HCF(n,d)=1, it is called a reduced
 * proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * It can be seen that 2/5 is the fraction immediately to the left of 3/7.
 *
 * By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of
 * the fraction immediately to the left of 3/7.
 */

public class Problem071 implements Problem {
    public Number solve() {
        final int LIMIT = 1_000_000;
        int bestNumerator = 0;
        int bestDenominator = 1;

        for (int d = LIMIT; d > LIMIT - 7; d--) {
            int n = (3 * d - 1) / 7;
            if (bestNumerator * d < n * bestDenominator) {
                bestNumerator = n;
                bestDenominator = d;
            }
        }

        return bestNumerator;
    }
}
