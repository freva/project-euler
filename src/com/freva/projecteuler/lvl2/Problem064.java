package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

//Euler problem #64:
//How many continued fractions for N ≤ 10000 have an odd period?
//Answer: 1322, Time: 4ms

public class Problem064 implements Problem {
    public Number solve() {
        int numberOfOddPeriods = 0;
        for (int n = 1; n <= 10000; n++) {
            if (getPeriodLength(n) % 2 == 1) {
                numberOfOddPeriods++;
            }
        }

        return numberOfOddPeriods;
    }

    //https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Continued_fraction_expansion
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
