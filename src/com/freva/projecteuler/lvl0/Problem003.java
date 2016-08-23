package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #003:
 * Answer: 6859, Time: 0ms
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143?
 */

public class Problem003 implements Problem {
    public Number solve() {
        long target = 600_851_475_143L;
        int largestFactor;

        for (largestFactor = 3; target != 1; largestFactor += 2) {
            if (target % largestFactor == 0) {
                target /= largestFactor;
            }
        }

        return largestFactor;
    }
}
