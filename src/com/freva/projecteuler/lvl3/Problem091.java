package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #091:
 * Answer: 14234, Time: 1ms
 *
 * The points P (x1, y1) and Q (x2, y2) are plotted at integer co-ordinates and are joined to the origin, O(0,0), to
 * form ΔOPQ.
 *
 * There are exactly fourteen triangles containing a right angle that can be formed when each co-ordinate lies between
 * 0 and 2 inclusive; that is, 0 ≤ x1, y1, x2, y2 ≤ 2.
 *
 * Given that 0 ≤ x1, y1, x2, y2 ≤ 50, how many right triangles can be formed?
 */

public class Problem091 implements Problem {
    public Number solve() {
        /**
         * There are 4 different ways to form integer right angle triangle:
         * 1. Right angle in origin, there are 50^2 of these
         * 2. Right angle somewhere on x-axis, there are 50^2 of these
         * 3. Right angle somewhere on y-axis, there are 50^2 of these
         * 4. Right angle at (x, y) where x ≠ 0 and y ≠ 0.
         *      For this case, the solution will be on the line (x + k * y/gcd, y - k * x/gcd), where gcd is greatest
         *      common divisor of x and y.
         */
        final int dimension = 50;
        int total = 3 * dimension * dimension;
        for (int x = 1; x <= dimension; x++) {
            for (int y = 1; y <= dimension; y++) {
                int gcd = (int) Functions.greatestCommonDivisor(x, y);
                total += 2 * Math.min(y * gcd / x, (dimension - x) * gcd / y);
            }
        }

        return total;
    }
}