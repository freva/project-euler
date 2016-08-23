package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #026:
 * Answer: 983, Time: 0ms
 *
 * A unit fraction contains 1 in the numerator. The decimal representation of the unit fractions with denominators
 * 2 to 10 are given:
 * 1/2	= 	0.5
 * 1/3	= 	0.(3)
 * 1/4	= 	0.25
 * 1/5	= 	0.2
 * 1/6	= 	0.1(6)
 * 1/7	= 	0.(142857)
 * 1/8	= 	0.125
 * 1/9	= 	0.(1)
 * 1/10	= 	0.1
 * Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle. It can be seen that 1/7 has a 6-digit recurring cycle.
 *
 * Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 */

public class Problem026 implements Problem {
    public Number solve() {
        int longestCycleDivisor = 0;
        int longestCycleLength = 0;

        for (int d = 999, currentCycleLength; d > longestCycleLength; d--) {
            if (Functions.greatestCommonDivisor(10, d) != 1) continue;
            if ((currentCycleLength = recurringCycleLength(d)) > longestCycleLength) {
                longestCycleLength = currentCycleLength;
                longestCycleDivisor = d;
            }
        }

        return longestCycleDivisor;
    }

    private static int recurringCycleLength(int d) {
        int cycleLength = 0;
        for (int remainder = 10; remainder != 1; cycleLength++) {
            remainder = (remainder * 10) % d;
        }

        return cycleLength;
    }
}
