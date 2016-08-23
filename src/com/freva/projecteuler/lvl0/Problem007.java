package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #007:
 * Answer: 104743, Time: 3ms
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */

public class Problem007 implements Problem {
    public Number solve() {
        int[] primes = Functions.getNPrimes(10_000);
        return primes[10_000];
    }
}
