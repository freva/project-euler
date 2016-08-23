package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Project Euler problem #067:
 * Answer: 7273, Time: 5ms
 *
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total
 * from top to bottom is 23.
 *      3
 *     7 4
 *    2 4 6
 *   8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 *
 * Find the maximum total from top to bottom in the file res/067.txt, containing a triangle with one-hundred rows.
 * NOTE: This is a much more difficult version of Problem 18. It is not possible to try every route to solve this
 * problem, as there are 299 altogether! If you could check one trillion (1012) routes every second it would take
 * over twenty billion years to check them all. There is an efficient algorithm to solve it. ;o)
 */

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
