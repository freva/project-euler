package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #21:
//Evaluate the sum of all the amicable numbers under 10000.
//Answer: 31626, Time: 1ms

public class Problem021 implements Problem {
    public Number solve() {
        final int limit = 10_000;
        final int[] sumOfDivisors = new int[limit];
        for (int i = 1; i < limit / 2; i++) {
            for (int j = 2 * i; j < limit; j += i) {
                sumOfDivisors[j] += i;
            }
        }

        int total = 0;
        for (int n = 3; n < limit; n++) {
            int pairCandidate = sumOfDivisors[n];
            if (pairCandidate != n && pairCandidate < limit && n == sumOfDivisors[pairCandidate]) {
                total += n;
            }
        }

        return total;
    }
}
