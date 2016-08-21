package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #72:
//How many elements would be contained in the set of reduced proper fractions for d ≤ 1,000,000?
//Answer: 303963552391, Time: 31ms

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
