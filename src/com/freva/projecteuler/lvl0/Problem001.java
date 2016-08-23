package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #001:
 * Answer: 233168, Time: 0ms
 *
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these
 * multiples is 23.
 *
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */

public class Problem001 implements Problem {
    public Number solve() {
        int sum = 0;
        for (int i = 2; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
    }
} 
