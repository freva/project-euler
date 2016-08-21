package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

//Euler problem #59:
//A file containing the encrypted ASCII codes, and the knowledge that the plain text must contain common English words,
//decrypt the message and find the sum of the ASCII values in the original text
//Answer: 107359, Time: 1ms

public class Problem059 implements Problem {
    public Number solve() {
        final int[][] counts = new int[3][128];
        try (BufferedReader br = new BufferedReader(new FileReader("res/059.txt"))) {
            int letter = 0;
            for (String number : br.readLine().split(",")) {
                counts[letter++ % 3][Integer.parseInt(number)]++;
            }
        } catch (Exception ignored) { }

        int sum = 0;
        for (int[] count : counts) {
            int enc = findIndexOfLargest(count) ^ ' ';
            for (int freq = 0; freq < count.length; freq++) {
                sum += (freq ^ enc) * count[freq];
            }
        }

        return sum;
    }

    private static int findIndexOfLargest(int array[]) {
        int largestIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largestIndex]) {
                largestIndex = i;
            }
        }

        return largestIndex;
    }
}
