package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #049:
 * Answer: 296962999629, Time: 7ms
 *
 * The arithmetic sequence, 1487, 4817, 8147, in which each of the terms increases by 3330, is unusual in two ways:
 * (i) each of the three terms are prime, and,
 * (ii) each of the 4-digit numbers are permutations of one another.
 *
 * There are no arithmetic sequences made up of three 1-, 2-, or 3-digit primes, exhibiting this property, but there
 * is one other 4-digit increasing sequence.
 *
 * What 12-digit number do you form by concatenating the three terms in this sequence?
 */

public class Problem049 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(9999);

        for (int prime1 = 1488; ; prime1++) {
            if (isComposite[prime1]) continue;

            for (int difference = 2; prime1 + 2 * difference < 10_000; difference += 2) {
                final int prime2 = prime1 + difference;
                final int prime3 = prime2 + difference;
                if (isComposite[prime2] || isComposite[prime3]) continue;

                if (Functions.arePermutationsOfEachOther(prime1, prime2, prime3)) {
                    return Functions.concatenateDigits(prime1, prime2, prime3);
                }
            }
        }
    }
}
