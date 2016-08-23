package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #023:
 * Answer: 4179871, Time: 11ms
 *
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number. For example,
 * the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this
 * sum exceeds n.
 *
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16, the smallest number that can be written as the sum
 * of two abundant numbers is 24. By mathematical analysis, it can be shown that all integers greater than 28123 can
 * be written as the sum of two abundant numbers. However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is
 * less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 */

public class Problem023 implements Problem {
    public Number solve() {
        final int LIMIT = 21_124;
        final int[] sumOfDivisors = new int[LIMIT];

        for (int i = 1; i < LIMIT / 2; i++) {
            for (int j = 2 * i; j < LIMIT; j += i) {
                sumOfDivisors[j] += i;
            }
        }

        int numberOfAbundantNumbers = 0;
        final int[] abundantNumbers = new int[LIMIT / 3];
        for (int m = 12; m < LIMIT; m++) {
            if (sumOfDivisors[m] > m) {
                abundantNumbers[numberOfAbundantNumbers++] = m;
            }
        }

        int sumNonAbundant = LIMIT / 2 * (LIMIT - 1);
        final boolean[] isAbundantNumber = new boolean[LIMIT];
        for (int i = 0; i < numberOfAbundantNumbers; i++) {
            for (int j = i, sum; (sum = abundantNumbers[i] + abundantNumbers[j]) < LIMIT; j++) {
                if (!isAbundantNumber[sum]) {
                    isAbundantNumber[sum] = true;
                    sumNonAbundant -= sum;
                }
            }
        }

        return sumNonAbundant;
    }
}
