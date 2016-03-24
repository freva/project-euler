package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #36:
//Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.
//Answer: 872187, Time: 9ms

public class Problem036 implements Problem {
    public Number solve() {
        int sum = 0;

        for (long i = 1; i < 1000000; i += 2) {
            if (i == Functions.reverseNumber(i)) {
                if(i == reverseBinary(i)) {
                    sum += i;
                }
            }
        }

        return sum;
    }

    private static long reverseBinary(long number) {
        long reversed = 0;
        while (number > 0) {
            reversed <<= 1;
            reversed |= number & 1;
            number >>= 1;
        }

        return reversed;
    }
}
