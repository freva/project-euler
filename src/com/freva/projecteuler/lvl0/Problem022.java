package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Project Euler problem #022:
 * Answer: 871198282, Time: 9ms
 *
 * Using the file res/022.txt, containing over five-thousand first names, begin by sorting it into alphabetical order.
 * Then working out the alphabetical value for each name, multiply this value by its alphabetical position in the list
 * to obtain a name score.
 *
 * For example, when the list is sorted into alphabetical order, COLIN, which is worth 3 + 15 + 12 + 9 + 14 = 53, is
 * the 938th name in the list. So, COLIN would obtain a score of 938 × 53 = 49714.
 *
 * What is the total of all the name scores in the file?
 */

public class Problem022 implements Problem {
    public Number solve() {
        String[] names = new String[0];
        try (BufferedReader br = new BufferedReader(new FileReader("res/022.txt"))) {
            names = br.readLine().split(",");
        } catch (Exception ignored) { }

        Arrays.sort(names);
        int nameScoresTotal = 0;
        for (int i = 0; i < names.length; i++) {
            for (int j = 1; j < names[i].length() - 1; j++) {
                nameScoresTotal += (i + 1) * (names[i].charAt(j) - 'A' + 1);
            }
        }

        return nameScoresTotal;
    }
}
