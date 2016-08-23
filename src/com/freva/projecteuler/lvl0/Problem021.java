package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #021:
 * Answer: 31626, Time: 1ms
 *
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a ≠ b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 *
 * Evaluate the sum of all the amicable numbers under 10000.
 */

public class Problem021 implements Problem {
    public Number solve() {
        final int limit = 10_000;
        final int[] sumOfDivisors = new int[limit];
        for (int i = 1; i < limit / 2; i++) {
            for (int j = 2 * i; j < limit; j += i) {
                sumOfDivisors[j] += i;
            }
        }

        int sumOfAmicableNumbers = 0;
        for (int n = 3; n < limit; n++) {
            int pairCandidate = sumOfDivisors[n];
            if (pairCandidate != n && pairCandidate < limit && n == sumOfDivisors[pairCandidate]) {
                sumOfAmicableNumbers += n;
            }
        }

        return sumOfAmicableNumbers;
    }
}
