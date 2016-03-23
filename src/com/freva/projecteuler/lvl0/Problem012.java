package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #12:
//What is the value of the first triangle number to have over five hundred divisors?
//Answer: 76576500, Time: 3ms

public class Problem012 implements Problem {
	public Number solve() {
        final int startTriangleNumber = 1;

        int prevNumOfDivisors = numberOfDivisors(startTriangleNumber);
		for (int i=startTriangleNumber+1; ; i++) {
            int currentNumOfDivisors = numberOfDivisors((i&1) == 1 ? i : i/2);
            int numOfDivisors = prevNumOfDivisors * currentNumOfDivisors;

            prevNumOfDivisors = currentNumOfDivisors;
            if (numOfDivisors > 500) {
                return (i-1)*i/2;
            }
        }
    }

    private static int numberOfDivisors(int n) {
        final int end = (int) Math.sqrt(n);
        int count = 0;
        for (int i = 1; i < end; i++) {
            if (n % i == 0) {
                count += 2;
            }
        }

        return count + (end*end == n ? 1:0);
    }
}
