package com.freva.projecteuler.lvl0;

//Euler problem #3:
//What is the largest prime factor of the number 600851475143?
//Answer: 6859, Time: 0ms

import com.freva.projecteuler.Problem;

public class Problem003 implements Problem {
	public Number solve() {
		long target = 600851475143L;
		int largestFactor;
		
		for(largestFactor=3; target!=1; largestFactor+=2) {
			if(target % largestFactor == 0) {
				target /= largestFactor;
			}
		}

		return largestFactor;
	}

	public Number solution() {
		return 6859;
	}
}
