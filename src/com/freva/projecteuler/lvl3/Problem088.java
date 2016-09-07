package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.util.Arrays;

/**
 * Project Euler problem #088:
 * Answer: 7587457, Time: 12ms
 *
 * A natural number, N, that can be written as the sum and product of a given set of at least two natural numbers,
 * {a1, a2, ... , ak} is called a product-sum number: N = a1 + a2 + ... + ak = a1 × a2 × ... × ak.
 * For example, 6 = 1 + 2 + 3 = 1 × 2 × 3.
 *
 * For a given set of size, k, we shall call the smallest N with this property a minimal product-sum number. The
 * minimal product-sum numbers for sets of size, k = 2, 3, 4, 5, and 6 are as follows.
 * k=2: 4 = 2 × 2 = 2 + 2
 * k=3: 6 = 1 × 2 × 3 = 1 + 2 + 3
 * k=4: 8 = 1 × 1 × 2 × 4 = 1 + 1 + 2 + 4
 * k=5: 8 = 1 × 1 × 2 × 2 × 2 = 1 + 1 + 2 + 2 + 2
 * k=6: 12 = 1 × 1 × 1 × 1 × 2 × 6 = 1 + 1 + 1 + 1 + 2 + 6
 *
 * Hence for 2 ≤ k ≤ 6, the sum of all the minimal product-sum numbers is 4 + 6 + 8 + 12 = 30; note that 8 is only
 * counted once in the sum.
 *
 * In fact, as the complete set of minimal product-sum numbers for 2 ≤ k ≤ 12 is {4, 6, 8, 12, 15, 16}, the sum is 61.
 *
 * What is the sum of all the minimal product-sum numbers for 2 ≤ k ≤ 12000?
 */

public class Problem088 implements Problem {
    /**
     * Note that N=2k is a solution with [k, 2, 1, 1, ..., 1] with k-2 ones.
     * Therefore, we iterate over all non-trivial factors that multiply to <= 2*12 000, then we can always find a
     * solution with N = product of all factors or sum of factors, if sum of factors != product of factors, we can
     * always add enough ones to make them equal without changing the product. Then, k = product - sum + count, where
     * the sum is the sum of all non-one factors and count is the number of non-one factors.
     */
    public Number solve() {
        final int limit = 12_000;
        final int maxLength = (int) (Math.log(limit) / Math.log(2));

        int[] smallestProductSumNumber = new int[limit + 1];
        Arrays.fill(smallestProductSumNumber, Integer.MAX_VALUE);

        int[] factors = {2, 2};
        while (factors.length <= maxLength) {
            int sum = 0, product = 1;
            for (int factor : factors) {
                sum += factor;
                product *= factor;
            }

            int k = product - sum + factors.length;
            // If we find a smaller product-sum number for a given k, update it
            if (0 < k && k < smallestProductSumNumber.length && product < smallestProductSumNumber[k]) {
                smallestProductSumNumber[k] = product;
            }

            // Find the index of the next factor we can increment
            int pos = factors.length - 1;
            while (pos >= 0 && product > 2 * limit) {
                product = (pos-- > 0) ? (int) Functions.pow(factors[pos] + 1, factors.length - pos) : 1;
                for (int i = 0; i < pos; i++) {
                    product *= factors[i];
                }
            }

            // Generate factors of next product-sum number candidate
            if (pos < 0) { // There is no other factor we can increment, so we increase the number of factors by 1
                factors = new int[factors.length + 1];
                Arrays.fill(factors, 2);
            } else {
                factors[pos++]++; // Otherwise, increment that factor and change the values of consecutive factors
                for (; pos < factors.length; pos++) {
                    factors[pos] = factors[pos - 1];
                }
            }
        }

        int total = 0;
        final boolean[] distinctK = new boolean[2 * limit + 1];
        for (int k = 2; k < smallestProductSumNumber.length; k++) {
            if (!distinctK[smallestProductSumNumber[k]]) {
                distinctK[smallestProductSumNumber[k]] = true;
                total += smallestProductSumNumber[k];
            }
        }

        return total;
    }
}