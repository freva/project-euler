package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #1:
//Find the sum of all the multiples of 3 or 5 below 1000.
//Answer: 233168, Time: 0ms

public class Problem001 implements Problem {
	public Number solve() {
		int sum = 0;
		for(int i=2; i<1000; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}

		return sum;
	}

    public Number solution() {
        return 233168;
    }
} 
