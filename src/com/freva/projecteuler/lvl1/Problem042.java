package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #042:
 * Answer: 162, Time: 2ms
 *
 * The nth term of the sequence of triangle numbers is given by, tn = n(n+1)/2; so the first ten triangle numbers are:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * By converting each letter in a word to a number corresponding to its alphabetical position and adding these values
 * we form a word value. For example, the word value for SKY is 19 + 11 + 25 = 55 = t10. If the word value is a
 * triangle number then we shall call the word a triangle word.
 *
 * Using the file res/042.txt, containing nearly two-thousand common English words, how many are triangle words?
 */

public class Problem042 implements Problem {
    public Number solve() {
        String[] names = new String[0];

        try (BufferedReader br = new BufferedReader(new FileReader("res/042.txt"))) {
            names = br.readLine().split(",");
        } catch (Exception ignored) { }

        final int numberOfTriangleNumbers = 20;
        final boolean[] triangleNumbers = new boolean[numberOfTriangleNumbers * (numberOfTriangleNumbers + 1) / 2 + 1];
        for (int i = 0; i < numberOfTriangleNumbers; i++) {
            triangleNumbers[i * (i + 1) / 2] = true;
        }

        int total = 0;
        for (String name : names) {
            int sum = 0;
            for (int j = 0; j < name.length(); j++) {
                sum += name.charAt(j) - 'A' + 1;
            }

            if (triangleNumbers[sum]) {
                total++;
            }
        }

        return total;
    }
}
