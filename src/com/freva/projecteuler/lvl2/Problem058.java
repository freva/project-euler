package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.MillerRabin;
import com.freva.projecteuler.Problem;

//Euler problem #58:
//If one complete new layer is wrapped around the spiral above, a square spiral with side length 9 will be formed. If
//this process is continued, what is the side length of the square spiral for which the ratio of primes along both
//diagonals first falls below 10%?
//Answer: 26241, Time: 30ms

public class Problem058 implements Problem {
    public Number solve() {
        int numPrimes = 0;
        for (int n = 3; ; n += 2) {
            for (int i = 0; i < 4; i++) {
                if (MillerRabin.isPrime(n * n - i * n + i)) {
                    numPrimes++;
                }
            }

            if (10 * numPrimes < 2 * n - 1) {
                return n;
            }
        }
    }
}