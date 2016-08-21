package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

//Euler problem #71:
//By listing the set of reduced proper fractions for d ≤ 1,000,000 in ascending order of size, find the numerator of the fraction immediately to the left of 3/7.
//Answer: 428570, Time: 0ms

public class Problem071 implements Problem {
    public Number solve() {
        final int LIMIT = 1_000_000;
        int bestNumerator = 0;
        int bestDenominator = 1;

        for (int d = LIMIT; d > LIMIT - 7; d--) {
            int n = (3 * d - 1) / 7;
            if (bestNumerator * d < n * bestDenominator) {
                bestNumerator = n;
                bestDenominator = d;
            }
        }

        return bestNumerator;
    }
}
