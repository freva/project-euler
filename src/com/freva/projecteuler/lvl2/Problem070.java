package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #070:
 *
 *
 * Euler's Totient function, φ(n) [sometimes called the phi function], is used to determine the number of positive
 * numbers less than or equal to n which are relatively prime to n. For example, as 1, 2, 4, 5, 7, and 8, are all
 * less than nine and relatively prime to nine, φ(9)=6.
 * The number 1 is considered to be relatively prime to every positive number, so φ(1)=1.
 *
 * Interestingly, φ(87109)=79180, and it can be seen that 87109 is a permutation of 79180.
 *
 * Find the value of n, 1 < n < 10^7, for which φ(n) is a permutation of n and the ratio n/φ(n) produces a minimum.
 */

public class Problem070 implements Problem {
    public Number solve() {
        /**
         * As derived in the solution to problem 69:
         * n/φ(n) = product of n=1..r [p_k / (p_k - 1)]
         * The minimum ratio of n/φ(n) will have few unique prime factors, but is not prime (as φ(n)=n-1 cant be a
         * permutation of n. Therefore the solution will likely be a product of two primes close to sqrt(10^7).
         */

        final boolean[] isComposite = Functions.sieveOfEratosthenes(4_000);
        final int LIMIT = 10_000_000;

        int bestN = 0;
        double lowestRatio = Double.MAX_VALUE;
        for (int i = isComposite.length - 1; i > Math.sqrt(LIMIT); i--) {
            if (isComposite[i]) continue;
            for (int j = LIMIT / i; j > 2; j--) {
                if (isComposite[j]) continue;

                int n = i * j;
                int phiN = (i - 1) * (j - 1);
                double ratio = (double) n / phiN;
                if (ratio < lowestRatio) {
                    if (Functions.arePermutationsOfEachOther(n, phiN)) {
                        lowestRatio = ratio;
                        bestN = n;
                    }
                } else break;
            }
        }

        return bestN;
    }
}
