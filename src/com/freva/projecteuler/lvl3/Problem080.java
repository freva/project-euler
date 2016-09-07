package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Project Euler problem #080:
 * Answer: 40886, Time: 22ms
 *
 * It is well known that if the square root of a natural number is not an integer, then it is irrational. The decimal
 * expansion of such square roots is infinite without any repeating pattern at all. The square root of two is
 * 1.41421356237309504880..., and the digital sum of the first one hundred decimal digits is 475.
 *
 * For the first one hundred natural numbers, find the total of the digital sums of the first one hundred decimal
 * digits for all the irrational square roots.
 */

public class Problem080 implements Problem {
    public Number solve() {
        final int precision = 100;
        final BigDecimal two = BigDecimal.valueOf(2);

        BigDecimal xn;
        int sumOfFirstHundredDecimals = 0;
        for (int i = 2; i < 100; i++) {
            BigDecimal xn1 = BigDecimal.ONE;
            BigDecimal n = BigDecimal.valueOf(i);
            do {
                xn = xn1;
                //xn1 = xn - (xn^2 - c) / (2 * xn)
                xn1 = xn.subtract(
                        xn.pow(2).subtract(n).divide(two.multiply(xn), precision + 1, RoundingMode.HALF_DOWN));
            } while (! xn.equals(xn1));

            for (int j = 0; j <= precision; j++) {
                sumOfFirstHundredDecimals += xn1.toString().toCharArray()[j] - '0';
            }
        }

        // Subtract all the even square roots and all the ASCII values from the '.' mark in each decimal
        return sumOfFirstHundredDecimals - 44 - 98 * ('.' - '0'); //2 + 3 + 4 + 5 + 6 + 7 + 8 + 9
    }
}
