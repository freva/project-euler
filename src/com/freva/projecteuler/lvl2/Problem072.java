package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #072:
 * Answer: 303963552391, Time: 31ms
 *
 * Consider the fraction, n/d, where n and d are positive integers. If n < d and HCF(n,d)=1, it is called a reduced
 * proper fraction.
 *
 * If we list the set of reduced proper fractions for d ≤ 8 in ascending order of size, we get:
 * 1/8, 1/7, 1/6, 1/5, 1/4, 2/7, 1/3, 3/8, 2/5, 3/7, 1/2, 4/7, 3/5, 5/8, 2/3, 5/7, 3/4, 4/5, 5/6, 6/7, 7/8
 * It can be seen that there are 21 elements in this set.
 *
 * How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
 */

public class Problem072 implements Problem {
    public Number solve() {
        /**
         * Number of non reduceable fractions with denominator d is equal to the number of 1 <= n < d such that
         * gcd(n, d) == 1, this is also known as the Euler's Totient φ(n). Therefore what we are looking for is:
         * sum d=2..10^6 [φ(n)]
         */

        final int LIMIT = 1_000_000;
        final int[] phiN = new int[LIMIT + 1];
        for (int n = 2; n <= LIMIT; n++) {
            phiN[n] = n;
        }

        for (int n = 2; n <= LIMIT; n++) {
            if (phiN[n] == n) {
                for (int m = n; m <= LIMIT; m += n) {
                    phiN[m] -= phiN[m] / n;
                }
            }
        }

        return Functions.sum(phiN);
    }
}
