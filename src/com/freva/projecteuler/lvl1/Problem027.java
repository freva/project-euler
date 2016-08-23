package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #027:
 * Answer: -59231, Time: 4ms
 *
 * Euler discovered the remarkable quadratic formula: n^2 + n + 41
 * It turns out that the formula will produce 40 primes for the consecutive integer values 0 ≤ n ≤ 39. However,
 * when n=40, 40^2 + 40 + 41 = 40(40+1) + 41 is divisible by 41,
 * and certainly when n=41, 41^2 + 41 + 41 is clearly divisible by 41.
 *
 * The incredible formula n^2 − 79n + 1601 was discovered, which produces 80 primes for the consecutive values
 * 0 ≤ n ≤ 79. The product of the coefficients, −79 and 1601, is −126479.
 *
 * Considering quadratics of the form:
 * n^2 + an + b, where |a| < 1000 and |b| ≤ 1000, where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |−4| = 4
 *
 * Find the product of the coefficients, a and b, for the quadratic expression that produces the maximum number of
 * primes for consecutive values of n, starting with n = 0.
 */

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
