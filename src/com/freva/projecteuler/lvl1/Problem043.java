package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.util.Arrays;

//Euler problem #43:
//Find the sum of all pandigital numbers with an unusual sub-string divisibility property.
//Answer: 16695334890, Time: 0ms

public class Problem043 implements Problem {
    public Number solve() {
        final int[] primes = {13, 11, 7, 5, 3, 2};

        int[] incompleteNumbers = new int[999 / 17];
        for (int factor = 1; factor <= incompleteNumbers.length; factor++) {
            incompleteNumbers[factor - 1] = 17 * factor;
        }

        for (int i = 0, pow10 = 10; i < primes.length; i++, pow10 *= 10) {
            final int[] generatedNumbers = new int[incompleteNumbers.length * 2];
            int count = 0;
            for (int incomplete : incompleteNumbers) {
                final int lastDigits = incomplete / pow10;
                for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
                    final int threeDigits = nextDigit * 100 + lastDigits;
                    final int fullNumber = nextDigit * pow10 * 100 + incomplete;
                    if (threeDigits % primes[i] == 0 && ! Functions.hasDuplicateDigits(fullNumber)) {
                        generatedNumbers[count++] = fullNumber;
                    }
                }
            }
            incompleteNumbers = Arrays.copyOf(generatedNumbers, count);
        }

        long sum = 0;
        for (int incomplete : incompleteNumbers) {
            long complete = getMissingDigit(incomplete) * 1000000000L + incomplete;

            if (! Functions.hasDuplicateDigits(complete)) {
                sum += complete;
            }
        }
        return sum;
    }

    private static int getMissingDigit(int number) {
        int missing = 45; //Sum of the 10 single digits
        while (number > 0) {
            missing -= number % 10;
            number /= 10;
        }

        return missing;
    }
}
