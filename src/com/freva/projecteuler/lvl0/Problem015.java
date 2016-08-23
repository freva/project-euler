package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #016:
 * Answer: 137846528820, Time: 0ms
 *
 * Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down, there are exactly
 * 6 routes to the bottom right corner.
 *
 * How many such routes are there through a 20×20 grid?
 */

public class Problem015 implements Problem {
    public Number solve() {
        final int size = 21;
        final long[][] grid = new long[size][size];

        for (int i = 0; i < size; i++) {
            grid[i][0] = grid[0][i] = 1;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j <= i; j++) {
                grid[j][i] = grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }

        return grid[size - 1][size - 1];
    }
}
