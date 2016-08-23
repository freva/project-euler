package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.math.BigInteger;

/**
 * Project Euler problem #016:
 * Answer: 1366, Time: 0ms
 *
 * 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2^1000?
 */

public class Problem016 implements Problem {
    public Number solve() {
        BigInteger number = BigInteger.ONE.shiftLeft(1000);

        return Functions.sumOfDigits(number);
    }
}
