package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.util.ArrayList;

//Euler problem #23:
//Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
//Answer: 4179871, Time: 18ms

public class Problem023 implements Problem {
    public Number solve() {
        final int LIMIT = 21_124;
        final int[] sumOfDivisors = new int[LIMIT];

        for (int i = 1; i < LIMIT / 2; i++) {
            for (int j = 2 * i; j < LIMIT; j += i) {
                sumOfDivisors[j] += i;
            }
        }

        final ArrayList<Integer> abundantNumbers = new ArrayList<>(LIMIT / 3);
        for (int m = 12; m < LIMIT; m++) {
            if (sumOfDivisors[m] > m) {
                abundantNumbers.add(m);
            }
        }

        int sumNonAbundant = LIMIT / 2 * (LIMIT - 1);
        final boolean[] isAbundantNumber = new boolean[LIMIT];
        for (int i = 0; i < abundantNumbers.size(); i++) {
            for (int j = i, sum; (sum = abundantNumbers.get(i) + abundantNumbers.get(j)) < LIMIT; j++) {
                if (!isAbundantNumber[sum]) {
                    isAbundantNumber[sum] = true;
                    sumNonAbundant -= sum;
                }
            }
        }

        return sumNonAbundant;
    }
}
