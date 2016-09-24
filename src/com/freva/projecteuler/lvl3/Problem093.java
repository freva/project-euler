package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.ArrayFunctions;
import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #093:
 * Answer: 1258, Time: 19ms
 *
 * By using each of the digits from the set, {1, 2, 3, 4}, exactly once, and making use of the four arithmetic
 * operations (+, −, *, /) and brackets/parentheses, it is possible to form different positive integer targets.
 *
 * For example,
 * 8 = (4 * (1 + 3)) / 2
 * 14 = 4 * (3 + 1 / 2)
 * 19 = 4 * (2 + 3) − 1
 * 36 = 3 * 4 * (2 + 1)
 *
 * Note that concatenations of the digits, like 12 + 34, are not allowed.
 * Using the set, {1, 2, 3, 4}, it is possible to obtain thirty-one different target numbers of which 36 is the
 * maximum, and each of the numbers 1 to 28 can be obtained before encountering the first non-expressible number.
 *
 * Find the set of four distinct digits, a < b < c < d, for which the longest set of consecutive positive integers,
 * 1 to n, can be obtained, giving your answer as a string: abcd.
 */

public class Problem093 implements Problem {
    public Number solve() {
        int longestConsecutiveChainLength = 0;
        int digitsProducingLongestChain = 0;

        // Iterate over all distinct a, b, c, d digits and calculate the consecutive chain length it produces
        for (int a = 1; a <= 9; a++) {
            for (int b = a + 1; b <= 9; b++) {
                for (int c = b + 1; c <= 9; c++) {
                    for (int d = c + 1; d <= 9; d++) {
                        int consecutiveChainLength = calculateConsecutiveChainLength(a, b, c, d);

                        if (consecutiveChainLength > longestConsecutiveChainLength) {
                            longestConsecutiveChainLength = consecutiveChainLength;
                            digitsProducingLongestChain = (int) Functions.concatenateDigits(a, b, c, d);
                        }
                    }
                }
            }
        }
        return digitsProducingLongestChain;
    }

    private static int calculateConsecutiveChainLength(int... digits) {
        long expressible = 1L;

        do { // Iterate over all permutations of digits
            for (int op1 = 0; op1 < 4; op1++) {
                for (int op2 = 0; op2 < 4; op2++) {
                    for (int op3 = 0; op3 < 4; op3++) {
                        // Iterate over all operands and evaluate expression. Mark the number as appeared by setting
                        // that numbers bit. Assumes the longest chain is < 64.
                        double ans = eval(eval(eval(digits[0], digits[1], op1), digits[2], op2), digits[3], op3);
                        if(0 < ans && ans < 64 && ans == (int) ans) expressible |= 1L << ((int) ans);

                        ans = eval(eval(digits[0], digits[1], op1), eval(digits[2], digits[3], op2), op3);
                        if(0 < ans && ans < 64 && ans == (int) ans) expressible |= 1L << ((int) ans);
                    }
                }
            }
        } while (ArrayFunctions.nextPermutation(digits));

        // Each number that has appeared is set to 1, we want to find number of trailing ones
        return Long.numberOfTrailingZeros(~expressible);
    }

    private static double eval(double num1, double num2, int op){
        switch (op) {
            case 0: return num1 + num2;
            case 1: return num1 - num2;
            case 2: return num1 * num2;
            case 3: return num1 / num2;
        }
        return -1;
    }
}