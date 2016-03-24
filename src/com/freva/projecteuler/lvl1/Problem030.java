package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #30:
//Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
//Answer: 443839, Time: 7ms

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
