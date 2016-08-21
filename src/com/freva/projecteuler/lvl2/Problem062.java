package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #62:
//Find the smallest cube for which exactly five permutations of its digits are cube.
//Answer: 127035954683, Time: 23ms

public class Problem062 implements Problem {
    public Number solve() {
        final long cubeSignatures[] = new long[10000];

        for (int i = 345; ; i++) {
            cubeSignatures[i] = Functions.getNumberSignature((long) i * i * i);

            for (int j = i - 1, counter = 1; cubeSignatures[j] != 0; j--) {
                if (cubeSignatures[j] == cubeSignatures[i]) {
                    if (++counter == 5) {
                        return (long) j * j * j;
                    }
                }
            }
        }
    }
}
