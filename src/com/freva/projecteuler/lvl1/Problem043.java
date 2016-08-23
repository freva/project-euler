package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.util.Arrays;

/**
 * Project Euler problem #043:
 * Answer: 16695334890, Time: 0ms
 *
 * The number, 1406357289, is a 0 to 9 pandigital number because it is made up of each of the digits 0 to 9 in some
 * order, but it also has a rather interesting sub-string divisibility property.
 *
 * Let d1 be the 1st digit, d2 be the 2nd digit, and so on. In this way, we note the following:
 * d2d3d4=406 is divisible by 2
 * d3d4d5=063 is divisible by 3
 * d4d5d6=635 is divisible by 5
 * d5d6d7=357 is divisible by 7
 * d6d7d8=572 is divisible by 11
 * d7d8d9=728 is divisible by 13
 * d8d9d10=289 is divisible by 17
 *
 * Find the sum of all 0 to 9 pandigital numbers with this property.
 */

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
                    if (threeDigits % primes[i] == 0 && !Functions.hasDuplicateDigits(fullNumber)) {
                        generatedNumbers[count++] = fullNumber;
                    }
                }
            }
            incompleteNumbers = Arrays.copyOf(generatedNumbers, count);
        }

        long sum = 0;
        for (int incomplete : incompleteNumbers) {
            long complete = getMissingDigit(incomplete) * 1_000_000_000L + incomplete;

            if (!Functions.hasDuplicateDigits(complete)) {
                sum += complete;
            }
        }
        return sum;
    }

    private static int getMissingDigit(int number) {
        int missing = 45; // Sum of the 10 single digits
        while (number > 0) {
            missing -= number % 10;
            number /= 10;
        }

        return missing;
    }
}
