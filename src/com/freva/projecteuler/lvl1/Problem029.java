package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

import java.util.HashSet;

//Euler problem #29:
//How many distinct terms are in the sequence generated by a^b for 2 <= a <= 100 and 2 <= b <= 100?
//Answer: 9183, Time: 3ms

public class Problem029 implements Problem {
    public Number solve() {
        final int limit = 100;
        final boolean[] overlaps = new boolean[limit + 1];
        final HashSet<Double> powers = new HashSet<>();

        for (int a = 2; a <= limit; a++) {
            for (int j = a; j <= limit; j *= a) {
                overlaps[j] = true;
            }
        }

        int numberOfDuplicates = 0;
        for (int a = 2; a <= 100; a++) {
            if (!overlaps[a]) continue;
            for (int b = 2; b <= 100; b++, numberOfDuplicates++) {
                powers.add(Math.pow(a, b));
            }
        }

        return 99 * 99 - numberOfDuplicates + powers.size();
    }
}
