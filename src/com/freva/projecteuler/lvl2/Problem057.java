package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #057:
 * Answer: 153, Time: 0ms
 *
 * It is possible to show that the square root of two can be expressed as an infinite continued fraction.
 * √2 = 1 + 1/(2 + 1/(2 + 1/(2 + ... ))) = 1.414213...
 *
 * By expanding this for the first four iterations, we get:
 * 1 + 1/2 = 3/2 = 1.5
 * 1 + 1/(2 + 1/2) = 7/5 = 1.4
 * 1 + 1/(2 + 1/(2 + 1/2)) = 17/12 = 1.41666...
 * 1 + 1/(2 + 1/(2 + 1/(2 + 1/2))) = 41/29 = 1.41379...
 *
 * The next three expansions are 99/70, 239/169, and 577/408, but the eighth expansion, 1393/985, is the first example
 * where the number of digits in the numerator exceeds the number of digits in the denominator.
 *
 * In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
 */

public class Problem057 implements Problem {
    public Number solve() {
        int total = 0;

        double numerator = 3;
        double denominator = 2;
        for (int i = 0; i < 1000; i++) {
            final double tempNumerator = numerator;
            numerator += 2 * denominator;
            denominator += tempNumerator;

            if (denominator > 10) {
                denominator /= 10;
                numerator /= 10;
            }

            if (numerator >= 10) {
                total++;
            }
        }

        return total;
    }
}
