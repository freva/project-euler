package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.math.BigInteger;

//Euler problem #25:
//What is the first term in the Fibonacci sequence to contain 1000 digits?
//Answer: 4782, Time: 4ms

public class Problem025 implements Problem {
    public Number solve() {
        final BigInteger target = BigInteger.TEN.pow(999);
        BigInteger prev = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;

        int i = 2;
        for (; target.compareTo(current) == 1; i++) {
            final BigInteger temp = current;
            current = current.add(prev);
            prev = temp;
        }

        return i;
    }
}
