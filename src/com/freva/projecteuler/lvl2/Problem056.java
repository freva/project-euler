package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.math.BigInteger;

//Euler problem #56:
//Considering natural numbers of the form, a^b, where a, b < 100, what is the maximum digital sum?
//Answer: 972, Time: 8ms

public class Problem056 implements Problem {
    public Number solve() {
        int largestDigitSum = 0;
        for (int a = 90; a < 100; a++) {
            for (int b = 90; b < 100; b++) {
                BigInteger aPowB = BigInteger.valueOf(a).pow(b);
                int digitSum = Functions.sumOfDigits(aPowB);

                if (digitSum > largestDigitSum) {
                    largestDigitSum = digitSum;
                }
            }
        }

        return largestDigitSum;
    }
}
