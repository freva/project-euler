package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #34:
//Find the sum of all numbers which are equal to the sum of the factorial of their digits.
//Answer: 40730, Time: 3ms

public class Problem034 implements Problem {
	public Number solve() {
		int sum = 0;

		for (int n = 10; n < 50_000; n++) {
            int candidate = n;
            int factorialDigitSum = 0;

			while (candidate > 0) {
                factorialDigitSum += Functions.TEN_FACTORIALS[candidate % 10];
                candidate /= 10;
			}

			if(factorialDigitSum == n) {
                sum += n;
            }
		}

		return sum;
	}
}
