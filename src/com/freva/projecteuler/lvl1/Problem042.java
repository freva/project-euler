package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

//Euler problem #42:
//How many triangle words does the list of common English words contain?
//Answer: 162, Time: 2ms

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
            for (int j = 1; j < name.length() - 1; j++) {
                sum += name.charAt(j) - 64;
            }

            if (triangleNumbers[sum]) {
                total++;
            }
        }

        return total;
    }
}
