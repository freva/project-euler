package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #45:
//Find the next triangle number that is also pentagonal and hexagonal.
//Answer: 1533776805, Time: 1ms

public class Problem045 implements Problem {
    public Number solve() {
        for (int n = 145; ; n++) {
            //All triangle numbers are also hexagonal numbers, thus we only need to find a pentagonal number that is
            //also a hexagonal number
            final long hexagonal = n * (2 * n - 1);
            final double k = (1 + Math.sqrt(1 + 24 * hexagonal)) / 6;

            if (k == (int) k) {
                return hexagonal;
            }
        }
    }
}
