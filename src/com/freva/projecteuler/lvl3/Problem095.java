package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #095:
 * Answer: 14316, Time: 40ms
 *
 * The proper divisors of a number are all the divisors excluding the number itself. For example, the proper divisors
 * of 28 are 1, 2, 4, 7, and 14. As the sum of these divisors is equal to 28, we call it a perfect number.
 *
 * Interestingly the sum of the proper divisors of 220 is 284 and the sum of the proper divisors of 284 is 220, forming
 * a chain of two numbers. For this reason, 220 and 284 are called an amicable pair.
 *
 * Perhaps less well known are longer chains. For example, starting with 12496, we form a chain of five numbers:
 * 12496 → 14288 → 15472 → 14536 → 14264 (→ 12496 → ...)
 * Since this chain returns to its starting point, it is called an amicable chain.
 *
 * Find the smallest member of the longest amicable chain with no element exceeding one million.
 */

public class Problem095 implements Problem {
    public Number solve() {
        final int limit = 1_000_000;
        final int[] sumOfDivisors = new int[limit + 1];

        for(int i=1; i <= limit / 2; i++) {
            for (int j = 2 * i; j <= limit; j += i) {
                sumOfDivisors[j] += i;
            }
        }

        int lowest = 0, longestChainLength = 0;
        for (int n = 2; n < limit; n++) {
            int next = sumOfDivisors[n];

            // Simply iterate over all the starting numbers to their next numbers. As soon as we hit a number below
            // the starting number, we can stop as this chain will have same length as that number and is larger
            for (int currentChainLength = 1; currentChainLength < 100 && n < next && next < limit; currentChainLength++) {
                next = sumOfDivisors[next];
                if (next == n && currentChainLength > longestChainLength) {
                    longestChainLength = currentChainLength;
                    lowest = n;
                }
            }
        }

        return lowest;
    }
}