package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.math.BigInteger;

//Euler problem #20:
//Find the sum of the digits in the number 100!
//Answer: 648, Time: 0ms

public class Problem020 implements Problem {
    public Number solve() {
        BigInteger fac100 = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            fac100 = fac100.multiply(BigInteger.valueOf(i));
        }

        int sumOfDigits = 0;
        for (char c : fac100.toString().toCharArray()) {
            sumOfDigits += c - '0';
        }

        return sumOfDigits;
    }
}
