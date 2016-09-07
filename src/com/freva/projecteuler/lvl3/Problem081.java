package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #081:
 * Answer: 427337, Time: 6ms
 *
 * Find the minimal path sum in the text file, res/081.txt, containing a 80 by 80 matrix, from the top left to the
 * bottom right by only moving right and down.
 */

public class Problem081 implements Problem {
    public Number solve() {
        int[][] matrix = new int[80][80];
        try (BufferedReader br = new BufferedReader(new FileReader("res/081.txt"))){
            for (int row = 0; row < matrix.length; row++) {
                String[] line = br.readLine().split(",");
                for (int col = 0; col < matrix.length; col++) {
                    matrix[col][row] = Integer.parseInt(line[col]);
                }
            }
        } catch (Exception ignored) { }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] + matrix[i][0];
            matrix[0][i] = matrix[0][i - 1] + matrix[0][i];
        }

        for (int col = 1; col < matrix.length; col++) {
            for (int row = 1; row < matrix.length; row++) {
                matrix[col][row] += Math.min(matrix[col - 1][row], matrix[col][row - 1]);
            }
        }

        return matrix[matrix.length - 1][matrix.length - 1];
    }
}
