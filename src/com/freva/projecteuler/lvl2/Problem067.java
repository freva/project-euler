package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Euler problem #67:
//Find the maximum total from top to bottom of the triangle in 067.txt
//Answer: 7273, Time: 5ms

public class Problem067 implements Problem {
    public Number solve() {
        final int[][] triangle = new int[100][100];

        try (BufferedReader br = new BufferedReader(new FileReader("res/067.txt"))) {
            String line;
            for (int i = 0, j = 0; (line = br.readLine()) != null; i++, j = 0) {
                for (String number : line.split(" ")) {
                    triangle[i][j++] = Integer.parseInt(number);
                }
            }
        } catch (IOException ignored) { }


        for (int j = triangle.length - 1; j >= 1; j--) {
            for (int i = 0; i < triangle[j].length - 1; i++) {
                triangle[j - 1][i] += Math.max(triangle[j][i], triangle[j][i + 1]);
            }
        }

        return triangle[0][0];
    }
}
