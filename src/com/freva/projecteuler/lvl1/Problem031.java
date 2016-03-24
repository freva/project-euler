package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #31:
//How many different ways can £2 be made using any number of coins?
//Answer: 73682, Time: 0ms

public class Problem031 implements Problem {
	public Number solve() {
		final int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
        final int goal = 200;

        int[] numberOfWaysToMake = new int[goal+1];
        numberOfWaysToMake[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= goal; i++) {
                numberOfWaysToMake[i] += numberOfWaysToMake[i - coin];
            }
        }

		return numberOfWaysToMake[goal];
	}
}