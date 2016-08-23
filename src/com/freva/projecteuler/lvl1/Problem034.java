package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #034:
 * Answer: 40730, Time: 3ms
 *
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 */

public class Problem034 implements Problem {
    public Number solve() {
        int sum = 0;

        for (int n = 10; n < 50_000; n++) {
            int candidate = n;
            int factorialDigitSum = 0;

            while (candidate > 0) {
                factorialDigitSum += Functions.TEN_FACTORIALS[candidate % 10];
                candidate /= 10;
            }

            if (factorialDigitSum == n) {
                sum += n;
            }
        }

        return sum;
    }
}
