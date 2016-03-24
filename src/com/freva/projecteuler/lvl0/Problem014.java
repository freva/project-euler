package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #14:
//Which starting number, under one million, produces the longest chain?
//Answer: 837799, Time: 20ms

public class Problem014 implements Problem {
	public Number solve() {
        final int limit = 1_000_000;
        final int[] cache = new int[limit];

        int largestCounter = 0, longestN = 0;
		for (int n=1, counter; n < limit; n++) {
			long temp = n;

			for (counter=0; temp!=1; counter++) {
				if (temp < n) {
					counter += cache[(int) temp];
					break;
				}
					
				temp = (temp%2==0) ? temp/2 : 3*temp+1;
			}

			cache[n] = counter;

			if (largestCounter < counter) {
				largestCounter = counter;
				longestN = n;
			}
		}
		
		return longestN;
	}
}
