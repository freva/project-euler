package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #69:
//Find the value of n ≤ 1,000,000 for which n/φ(n) is a maximum.
//Answer: 510510, Time: 0ms

public class Problem069 implements Problem {
    public Number solve() {
        /**
         * As per the fundamental theorem of arithmetic, we can uniquely write any integer as a product of primes:
         * n = product of k=1..r [p_k^a_k]
         * The Euler's Totient function, φ(n), can also be written as:
         * φ(n) = product of k=1..r [(p_k - 1) * p_k^(a_k-1)]
         *      = product of k=1..r [((p_k - 1) * p_k^a_k) / p_k)]
         *      = n * product of k=1..r [(p_k - 1) / p_k]
         *
         * Then, n/φ(n) is:
         * n/φ(n) = n / (n * product of k=1..r [(p_k - 1) / p_k])
         * n/φ(n) = product of n=1..r [p_k / (p_k - 1)]
         * Thus the ratio n/φ(n) is only dependants on n's unique prime factors and not n itself or the exponents (a_k)
         * of the primes. Since the ratio is with the number of unique prime factors, the answer must be the product
         * of q smallest primes such that product of k=1..q [p_k] < 1_000_000.
         */

        int largest = 1;
        for (int i = 0; largest * Functions.TEN_PRIMES[i] < 1_000_000; i++) {
            largest *= Functions.TEN_PRIMES[i];
        }

        return largest;
    }
}
