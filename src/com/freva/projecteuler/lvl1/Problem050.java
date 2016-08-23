package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #050:
 * Answer: 997651, Time: 0ms
 *
 * The prime 41, can be written as the sum of six consecutive primes:
 * 41 = 2 + 3 + 5 + 7 + 11 + 13
 * This is the longest sum of consecutive primes that adds to a prime below one-hundred.
 *
 * The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.
 *
 * Which prime, below one-million, can be written as the sum of the most consecutive primes?
 */

public class Problem050 implements Problem {
    public Number solve() {
        final int[] primes = Functions.getPrimesBelow(4000);

        int sum = 0;
        int endIndex = 0;
        while (sum + primes[endIndex] < 1_000_000) {
            sum += primes[endIndex++];
        }

        // At this point we are dealing with a window of primes [0, endIndex) where the sum is just under 1M
        // For each iteration, we try to slide the window to the right as much as possible:
        // [1, endIndex+1), [2, endIndex+2), etc. until sum > 1M. then we decrease the window size to [0, endIndex-1)
        // and try sliding again until finding a sum that is a prime. Because we are iterating over window size, the
        // first match is the one that has most consecutive primes and we can immediately return.
        for (; ; sum -= primes[endIndex--]) {
            for (int offset = 0; sum < 1_000_000; sum += primes[endIndex + offset] - primes[offset++]) {
                if (Functions.isPrime(sum)) {
                    return sum;
                }
            }
        }
    }
}
