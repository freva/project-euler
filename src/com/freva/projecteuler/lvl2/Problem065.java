package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.math.BigInteger;

/**
 * Project Euler problem #065:
 * Answer: 272, Time: 2ms
 *
 * The infinite continued fraction can be written, √2 = [1;(2)], (2) indicates that 2 repeats ad infinitum.
 * In a similar way, √23 = [4;(1,3,1,8)].
 *
 * It turns out that the sequence of partial values of continued fractions for square roots provide the best rational
 * approximations. The sequence of the first ten convergents for √2 are:
 * 1, 3/2, 7/5, 17/12, 41/29, 99/70, 239/169, 577/408, 1393/985, 3363/2378, ...
 *
 * What is most surprising is that the important mathematical constant,
 * e = [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...].
 *
 * The first ten terms in the sequence of convergents for e are:
 * 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536, ...
 * The sum of digits in the numerator of the 10th convergent is 1+4+5+7=17.
 *
 * Find the sum of digits in the numerator of the 100th convergent of the continued fraction for e.
 */

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
