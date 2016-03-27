package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #26:
//Find the value of d<1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
//Answer: 983, Time: 0ms

public class Problem026 implements Problem {
    public Number solve() {
        int longestCycleDivisor = 0;
        int longestCycleLength = 0;

        for (int d = 999, temp; d > longestCycleLength; d--) {
            if (Functions.greatestCommonDivisor(10, d) != 1) continue;
            if ((temp = recurringCycleLength(d)) > longestCycleLength) {
                longestCycleLength = temp;
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
