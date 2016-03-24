package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.util.List;

//Euler problem #10:
//Find the sum of all the primes below two million.
//Answer: 142913828922, Time: 20ms

public class Problem010 implements Problem {
	public Number solve() {
		List<Integer> primes = Functions.getPrimesBelow(2_000_000);

        return Functions.sum(primes);
    }
}
