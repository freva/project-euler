package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #52:
//Find the smallest positive integer, x, such that 2x, 3x, 4x, 5x, and 6x, contain the same digits.
//Answer: 142857, Time: 4ms

public class Problem052 implements Problem {
    public Number solve() {
        for (int i = 123456; ; i++) {
            if (Functions.arePermutationsOfEachOther(i, 2 * i, 3 * i, 4 * i, 5 * i, 6 * i)) {
                return i;
            }
        }
    }
}
