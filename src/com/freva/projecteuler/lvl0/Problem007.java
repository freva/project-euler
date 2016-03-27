package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #7:
//What is the 10 001st prime number?
//Answer: 104743, Time: 9ms

public class Problem007 implements Problem {
    public Number solve() {
        int candidate = 3;
        for (int numPrimes = 1; ; candidate += 2) {
            if (Functions.isPrime(candidate)) {
                if (++numPrimes == 10_001) {
                    return candidate;
                }
            }
        }
    }
}
