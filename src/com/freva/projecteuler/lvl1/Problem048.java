package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #048:
 * Answer: 9110846700, Time: 5ms
 *
 * The series, 1^1 + 2^2 + 3^3 + ... + 10^10 = 10405071317.
 * Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
 */

public class Problem048 implements Problem {
    public Number solve() {
        final long mod = 10_000_000_000L;

        long sumOfLastTenDigits = 0;
        for (int i = 1; i <= 1000; i++) {
            long power = 1;
            for (int exp = 1; exp <= i; exp++) {
                power = (power * i) % mod;
            }
            sumOfLastTenDigits += power;
        }

        return sumOfLastTenDigits % mod;
    }
}
