package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #031:
 * Answer: 73682, Time: 0ms
 *
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 *
 * It is possible to make £2 in the following way:
 * 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
 *
 * How many different ways can £2 be made using any number of coins?
 */

public class Problem031 implements Problem {
    public Number solve() {
        final int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        final int goal = 200;

        int[] numberOfWaysToMake = new int[goal + 1];
        numberOfWaysToMake[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= goal; i++) {
                numberOfWaysToMake[i] += numberOfWaysToMake[i - coin];
            }
        }

        return numberOfWaysToMake[goal];
    }
}