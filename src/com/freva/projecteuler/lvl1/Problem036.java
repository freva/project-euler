package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #036:
 * Answer: 872187, Time: 9ms
 *
 * The decimal number, 585 = 1001001001_2 (binary), is palindromic in both bases.
 * Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
 * NOTE: The palindromic number, in either base, may not include leading zeros.
 */

public class Problem036 implements Problem {
    public Number solve() {
        int sum = 0;

        for (int i = 1; i < 1_000_000; i += 2) {
            if (Functions.isPalindrome(i) && i == reverseBinary(i)) {
                sum += i;
            }
        }

        return sum;
    }

    private static int reverseBinary(int number) {
        int reversed = 0;
        while (number > 0) {
            reversed = (reversed << 1) | (number & 1);
            number >>= 1;
        }

        return reversed;
    }
}
