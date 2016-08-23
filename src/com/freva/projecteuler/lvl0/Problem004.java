package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #004:
 * Answer: 906609, Time: 1ms
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers
 * is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */

public class Problem004 implements Problem {
    public Number solve() {
        int largestPalindrome = 0;

        for (int i = 999; i > 100; i--) {
            for (int j = i; j > 100; j--) {
                final int product = i * j;

                if (product < largestPalindrome) {
                    break;
                }

                if (Functions.isPalindrome(product)) {
                    largestPalindrome = product;
                }
            }
        }

        return largestPalindrome;
    }
}
