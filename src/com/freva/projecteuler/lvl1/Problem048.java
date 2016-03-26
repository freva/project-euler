package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #48:
//Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.
//Answer: 9110846700, Time: 5ms

public class Problem048 implements Problem {
    public Number solve() {
        final long mod = 10000000000L;

        long sum = 0;
        for (int i = 1; i <= 1000; i++) {
            long power = 1;
            for (int exp = 1; exp <= i; exp++) {
                power = (power * i) % mod;
            }
            sum += power;
        }

        return sum % mod;
    }
}
