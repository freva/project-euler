package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #014:
 * Answer: 837799, Time: 20ms
 *
 * The following iterative sequence is defined for the set of positive integers:
 * n → n/2 (n is even)
 * n → 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13 → 40 → 20 → 10 → 5 → 16 → 8 → 4 → 2 → 1
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has not been
 * proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 */

public class Problem014 implements Problem {
    public Number solve() {
        final int limit = 1_000_000;
        final int[] cache = new int[limit];

        int longestChainLength = 0, longestChainStartingNumber = 0;
        for (int n = 1, chainLength; n < limit; n++) {
            long temp = n;

            for (chainLength = 0; temp != 1; chainLength++) {
                if (temp < n) {
                    chainLength += cache[(int) temp];
                    break;
                }

                temp = (temp % 2 == 0) ? temp / 2 : 3 * temp + 1;
            }

            cache[n] = chainLength;

            if (longestChainLength < chainLength) {
                longestChainLength = chainLength;
                longestChainStartingNumber = n;
            }
        }

        return longestChainStartingNumber;
    }
}
