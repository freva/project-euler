package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

import java.math.BigInteger;

/**
 * Project Euler problem #025:
 * Answer: 4782, Time: 4ms
 *
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn−1 + Fn−2, where F1 = 1 and F2 = 1.
 *
 * What is the index of the first term in the Fibonacci sequence to contain 1000 digits?
 */

public class Problem025 implements Problem {
    public Number solve() {
        final BigInteger target = BigInteger.TEN.pow(999);
        BigInteger prev = BigInteger.ONE;
        BigInteger current = BigInteger.ONE;

        int index = 2;
        for (; target.compareTo(current) == 1; index++) {
            final BigInteger temp = current;
            current = current.add(prev);
            prev = temp;
        }

        return index;
    }
}
