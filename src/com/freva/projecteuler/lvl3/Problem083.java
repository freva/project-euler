package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

/**
 * Project Euler problem #083:
 * Answer: 425185, Time: 15ms
 *
 * NOTE: This problem is a significantly more challenging version of Problem 81.
 *
 * Find the minimal path sum in text file, res/081.txt, containing a 80 by 80 matrix, from the top left to the bottom
 * right by moving left, right, up, and down.
 */

public class Problem083 implements Problem {
    public Number solve() {
        int[][] matrix = new int[80][80];
        try (BufferedReader br = new BufferedReader(new FileReader("res/081.txt"))) {
            for (int row = 0; row < matrix.length; row++) {
                String[] line = br.readLine().split(",");
                for (int col = 0; col < matrix.length; col++) {
                    matrix[col][row] = Integer.parseInt(line[col]);
                }
            }
        } catch (Exception ignored) { }

        int[][] map = shortestPathBellmanFord(matrix);
        return map[map.length - 1][map.length - 1];
    }

    private static int[][] shortestPathBellmanFord(int[][] grid) {
        int[][] map = new int[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        map[0][0] = grid[0][0];

        int updated;
        do {
            updated = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid.length; col++) {
                    if (col > 0 && map[col][row] + grid[col - 1][row] < map[col - 1][row]) {
                        map[col - 1][row] = map[col][row] + grid[col - 1][row];
                        updated++;
                    }

                    if (col < grid.length - 1 && map[col][row] + grid[col + 1][row] < map[col + 1][row]) {
                        map[col + 1][row] = map[col][row] + grid[col + 1][row];
                        updated++;
                    }

                    if (row > 0 && map[col][row] + grid[col][row - 1] < map[col][row - 1]) {
                        map[col][row - 1] = map[col][row] + grid[col][row - 1];
                        updated++;
                    }

                    if (row < grid.length - 1 && map[col][row] + grid[col][row + 1] < map[col][row+1]) {
                        map[col][row + 1] = map[col][row] + grid[col][row + 1];
                        updated++;
                    }
                }
            }
        } while(updated != 0);

        return map;
    }
}
