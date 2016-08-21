package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #73:
//How many fractions lie between 1/3 and 1/2 in the sorted set of reduced proper fractions for d ≤ 12,000?
//Answer: 7295372, Time: 3ms

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

        return Functions.sum(a) - 1;
    }
}
