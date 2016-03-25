package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #37:
//Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
//Answer: 748317, Time: 11ms

public class Problem037 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(1_000_000);

        int sum = 0;
        for (int num = 11; num < isComposite.length; num++) {
            if (! isComposite[num] && isTruncatable(num, isComposite)) {
                sum += num;
            }
        }

        return sum;
    }


    public static boolean isTruncatable(int num, boolean[] isComposite) {
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
