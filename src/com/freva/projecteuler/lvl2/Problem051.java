package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #51:
//Find the smallest prime which, by replacing part of the number (not necessarily adjacent digits) with the same digit,
//is part of an eight prime value family.
//Answer: 121313, Time: 9ms

public class Problem051 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(1_000_000);

        for (int prime = 56005; ; prime += 2) {
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

        //Create a mask that matches the digit we want to replace, f.ex. if the prime is 56009, and we wanted to
        //replace 0s, then the mask found would be 110, then we can easily iterate over all replacements of 0 as such:
        //Replace with 2: 56009 + 2 * mask = 56009 + 2*110 = 56229, etc.
        while (reversed > 0) {
            mask *= 10;
            if (reversed % 10 == replace) {
                mask++;
            }
            reversed /= 10;
        }

        //If the mask is 0, then there were no digits matching 'replace' in 'prime', so we can skip
        if (mask == 0) {
            return 0;
        }

        int count = 1; //Count the initial prime
        int masklessPrime = prime - replace * mask;
        for (int i = replace + 1; i < 10; i++) {
            if (!isComposite[masklessPrime + i * mask]) {
                count++;
            }
        }
        return count;
    }
}
