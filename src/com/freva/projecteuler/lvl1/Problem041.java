package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #41:
//What is the largest n-digit pandigital prime that exists?
//Answer: 7652413, Time: 1ms

public class Problem041 implements Problem {
	public Number solve() {
        //Cannot be 9 or 8 digit long pandigital prime as 1+2+3+4+5+6+7+8(+9) % 3 == 0
		for (int candidate = 7654321; ; candidate -= 2) {
            if (Functions.isPandigital(candidate) && Functions.isPrime(candidate)) {
                return candidate;
            }
		}
	}
}
