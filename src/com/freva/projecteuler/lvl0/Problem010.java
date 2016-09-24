package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.ArrayFunctions;
import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #010:
 * Answer: 142913828922, Time: 17ms
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 */

public class Problem010 implements Problem {
    public Number solve() {
        int[] primes = Functions.getPrimesBelow(2_000_000);

        return ArrayFunctions.sum(primes);
    }
}
