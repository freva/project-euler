package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #7:
//What is the 10 001st prime number?
//Answer: 104743, Time: 3ms

public class Problem007 implements Problem {
    public Number solve() {
        int[] primes = Functions.getNPrimes(10000);
        return primes[10000];
    }
}
