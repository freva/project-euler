package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Project Euler problem #098:
 * Answer: 18769, Time: 25ms
 *
 * By replacing each of the letters in the word CARE with 1, 2, 9, and 6 respectively, we form a square number:
 * 1296 = 36^2. What is remarkable is that, by using the same digital substitutions, the anagram, RACE, also forms a
 * square number: 9216 = 96^2. We shall call CARE (and RACE) a square anagram word pair and specify further that
 * leading zeroes are not permitted, neither may a different letter have the same digital value as another letter.
 *
 * Using text file, res/042.txt, containing nearly two-thousand common English words, find all the square anagram word
 * pairs (a palindromic word is NOT considered to be an anagram of itself).
 *
 * What is the largest square number formed by any member of such a pair?
 * NOTE: All anagrams formed must be contained in the given text file.
 */

public class Problem098 implements Problem {
	public Number solve() {
		String[] words = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader("res/042.txt"))) {
            words = br.readLine().split(",");
        } catch (Exception ignored) { }

        // Keep an array of all words with the characters sorted to check if two words are permutations of each other
        final char[][] wordCharacters = new char[words.length][];
        for(int i=0; i<words.length; i++){
            wordCharacters[i] = words[i].toCharArray();
            Arrays.sort(wordCharacters[i]);
        }

        int largestSquare = 0;
        int minLength = 4; // Must be at least as long as RACE/CARE
        for (int i = 0; i < wordCharacters.length; i++) {
            if (wordCharacters[i].length < minLength) continue; // No need to check words shorter than the min square
            int pow = (int) Functions.pow(10, wordCharacters[i].length - 1);

            for (int j = i + 1; j < wordCharacters.length; j++) {
                if (!Arrays.equals(wordCharacters[i], wordCharacters[j])) continue; // Skip if not permutations

                // Find the first number that when squared has the same length as the word
                int base = (int) Math.ceil(Math.sqrt(pow));
                for (int square = base * base; square < 10 * pow; square += 2 * base + 1, base++) {
                    int candidate = translate(words[i], square, words[j]);

                    // Check that the candidate number is as long as the word (Catches leading zeroes and illegal
                    // mappings = -1), then check if the number is actually a square
                    if (candidate > pow && isSquare(candidate)) {
                        if (square > largestSquare || candidate > largestSquare) {
                            largestSquare = Math.max(candidate, square);
                            minLength = wordCharacters[i].length;
                        }
                    }
                }
            }
        }

		return largestSquare;
	}

    /**
     * Takes in a string and a number of the same length, creates a mapping where n'th characters maps to n'th digit,
     * then creates a number by applying the generated map on the second string. F.ex. "CARE", 1296 creates the mapping
     * C => 1, A => 2, R => 9, E => 6. When supplied with second string "RACE", the resulting number is 9216.
     * Returns -1 if mapping is impossible (Same character maps to different numbers)
     */
    private static int translate(String key, int value, String to) {
        final char[] map = new char[10];
        for (int i = key.length() - 1; i >= 0; i--, value /= 10) {
            int digit = value % 10;
            if (map[digit] == 0) map[digit] = key.charAt(i);
            else if (map[digit] != key.charAt(i)) return -1;
        }

        int square = 0;
        String test = new String(map);
        for(char c : to.toCharArray()) {
            square = square * 10 + test.indexOf(c);
        }

        return square;
    }

    private static boolean isSquare(int number) {
        double sqrt = Math.sqrt(number);
        return sqrt == (int) sqrt;
    }
}