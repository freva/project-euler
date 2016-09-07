package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #087:
 * Answer: 1097343, Time: 54ms
 *
 * The smallest number expressible as the sum of a prime square, prime cube, and prime fourth power is 28. In fact,
 * there are exactly four numbers below fifty that can be expressed in such a way:
 * 28 = 2^2 + 2^3 + 2^4
 * 33 = 3^2 + 2^3 + 2^4
 * 49 = 5^2 + 2^3 + 2^4
 * 47 = 2^2 + 3^3 + 2^4
 *
 * How many numbers below fifty million can be expressed as the sum of a prime square, prime cube, and prime
 * fourth power?
 */

public class Problem087 implements Problem {
    public Number solve() {
        final int limit = 50_000_000;
        final int[] primes = Functions.getPrimesBelow((int) Math.sqrt(limit));
        final boolean[] sums = new boolean[limit];

        int count = 0;
        for (int primeToSquare : primes) {
            int square = primeToSquare * primeToSquare;

            for (int primeToCube : primes) {
                int cube = (int) Functions.pow(primeToCube, 3);
                if (cube + square > limit) break;

                for (int k = 0; ; k++) {
                    int sum = (int) (Functions.pow(primes[k], 4) + cube + square);
                    if (sum > limit) break;
                    if (!sums[sum]) {
                        sums[sum] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
