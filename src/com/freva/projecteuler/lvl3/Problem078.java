package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #078:
 * Answer: 55374, Time: 327ms
 *
 * Let p(n) represent the number of different ways in which n coins can be separated into piles. For example, five
 * coins can be separated into piles in exactly seven different ways, so p(5)=7.
 * OOOOO
 * OOOO   O
 * OOO   OO
 * OOO   O   O
 * OO   OO   O
 * OO   O   O   O
 * O   O   O   O   O
 *
 * Find the least value of n for which p(n) is divisible by one million.
 */

public class Problem078 implements Problem {
    public Number solve() {
        int[] p = new int[100000];
        p[0] = 1;

        /**
         * Solution based of https://en.wikipedia.org/wiki/Partition_%28number_theory%29#Recurrence_formula :
         * p(n) = sum for all k != 0 [(-1)^(k-1) * p(n - k(3k - 1)/2)
         * We only want to sum over k where n - k(3k -1)/2 >= 0, solving 3/2k^2 - 1/2k - n = 0
         * => k = (1/2 ± sqrt(1/4 + 4*3/2*n)) / 2*(3/2) = (1/2 ± sqrt(1/4 +6*n))/3
         * Don't have to skip k=0 since n - k(3k -1)/2 = n for k=0, and p(n) = 0 at the time of for-loop evaluation.
         */
        for(int n = 1; ; n++) {
            double part = Math.sqrt(6 * n + 0.25);
            int start = (int) ((0.5-part) / 3);
            int end = (int) ((0.5+part) / 3);

            int temp = 0;
            for(int k = start; k <= end; k++) {
                if(k % 2 == 0) temp -= p[n - ((k * (3 * k - 1) )/ 2)];
                else temp += p[n - ((k * (3 * k - 1) )/ 2)];
            }

            p[n] = temp % 1_000_000;
            if(p[n] == 0) {
                return n;
            }
        }
    }
}
