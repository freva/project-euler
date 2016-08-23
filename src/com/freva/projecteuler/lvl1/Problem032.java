package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #032:
 * Answer: 45228, Time: 5ms
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example,
 * the 5-digit number, 15234, is 1 through 5 pandigital.
 * The product 7254 is unusual, as the identity, 39 × 186 = 7254, containing multiplicand, multiplier, and product is
 * 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 */

public class Problem032 implements Problem {
    public Number solve() {
        final int limit = 123_456_789; // Smallest 1-9 pandigital number
        final boolean[] countedProducts = new boolean[10_000];

        int sum = 0;
        for (int multiplicand = 2; multiplicand < 99; multiplicand++) {
            if (multiplicand % 10 == 0 || multiplicand % 11 == 0) continue;

            for (int multiplier = 123, product; (product = multiplicand * multiplier) < 9876; multiplier++) {
                if (countedProducts[product]) continue;

                long candidate = Functions.concatenateDigits(multiplicand, multiplier, product);
                if (candidate >= limit && Functions.isPandigital(candidate)) {
                    countedProducts[product] = true;
                    sum += product;
                }
            }
        }

        return sum;
    }
}
