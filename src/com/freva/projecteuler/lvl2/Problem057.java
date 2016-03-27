package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

//Euler problem #57:
//In the first one-thousand expansions, how many fractions contain a numerator with more digits than denominator?
//Answer: 153, Time: 0ms

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
