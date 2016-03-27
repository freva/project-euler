package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #40:
//If dn represents the nth digit of the fractional part, find the value of the following expression:
//d1 x d10 x d100 x d1000 x d10000 x d100000 x d1000000
//Answer: 210, Time: 0ms

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
