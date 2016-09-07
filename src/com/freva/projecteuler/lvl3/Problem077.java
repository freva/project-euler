package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #077:
 * Answer: 71, Time: 0ms
 *
 * It is possible to write ten as the sum of primes in exactly five different ways:
 * 7 + 3
 * 5 + 5
 * 5 + 3 + 2
 * 3 + 3 + 2 + 2
 * 2 + 2 + 2 + 2 + 2

 What is the first value which can be written as the sum of primes in over five thousand different ways?
 */

public class Problem077 implements Problem {
	public Number solve() {
		int[] primes = Functions.getNPrimes(50);
        int amount = primes[primes.length-1];

        int[] numberOfWaysToMake = new int[amount + 1];
        numberOfWaysToMake[0] = 1;

        /**
         * Similar to problem #031: Once we have iterated over prime, we have the total number of ways to reach a sum
         * by only summing primes <= prime
         */
        for (int prime : primes) {
            for (int j = prime; j <= amount; j++) {
                numberOfWaysToMake[j] += numberOfWaysToMake[j - prime];
            }
        }

        for (int i = 0; ; i++) {
            if (numberOfWaysToMake[i] > 5000) {
                return i;
            }
        }
	}
}