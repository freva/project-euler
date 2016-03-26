package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #49:
//Find arithmetic sequences, made of prime terms, whose four digits are permutations of each other.
//Answer: 296962999629, Time: 9ms

public class Problem049 implements Problem {
	public Number solve() {
		final boolean[] isComposite = Functions.sieveOfEratosthenes(9999);

		for (int prime1 = 1488; ; prime1++) {
			if (isComposite[prime1]) continue;
			
			for (int difference = 2; prime1 + 2*difference < 10_000; difference += 2) {
                final int prime2 = prime1 + difference;
                final int prime3 = prime2 + difference;
                if (isComposite[prime2] || isComposite[prime3]) continue;

                if (arePermutationsOfEachOther(prime1, prime2, prime3)) {
                    return Functions.concatenateDigits(prime1, prime2, prime3);
				}
			}
		}
	}

    private static boolean arePermutationsOfEachOther(int... numbers) {
        final int firstSignature = getDigitSignature(numbers[0]);

        for (int i = 1; i<numbers.length; i++) {
            if (firstSignature != getDigitSignature(numbers[i])) {
                return false;
            }
        }

        return true;
    }

    private static int getDigitSignature(int number) {
        final int[] TEN_PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

        int signature = 1;
        while (number > 0) {
            signature *= TEN_PRIMES[number % 10];
            number /= 10;
        }

        return signature;
    }
}
