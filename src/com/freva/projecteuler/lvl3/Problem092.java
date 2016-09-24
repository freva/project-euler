package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #092:
 * Answer: 8581146, Time: 1ms
 *
 * A number chain is created by continuously adding the square of the digits in a number to form a new number until it
 * has been seen before. For example,
 * 44 → 32 → 13 → 10 → 1 → 1
 * 85 → 89 → 145 → 42 → 20 → 4 → 16 → 37 → 58 → 89
 *
 * Therefore any chain that arrives at 1 or 89 will become stuck in an endless loop. What is most amazing is that
 * EVERY starting number will eventually arrive at 1 or 89.
 *
 * How many starting numbers below ten million will arrive at 89?
 */

public class Problem092 implements Problem {
    public Number solve() {
        // Calculate number of squares that sum up to n. Start with the squares themselves.
        final int[] numberOfSquaresContained = new int[9 * 9 * 7 + 1];
        for (int i = 0; i < 10; i++) {
            numberOfSquaresContained[i * i] = 1;
        }

        // Now calculate up to 7 square digit combinations (since we can have numbers up to 7 digits long
        for (int i = 2; i < 8; i++) {
            for (int k = 9 * 9 * i; k > 0; k--) {
                for (int j = 1; j < 10 && j * j <= k; j++) {
                    numberOfSquaresContained[k] += numberOfSquaresContained[k - j * j];
                }
            }
        }

        int numbersEndingAtEightyNine = 0;
        final boolean[] chainEndsAtEightyNine = new boolean[numberOfSquaresContained.length];
        chainEndsAtEightyNine[89] = true;
        for (int i = 2; i < numberOfSquaresContained.length; i++) {
            int current = i;
            while (current >= i && !chainEndsAtEightyNine[current]) {
                current = sumOfSquareOfTheDigits(current);
            }

            chainEndsAtEightyNine[i] = chainEndsAtEightyNine[current];
            if (chainEndsAtEightyNine[i]) {
                numbersEndingAtEightyNine += numberOfSquaresContained[i];
            }
        }

        return numbersEndingAtEightyNine;
    }

    private static int sumOfSquareOfTheDigits(int number) {
        int sumOfDigitSquares = 0;
        while (number != 0) {
            sumOfDigitSquares += Functions.TEN_SQUARES[number % 10];
            number /= 10;
        }

        return sumOfDigitSquares;
    }
}