package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.util.ArrayList;
import java.util.Arrays;

//Euler problem #24:
//What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
//Answer: 2783915460, Time: 0ms

public class Problem024 implements Problem {
	public Number solve() {
		final ArrayList<Integer> digits = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
		int position = 999999;

        long permutation = 0;
		for(int n = digits.size(); n > 0; n--){
			int step = Functions.TEN_FACTORIALS[n-1];
			int r = position/step;
			position -= r*step;
			
			permutation = 10*permutation + digits.remove(r);
		}

		return permutation;
	}
}
