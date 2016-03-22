package com.freva.projecteuler.lvl0;

//Euler problem #4:
//Find the largest palindrome made from the product of two 3-digit numbers.
//Answer: 906609, Time: 1ms

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

public class Problem004 implements Problem {
	public Number solve() {
		int largest = 0;

		for(int i=999; i>100; i--){
			for(int j=i; j>100; j--){
				int product = i*j;

				if (product < largest) {
					break;
				}

				if(Functions.isPalindrome(product) && product > largest){
					largest = product;
				}
			}
		}

		return largest;
	}

	public Number solution() {
		return 906609;
	}
}
