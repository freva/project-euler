package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #6:
//Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
//Answer: 25164150, Time: 0ms

public class Problem006 implements Problem {
	public Number solve(){
		int n = 100;
        int sum = n * (n+1) / 2;
        int sumOfSquares = n * (n+1) * (2*n+1) / 6;

		return sum*sum - sumOfSquares;
	}

    public Number solution() {
        return 25164150;
    }
}
