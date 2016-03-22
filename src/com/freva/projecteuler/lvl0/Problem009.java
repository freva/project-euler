package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #9:
//There exists exactly one Pythagorean triplet for which a + b + c = 1000. Find the product abc.
//Answer: 31875000, Time: 2ms

public class Problem009 implements Problem {
	public Number solve() {
        final int goal = 1000;

		for (int a = 3; a < (goal-3)/3; a++) {
			for (int b = a+1; b < (goal-a-1)/2; b++) {
				int c = goal-a-b;

				if (a*a + b*b == c*c){
                    return a*b*c;
				}
			}
		}

        return -1;
    }

    public Number solution() {
        return 31875000;
    }
}
