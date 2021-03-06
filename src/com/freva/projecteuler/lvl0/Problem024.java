package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #024:
 * Answer: 2783915460, Time: 0ms
 *
 * A permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits
 * 1, 2, 3 and 4. If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 * The lexicographic permutations of 0, 1 and 2 are: 012, 021, 102, 120, 201 and 210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 */

public class Problem024 implements Problem {
    public Number solve() {
        final int[] digits = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int position = 999_999;

        long permutation = 0;
        for (int n = digits.length; n > 0; n--) {
            int step = Functions.TEN_FACTORIALS[n - 1];
            int r = position / step;
            position -= r * step;

            int rThDigit = -1;
            while (r >= 0) { // Find r'th unused digit
                if (digits[++rThDigit] != -1) {
                    r--;
                }
            }

            permutation = 10 * permutation + digits[rThDigit];
        digits[rThDigit] = -1; // Mark digit as used
        }

        return permutation;
    }
}
