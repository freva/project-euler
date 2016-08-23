package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #064:
 * Answer: 1322, Time: 4ms
 *
 * All square roots are periodic when written as continued fractions and can be written in the form:
 * √N = a0 + (1 / a1 + (1 / a2 + (1 / a3 + ...))))
 *
 * It can be seen that the sequence is repeating. For conciseness, we use the notation √23 = [4;(1,3,1,8)],
 * to indicate that the block (1,3,1,8) repeats indefinitely.
 *
 * The first ten continued fraction representations of (irrational) square roots are:
 * √2=[1;(2)], period=1
 * √3=[1;(1,2)], period=2
 * √5=[2;(4)], period=1
 * √6=[2;(2,4)], period=2
 * √7=[2;(1,1,1,4)], period=4
 * √8=[2;(1,4)], period=2
 * √10=[3;(6)], period=1
 * √11=[3;(3,6)], period=2
 * √12= [3;(2,6)], period=2
 * √13=[3;(1,1,1,1,6)], period=5
 * Exactly four continued fractions, for N ≤ 13, have an odd period.
 *
 * How many continued fractions for N ≤ 10000 have an odd period?
 */

public class Problem064 implements Problem {
    public Number solve() {
        int numberOfOddPeriods = 0;
        for (int n = 1; n <= 10_000; n++) {
            if (getPeriodLength(n) % 2 == 1) {
                numberOfOddPeriods++;
            }
        }

        return numberOfOddPeriods;
    }

    // https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
    private static int getPeriodLength(int n) {
        final double squareRoot = Math.sqrt(n);
        final int a0 = (int) squareRoot;
        int period = 0;

        if (squareRoot != a0) {
            int m = 0;
            int d = 1;
            int a = a0;

            while (2 * a0 != a) {
                m = d * a - m;
                d = (n - m * m) / d;
                a = (a0 + m) / d;
                period++;
            }
        }

        return period;
    }
}
