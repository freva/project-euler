package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #085:
 * Answer: 2772, Time: 0ms
 *
 * Although there exists no rectangular grid that contains exactly two million rectangles, find the area of the grid
 * with the nearest solution.
 */

public class Problem085 implements Problem {
    public Number solve() {
        /**
         * For a side of length x, there are x(x + 1)/2 different lengths can be created, therefore for a rectangle with
         * sides x and y, there exactly x*y*(x + 1)*(y + 1) / 4 different rectangles inside it.
         *
         * Solving for x^2 * (x+1)^2 / 4 = 2 000 000:
         * x^2 * (x+1)^2 = x^2(x^2 + 2x + 1) = 8 000 000
         * sqrt(x^2 * (x+1)^2) = sqrt(x^2) * sqrt((x+1)^2) = x*(x+1) = sqrt(8 000 000)
         * Then, solve x*(x+1) = sqrt(8 000 000):
         * x^2 + x - sqrt(8 000 000) = 0
         * x = [-1 + sqrt(1 + 4000*sqrt(8))] / 2 ≈ 52.685
         *
         * We need to iterate over x between 1 and 53, for each value we calculate y:
         * x*y*(x+1)*(y+1) / 4 = 2 000 000
         * y^2 + y = 4 * 2 000 000 / (x^2 + x), if c = 8 000 000 / (x^2 + x),
         * y = [-1 + sqrt(1 + 4c)] / 2
         * y = [-1 + sqrt(1 + 4 * (4 * target / (x^2 + x)))] / 2 = [-1 + sqrt(1 + 16 * target / (x^2 + x))] / 2
         *
         * Rounding this down will give the number of rectangles right under 2m, since we are looking for the nearest
         * solution, we should also test the value immediately above 2m which we get with y+1.
         */

        final int target = 2_000_000;

        int smallestDistanceToTarget = Integer.MAX_VALUE;
        int areaForSmallestSolution = 0;
        for (int x = 1; x < 53; x++) {
            int yStart = (int) (Math.sqrt(1 + 16 * target / (x * x + x)) - 1) / 2;
            for (int y = yStart; y <= yStart + 1; y++) {
                int numberOfRectanglesInside = x * y * (x + 1) * (y + 1) / 4;
                if (smallestDistanceToTarget > Math.abs(numberOfRectanglesInside - target)) {
                    smallestDistanceToTarget = Math.abs(numberOfRectanglesInside - target);
                    areaForSmallestSolution = x * y;
                }
            }
        }

        return areaForSmallestSolution;
    }
}
