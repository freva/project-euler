package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #10:
//Find the sum of all the primes below two million.
//Answer: 142913828922, Time: 17ms

public class Problem010 implements Problem {
    public Number solve() {
        int[] primes = Functions.getPrimesBelow(2_000_000);

        return Functions.sum(primes);
    }
}
