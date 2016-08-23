package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #033:
 * Answer: 100, Time: 0ms
 *
 * The fraction 49/98 is a curious fraction, as an inexperienced mathematician in attempting to simplify it may
 * incorrectly believe that 49/98 = 4/8, which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * There are exactly four non-trivial examples of this type of fraction, less than one in value, and containing two
 * digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 */

public class Problem033 implements Problem {
    public Number solve() {
        int numProduct = 1, denProduct = 1;
        for (int numerator = 11; numerator < 100; numerator++) {
            if (numerator % 10 == 0) continue;

            for (int denominator = numerator + 1; denominator < 100; denominator++) {
                double altered = -1;
                if (numerator / 10 == denominator % 10) {
                    altered = (double) (numerator % 10) / (denominator / 10);
                } else if (numerator % 10 == denominator / 10) {
                    altered = (double) (numerator / 10) / (denominator % 10);
                }

                if (altered != -1) {
                    final double original = (double) numerator / denominator;

                    if (original == altered) {
                        numProduct *= numerator;
                        denProduct *= denominator;
                    }
                }
            }
        }

        return denProduct / numProduct;
    }
}