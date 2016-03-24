package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #35:
//How many circular primes are there below one million?
//Answer: 55, Time: 17ms

public class Problem035 implements Problem {
	public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(1_000_000);

		int numberOfCircularPrimes = 0;
		for (int i = 2; i < isComposite.length; i++) {
            if (isComposite[i]) continue;

			if (isCircularPrime(i, isComposite)) {
                numberOfCircularPrimes++;
            }
        }
		
		return numberOfCircularPrimes;
	}

    private static boolean isCircularPrime(int prime, boolean[] isComposite) {
        final int tenPower = (int) Math.pow(10, Math.floor(Math.log10(prime)));

        int candidate = prime;
        do {
            candidate = tenPower * (candidate % 10) + candidate / 10; //Rotate the number

            if (isComposite[candidate]) return false;
        } while(candidate != prime);

        return true;
    }
}
