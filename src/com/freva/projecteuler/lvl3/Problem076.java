package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #076:
 * Answer: 190569291, Time: 0ms
 *
 * It is possible to write five as a sum in exactly six different ways:
 * 4 + 1
 * 3 + 2
 * 3 + 1 + 1
 * 2 + 2 + 1
 * 2 + 1 + 1 + 1
 * 1 + 1 + 1 + 1 + 1
 *
 * How many different ways can one hundred be written as a sum of at least two positive integers?
 */

public class Problem076 implements Problem {
    public Number solve() {
        final int amount = 100;
        final int[] numberOfWaysToSum = new int[amount + 1];
        numberOfWaysToSum[0] = 1;

        /**
         * Similar to problem #031: Once we have iterated over i = r, we have the total number of ways to reach a sum
         * by only summing integers <= r
         */
        for (int i = 1; i < amount; i++) {
            for (int j = i; j <= amount; j++) {
                numberOfWaysToSum[j] += numberOfWaysToSum[j - i];
            }
        }

        return numberOfWaysToSum[amount];
    }
}
