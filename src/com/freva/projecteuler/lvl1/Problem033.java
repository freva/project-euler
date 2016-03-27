package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #33:
//If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
//Answer: 100, Time: 0ms

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