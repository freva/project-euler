package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #5:
//What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
//Answer: 232792560, Time: 0ms

public class Problem005 implements Problem {
	public Number solve() {
		long answer = 1;

        for(int i=1; i<=20; i++) {
            answer = Functions.leastCommonMultiple(answer, i);
        }

        return answer;
	}
}
