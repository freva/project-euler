package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #046:
 * Answer: 5777, Time: 0ms
 *
 * It was proposed by Christian Goldbach that every odd composite number can be written as the sum of a prime and twice a square.
 * 9 = 7 + 2×1^2
 * 15 = 7 + 2×2^2
 * 21 = 3 + 2×3^2
 * 25 = 7 + 2×3^2
 * 27 = 19 + 2×2^2
 * 33 = 31 + 2×1^2
 * It turns out that the conjecture was false.
 *
 * What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
 */

public class Problem046 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(10_000);

        for (int i = 35; ; i += 2) {
            if (isComposite[i] && !isSumOfTwiceSquareAndPrime(i, isComposite)) {
                return i;
            }
        }
    }

    private static boolean isSumOfTwiceSquareAndPrime(int n, boolean[] isComposite) {
        for (int i = 0, twiceSquare = 1; twiceSquare < n; i++, twiceSquare = 2 * i * i) {
            if (!isComposite[n - twiceSquare]) {
                return true;
            }
        }

        return false;
    }
}
