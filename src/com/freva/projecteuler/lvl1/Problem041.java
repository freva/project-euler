package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #041:
 * Answer: 7652413, Time: 1ms
 *
 * We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once.
 * For example, 2143 is a 4-digit pandigital and is also prime.
 *
 * What is the largest n-digit pandigital prime that exists?
 */

public class Problem041 implements Problem {
    public Number solve() {
        // Cannot be 9 or 8 digit long pandigital prime as 1+2+3+4+5+6+7+8(+9) % 3 == 0
        for (int candidate = 7_654_321; ; candidate -= 2) {
            if (Functions.isPandigital(candidate) && Functions.isPrime(candidate)) {
                return candidate;
            }
        }
    }
}
