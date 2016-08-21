package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.math.BigInteger;

//Euler problem #65:
//Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
//Answer: 272, Time: ms

public class Problem065 implements Problem {
    public Number solve() {
        BigInteger prevNumerator = BigInteger.valueOf(2);
        BigInteger currentNumerator = BigInteger.valueOf(3);

        for (int i = 1; i < 99; i++) {
            BigInteger temp = currentNumerator;
            currentNumerator = currentNumerator.multiply(BigInteger.valueOf(getExpansion(i))).add(prevNumerator);
            prevNumerator = temp;
        }

        return Functions.sumOfDigits(currentNumerator);
    }

    private static int getExpansion(int n) {
        if (n % 3 == 1) {
            return 2 * (n / 3 + 1);
        }

        return 1;
    }
}
