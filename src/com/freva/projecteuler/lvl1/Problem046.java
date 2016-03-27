package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #46:
//What is the smallest odd composite that cannot be written as the sum of a prime and twice a square?
//Answer: 5777, Time: 0ms

public class Problem046 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(10000);

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
