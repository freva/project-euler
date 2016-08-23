package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #037:
 * Answer: 748317, Time: 11ms
 *
 * The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from
 * left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left:
 * 3797, 379, 37, and 3.
 *
 * Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
 * NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.
 */

public class Problem037 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(1_000_000);

        int sum = 0;
        for (int num = 11; num < isComposite.length; num++) {
            if (!isComposite[num] && isTruncatable(num, isComposite)) {
                sum += num;
            }
        }

        return sum;
    }

    private static boolean isTruncatable(int num, boolean[] isComposite) {
        for (int temp = num; temp > 0; temp /= 10) {
            if (isComposite[temp]) {
                return false;
            }
        }

        for (int mod = 10; mod < num; mod *= 10) {
            if (isComposite[num % mod]) {
                return false;
            }
        }

        return true;
    }
}
