package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #100:
 * Answer: 756872327473, Time: 0ms
 *
 * If a box contains twenty-one coloured discs, composed of fifteen blue discs and six red discs, and two discs were
 * taken at random, it can be seen that the probability of taking two blue discs, P(BB) = (15/21)×(14/20) = 1/2.
 *
 * The next such arrangement, for which there is exactly 50% chance of taking two blue discs at random, is a box
 * containing eighty-five blue discs and thirty-five red discs.
 *
 * By finding the first arrangement to contain over 10^12 = 1,000,000,000,000 discs in total, determine the number of
 * blue discs that the box would contain.
 */

public class Problem100 implements Problem {
	public Number solve() {
        final long limit = 1_000_000_000_000L;

        /**
         * We are looking for t, b such that b/t * (b-1)/(t-1) = 1/2
         * ==> (t^2 - t)/(b^2 - b) = 2 ==> 2(b^2 - b) - (t^2 - t) = 0
         * ==> 2(b^2 - b + 1/4 - 1/4) - (t^2 - t + 1/4 - 1/4) = 0
         * ==> 2(b^2 - b + 1/4) - (t^2 - t + 1/4) - 2 * 1/4 + 1/4 = 0
         * ==> 2(b^2 - 1/2)^2 - (t^2 - 1/2)^2 - 1/4 = 0
         *
         * Substitute u/2 = b^2 - 1/2, v/2 = t^2 - 1/2:
         * ==> 2(u/2)^2 - (v/2)^2 - 1/4 = 0 ==> 2u^2/4 - v^2/4 - 1/4 = 0
         * ==> 2u^2 - v^2 = 1 // Pell equation
         *
         * Un+1 = 3t + 2b and Vb+1 = 4t + 3b
         */

        long u = 1;
        long v = 1;
        while (u < limit) {
            long lastN = u;
            u = 3*lastN + 2*v;
            v = 4*lastN + 3*v;
        }

        return (u+1) / 2; // Translate back to b using reverse substitution rule
    }
}