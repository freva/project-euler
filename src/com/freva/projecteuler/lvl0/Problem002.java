package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #2:
//By considering the terms in the Fibonacci sequence whose values do not exceed four million, find the sum of the even-valued terms.
//Answer: 4613732, Time: 0ms

public class Problem002 implements Problem {
	public Number solve() {
		int sum=0;
		
		for(int i0=1, i1=1; i1<4000000; ) {
            int temp = i1;
            i1 += i0;
            i0 = temp;

			if(i0%2 == 0) {
				sum += i0;
			}
		}
		
		return sum;
	}

	public Number solution() {
		return 4613732;
	}
}
