package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #097:
 * Answer: 8739992577, Time: 0ms
 *
 * The first known prime found to exceed one million digits was discovered in 1999, and is a Mersenne prime of the
 * form 2^6972593 −1; it contains exactly 2,098,960 digits. Subsequently other Mersenne primes, of the form 2^p −1,
 * have been found which contain more digits.
 *
 * However, in 2004 there was found a massive non-Mersenne prime which contains 2,357,207 digits: 28433×2^7830457+1.
 * Find the last ten digits of this prime number.
 */

public class Problem097 implements Problem {
    public Number solve() {
        final long limit = 10_000_000_000L;

        /**
         * Since we only care about the last ten digits, we do not have to calculate the entire 2^7830457 as it's period
         * is repeating. The period is the multiplicative order of 2 modulo 5^k, which is φ(5^k) = 4 × 5^k−1, that is,
         * the last 10 digits of 2^7830457 is equal to that of 2^(7830457 % (4 * 5^(10-1))) = 2^17957
         *
         * Modulo is relatively expensive operation, so to limit the number of times we to call it, we can do multiple
         * powers of 2 for each time. Since log2(10^10) ~ 33.2, and we are using a long (63 bits in positive range),
         * we can multiply with up to 2^29 without losing any information w.r.t. last 10 digits.
         */

        int power = (int) (7830457 % (4 * Functions.pow(5, 9)));
        long total = 28433 * Functions.pow(2, power % 29);
        for (int i = 0; i < power / 29; i++) {
            total = (total << 29) % limit;
            total %= limit;
        }

        return total + 1;
    }
}