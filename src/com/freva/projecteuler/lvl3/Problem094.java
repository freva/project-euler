package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #094:
 * Answer: 518408346, Time: 0ms
 *
 * It is easily proved that no equilateral triangle exists with integral length sides and integral area. However, the
 * almost equilateral triangle 5-5-6 has an area of 12 square units.
 *
 * We shall define an almost equilateral triangle to be a triangle for which two sides are equal and the third differs
 * by no more than one unit.
 *
 * Find the sum of the perimeters of all almost equilateral triangles with integral side lengths and area and whose
 * perimeters do not exceed one billion (1,000,000,000).
 */

public class Problem094 implements Problem {
	public Number solve() {
        /**
         * If the sides are (a, a, a+1), then the area is: A = h * w / 2 = sqrt(a^2 - ((a+1)/2)^2) * (a+1) / 2
         * = sqrt(1/4 * (3a^2 - 2a - 1)) * (a+1) / 2 = sqrt(3a^2 - 2a - 1) * (a+1) / 4
         *
         * We want 3a^2 - 2a - 1 to be a square. Solving 3a^2 - 2a - 1 = y^2 ==> 3a^2 - 2a - 1 - y^2 = 0 for a:
         * a = [2 ± sqrt(2^2 + 4*3*(y^2+1))] / 2*3 = [1 ± sqrt(3y^2 + 4)] / 3, for this to be integer 3y^2 + 4 has to
         * be a square, x^2, and since a > 0, sqrt(3y^2 + 4) % 3 == 2
		 * P = 3a + 1 = 3 * [1 ± sqrt(3y^2 + 4)] / 3 + 1 = [1 ± sqrt(3y^2 + 4)] + 1 = sqrt(3y^2 + 4) + 2 = x + 2
         *
         * Similarly, If the sides are (a, a, a-1), then the area is: A = sqrt(3a^2 + 2a - 1) * (a-1) / 4
         * Solving 3a^2 + 2a - 1 = y^2 ==> 3a^2 + 2a - 1 - y^2 = 0 for a:
         * a = [-1 ± sqrt(3y^2 + 4)] / 3, for this to be integer 3y^2 + 4 has to be a square and sqrt(3y^2 + 4) % 3 == 1
         * P = sqrt(3y^2 + 4) - 2 = x - 2
         *
         * We need to find all positive solutions to
         * 3y^2 + 4 = x^2, with x + 2 < 10^9, and x % 3 == 2
         * 3y^2 + 4 = x^2, with x - 2 < 10^9, and x % 3 == 1
         *
         * Using Diophantine quadratic method, we get:
         * Xn+1 = 2 Xn + 3 Yn
         * Yn+1 = Xn + 2 Yn
         */

        final int limit = 1_000_000_000;
        int sumOfPerimeters = 0;
        int x = 14; // Solution to the first triangle (5, 5, 6)
        int y = 8;

        do {
            if (x % 3 == 2) sumOfPerimeters += x + 2;
            else if (x % 3 == 1) sumOfPerimeters += x - 2;

            int newX = 2 * x + 3 * y;
            y = x + 2 * y;
            x = newX;
        } while (x < limit);

        return sumOfPerimeters;
    }
}