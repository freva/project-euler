package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #089:
 * Answer: 743, Time: 2ms
 *
 * For a number written in Roman numerals to be considered valid there are basic rules which must be followed. Even
 * though the rules allow some numbers to be expressed in more than one way there is always a "best" way of writing a
 * particular number.
 *
 * For example, it would appear that there are at least six ways of writing the number sixteen:
 * IIIIIIIIIIIIIIII
 * VIIIIIIIIIII
 * VVIIIIII
 * XIIIIII
 * VVVI
 * XVI
 *
 * However, according to the rules only XIIIIII and XVI are valid, and the last example is considered to be the most
 * efficient, as it uses the least number of numerals.
 *
 * The text file, res/089.txt, contains one thousand numbers written in valid, but not necessarily minimal, Roman
 * numerals. Find the number of characters saved by writing each of these in their minimal form.
 *
 * Note: You can assume that all the Roman numerals in the file contain no more than four consecutive identical units.
 */

public class Problem089 implements Problem {
    public Number solve() {
        /**
         * Roman numbers length follows the same pattern whether it is ones, tens or hundreds, consider 9, 90 and 900:
         * IX, IC and CM. The length of all of these is 2. In the array below, the value of i'th position denotes
         * the length of the roman representation of that digit, for example, lengthOfDigitInRoman[9] = 2.
         */
        final int[] lengthOfDigitInRoman = {0, 1, 2, 3, 2, 1, 2, 3, 4, 2};
        int numberOfCharactersSaved = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("res/089.txt"))) {
            String romanNumeral;
            while ((romanNumeral = br.readLine()) != null) {
                int value = romanToArabic(romanNumeral);
                int minimalLength = value / 1000; // No way to shorten the thousands, so for each thousand we get an 'M'
                for (int i = 0; i < 3; i++) {
                    minimalLength += lengthOfDigitInRoman[value % 10];
                    value /= 10;
                }

                numberOfCharactersSaved += romanNumeral.length() - minimalLength;
            }
        } catch (Exception ignored) { }

        return numberOfCharactersSaved;
    }

    private static int romanToArabic(String romanNumeral) {
        int value = 0;
        for (int i = 0; i < romanNumeral.length(); i++) {
            char currentLetter = romanNumeral.charAt(i);
            char nextLetter = (i + 1 < romanNumeral.length()) ? romanNumeral.charAt(i + 1) : 0;

            if (currentLetter == 'M') {
                value += 1000;
            } else if (currentLetter == 'D') {
                value += 500;
            } else if (currentLetter == 'C') {
                if (nextLetter == 'M') {
                    value += 900;
                    i++;
                } else if (nextLetter == 'D') {
                    value += 400;
                    i++;
                } else value += 100;
            } else if (currentLetter == 'L') {
                value += 50;
            } else if (currentLetter == 'X') {
                if (nextLetter == 'C') {
                    value += 90;
                    i++;
                } else if (nextLetter == 'L') {
                    value += 40;
                    i++;
                } else value += 10;
            } else if (currentLetter == 'V') {
                value += 5;
            } else if (currentLetter == 'I') {
                if (nextLetter == 'X') {
                    value += 9;
                    i++;
                } else if (nextLetter == 'V') {
                    value += 4;
                    i++;
                } else value += 1;
            }
        }
        return value;
    }
}