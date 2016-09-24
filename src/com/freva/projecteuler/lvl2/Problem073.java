package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.ArrayFunctions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #073:
 * Answer: 7295372, Time: 3ms
 *
 * Consider the fraction, n/d, where n and d are positive integers. If n < d and HCF(n,d)=1, it is called a reduced proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * It can be seen that there are 3 fractions between 1/3 and 1/2.
 *
 * How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
 */

public class Problem073 implements Problem {
    public Number solve() {
        return numberOfFractionsLessThan(1./2, 12_000) - numberOfFractionsLessThan(1./3, 12_000) - 1;
    }

    private static long numberOfFractionsLessThan(double fraction, int limit) {
        int[] a = new int[limit + 1];

        for (int q = 1; q <= limit; q++) {
            a[q] += (int) (fraction * q);
            for (int m = 2 * q; m <= limit; m += q) {
                a[m] -= a[q];
            }
        }

        return ArrayFunctions.sum(a) - 1;
    }
}
