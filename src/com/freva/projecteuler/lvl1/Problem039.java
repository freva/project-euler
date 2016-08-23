package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #039:
 * Answer: 840, Time: 1ms
 *
 * If p is the perimeter of a right angle triangle with integral length sides, {a,b,c}, there are exactly three
 * solutions for p = 120: {20,48,52}, {24,45,51}, {30,40,50}
 *
 * For which value of p ≤ 1000, is the number of solutions maximised?
 */

public class Problem039 implements Problem {
    public Number solve() {
        // Shortest possible side as proportion of p is if both catheti are equal (a == b), giving
        // hypothenuse = sqrt(a^2 + b^2) = sqrt(2*a^2) = a + sqrt(2), p = a + b + c = 2*a + a + sqrt(2) = 3*a + sqrt(2)
        final double shortestSideProportion = 3 + Math.sqrt(2);

        int maxP = 0;
        int maxNumberOfSolutions = 0;

        // p is perimeter: a+b+c = p
        // a^2+b^2 = c^2 = (p-a-b)^2 = p^2+a^2+b^2 - 2*p*a - 2*p*b + 2*a*b
        // Solving for b gives: (2*a*p - p^2) / 2*(a-p)
        for (int p = 120; p <= 1000; p += 2) {
            int numberOfSolutions = 0;

            for (int a = 30, p2 = (p * p) / 2; a < p / shortestSideProportion; a++) {
                double b = (double) (a * p - p2) / (a - p);

                if (b == (int) b) {
                    numberOfSolutions++;
                }
            }

            if (numberOfSolutions > maxNumberOfSolutions) {
                maxNumberOfSolutions = numberOfSolutions;
                maxP = p;
            }
        }

        return maxP;
    }
}
