package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #27:
//Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of
//primes for consecutive values of n, starting with n = 0.
//Answer: -59231, Time: 4ms

public class Problem027 implements Problem {
    public Number solve() {
        final boolean[] isComposite = Functions.sieveOfEratosthenes(15_000);

        int longest = 1;
        int productOfCoefficients = 0;
        for (int b = 2; b < 1000; b++) {
            if (isComposite[b]) continue;

            for (int a = -(longest * longest + b) / longest; a < 1000; a++) {
                int n = 0;

                for (int prime = b; prime > 0 && !isComposite[prime]; n++) {
                    prime = n * n + a * n + b;
                }

                if (n > longest) {
                    longest = n;
                    productOfCoefficients = a * b;
                }
            }
        }

        return productOfCoefficients;
    }
}
