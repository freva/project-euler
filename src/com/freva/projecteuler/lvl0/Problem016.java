package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.math.BigInteger;

//Euler problem #16:
//What is the sum of the digits of the number 2^1000?
//Answer: 1366, Time: 0ms

public class Problem016 implements Problem {
    public Number solve() {
        BigInteger number = BigInteger.ONE.shiftLeft(1000);

        return Functions.sumOfDigits(number);
    }
}
