package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #55:
//How many Lychrel numbers are there below ten-thousand?
//Answer: 249, Time: 4ms

public class Problem055 implements Problem {
    public Number solve() {
        int numberOfLychrelNumbers = 0;
        for (int i = 1; i < 10_000; i++) {
            if (isLychrelNumber(i)) {
                numberOfLychrelNumbers++;
            }
        }

        return numberOfLychrelNumbers;
    }

    private static boolean isLychrelNumber(long candidate) {
        for (int iteration = 1; iteration < 50; iteration++) {
            candidate = candidate + Functions.reverseNumber(candidate);
            if (Functions.isPalindrome(candidate)) {
                return false;
            }
        }

        return true;
    }
}
