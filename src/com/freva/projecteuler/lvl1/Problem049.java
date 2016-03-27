package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #49:
//Find arithmetic sequences, made of prime terms, whose four digits are permutations of each other.
//Answer: 296962999629, Time: 7ms

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
