package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #030:
 * Answer: 443839, Time: 7ms
 *
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 1634 = 1^4 + 6^4 + 3^4 + 4^4
 * 8208 = 8^4 + 2^4 + 0^4 + 8^4
 * 9474 = 9^4 + 4^4 + 7^4 + 4^4
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 *
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 */

public class Problem030 implements Problem {
    public Number solve() {
        final int[] fifthPowers = new int[10];
        for (int i = 1; i < 10; i++) {
            fifthPowers[i] = (int) Math.pow(i, 5);
        }

        int sum = 0;
        final int limit = 6 * fifthPowers[9];
        for (int i = 10; i < limit; i++) {
            int candidate = i;
            int fifthPowerDigitSum = 0;

            while (candidate > 0) {
                fifthPowerDigitSum += fifthPowers[candidate % 10];
                candidate /= 10;
            }

            if (i == fifthPowerDigitSum) {
                sum += i;
            }
        }

        return sum;
    }
}
