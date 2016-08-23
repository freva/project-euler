package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #009:
 * Answer: 31875000, Time: 2ms
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which a^2 + b^2 = c^2
 * For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
 */

public class Problem009 implements Problem {
    public Number solve() {
        final int targetLength = 1000;

        for (int a = 3; ; a++) {
            for (int b = a + 1; b < (targetLength - a - 1) / 2; b++) {
                int c = targetLength - a - b;

                if (a * a + b * b == c * c) {
                    return a * b * c;
                }
            }
        }
    }
}
