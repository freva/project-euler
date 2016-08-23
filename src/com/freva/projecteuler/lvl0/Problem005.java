package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #005:
 * Answer: 232792560, Time: 0ms
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */

public class Problem005 implements Problem {
    public Number solve() {
        long smallestEvenlyDivisibleNumber = 1;

        for (int i = 1; i <= 20; i++) {
            smallestEvenlyDivisibleNumber = Functions.leastCommonMultiple(smallestEvenlyDivisibleNumber, i);
        }

        return smallestEvenlyDivisibleNumber;
    }
}
