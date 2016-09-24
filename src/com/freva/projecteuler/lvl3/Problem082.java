package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.ArrayFunctions;
import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #082:
 * Answer: 260324, Time: 6ms
 *
 * NOTE: This problem is a more challenging version of Problem 81.
 * Find the minimal path sum in the text file, res/081.txt, containing a 80 by 80 matrix, by starting in any cell in
 * the left column and finishing in any cell in the right column, and only moving up, down, and right.
 */

public class Problem082 implements Problem {
    public Number solve() {
        int[][] matrix = new int[80][80];
        int[][] rows = new int[matrix.length][matrix.length];
        try (BufferedReader br = new BufferedReader(new FileReader("res/081.txt"))) {
            for (int row = 0; row < matrix.length; row++) {
                String[] line = br.readLine().split(",");
                for (int col = 0; col < matrix.length; col++) {
                    matrix[col][row] = rows[col][row] = Integer.parseInt(line[col]);
                }
            }
        } catch (Exception ignored) { }

        for (int col = 1; col < matrix.length; col++) {
            // Set the top most cell's value for this column as the best of going from top most cell from previous
            // column or from going from second top most cell in previous column via the cell directly under the current
            matrix[col][0] += Math.min(matrix[col - 1][0], matrix[col - 1][1] + rows[col][1]);

            // Then simply propagate the values downwards as the best between from going from previous column or from
            // going from cell directly above the current
            for (int row = 1; row < matrix.length; row++) {
                matrix[col][row] += Math.min(matrix[col - 1][row], matrix[col][row - 1]);
            }

            // Repeat same process but now propagating from the bottom to the top
            for (int row = matrix.length - 2; row >= 0; row--) {
                matrix[col][row] = Math.min(matrix[col][row], matrix[col][row + 1] + rows[col][row]);
            }
        }

        return ArrayFunctions.min(matrix[matrix.length - 1]);
    }
}
