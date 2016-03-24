package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #28:
//What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
//Answer: 669171001, Time: 0ms

public class Problem028 implements Problem {
	public Number solve() {
		int sumOfDiagonals = 1;
		for (int gapBetweenCorners = 2, diagonalNumber = 1; gapBetweenCorners <= 1000; gapBetweenCorners += 2) {
			for (int j = 0; j < 4; j++) {
				diagonalNumber += gapBetweenCorners;
				sumOfDiagonals += diagonalNumber;
			}
		}
		
		return sumOfDiagonals;
	}
}
