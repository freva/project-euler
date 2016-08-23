package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.math.BigInteger;

/**
 * Project Euler problem #020:
 * Answer: 648, Time: 0ms
 *
 * n! means n × (n − 1) × ... × 3 × 2 × 1
 * For example, 10! = 10 × 9 × ... × 3 × 2 × 1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 *
 * Find the sum of the digits in the number 100!
 */

public class Problem020 implements Problem {
    public Number solve() {
        BigInteger fac100 = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            fac100 = fac100.multiply(BigInteger.valueOf(i));
        }

        return Functions.sumOfDigits(fac100);
    }
}
