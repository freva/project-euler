package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #051:
 * Answer: 121313, Time: 9ms
 *
 * By replacing the 1st digit of the 2-digit number *3, it turns out that six of the nine possible values:
 * 13, 23, 43,53, 73, and 83, are all prime.
 *
 * By replacing the 3rd and 4th digits of 56**3 with the same digit, this 5-digit number is the first example having
 * seven primes among the ten generated numbers, yielding the family: 56003, 56113, 56333, 56443, 56663, 56773,
 * and 56993. Consequently 56003, being the first member of this family, is the smallest prime with this property.
 *
 * Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same
 * digit, is part of an eight prime value family.
 */

public class Problem051 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(1_000_000);

        for (int prime = 56_005; ; prime += 2) {
            if (!isComposite[prime] && Functions.hasDuplicateDigits(prime)) {
                for (int replace = 0; replace < 3; replace++) {
                    if (numberOfPrimeSubstitutions(prime, replace, isComposite) >= 8) {
                        return prime;
                    }
                }
            }
        }
    }

    private static int numberOfPrimeSubstitutions(int prime, int replace, boolean[] isComposite) {
        long reversed = Functions.reverseNumber(prime);
        int mask = 0;

        // Create a mask that matches the digit we want to replace, f.ex. if the prime is 56009, and we wanted to
        // replace 0s, then the mask found would be 110, then we can easily iterate over all replacements of 0 as such:
        // Replace with 2: 56009 + 2 * mask = 56009 + 2*110 = 56229, etc.
        while (reversed > 0) {
            mask *= 10;
            if (reversed % 10 == replace) {
                mask++;
            }
            reversed /= 10;
        }

        // If the mask is 0, then there were no digits matching 'replace' in 'prime', so we can skip
        if (mask == 0) {
            return 0;
        }

        int numberOfPrimeSubstitutions = 1; // Count the initial prime
        int masklessPrime = prime - replace * mask;
        for (int i = replace + 1; i < 10; i++) {
            if (!isComposite[masklessPrime + i * mask]) {
                numberOfPrimeSubstitutions++;
            }
        }
        return numberOfPrimeSubstitutions;
    }
}
