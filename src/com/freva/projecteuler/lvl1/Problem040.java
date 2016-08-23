package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #040:
 * Answer: 210, Time: 0ms
 *
 * An irrational decimal fraction is created by concatenating the positive integers:
 * 0.123456789101112131415161718192021...
 * It can be seen that the 12th digit of the fractional part is 1.
 *
 * If dn represents the nth digit of the fractional part, find the value of the following expression.
 * d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000
 */

public class Problem040 implements Problem {
    public Number solve() {
        return getDigit(10) * getDigit(100) * getDigit(1000) * getDigit(10_000) * getDigit(100_000) * getDigit(1_000_000);
    }

    private static int getDigit(int n) {
        int base = 1, digitsPerNumber = 1;

        for (; n > 9 * digitsPerNumber * base; base *= 10, digitsPerNumber++) {
            n -= 9 * digitsPerNumber * base;
        }

        int numberOrder = (n - 1) / digitsPerNumber;
        int digitOrder = (n - 1) % digitsPerNumber;
        return String.valueOf(base + numberOrder).charAt(digitOrder) - '0';
    }
}
