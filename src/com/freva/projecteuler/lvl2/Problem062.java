package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #062:
 * Answer: 127035954683, Time: 23ms
 *
 * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3).
 * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
 *
 * Find the smallest cube for which exactly five permutations of its digits are cube.
 */

public class Problem062 implements Problem {
    public Number solve() {
        final long cubeSignatures[] = new long[10_000];

        for (int i = 345; ; i++) {
            cubeSignatures[i] = Functions.getNumberSignature((long) i * i * i);

            for (int j = i - 1, counter = 1; cubeSignatures[j] != 0; j--) {
                if (cubeSignatures[j] == cubeSignatures[i]) {
                    if (++counter == 5) {
                        return Functions.pow(j, 3);
                    }
                }
            }
        }
    }
}
