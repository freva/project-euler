package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #32:
//Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
//Answer: 45228, Time: 5ms

public class Problem032 implements Problem {
    public Number solve() {
        final int limit = 123_456_789; //Smallest 1-9 pandigital number
        final boolean[] countedProducts = new boolean[10_000];

        int sum = 0;
        for (int multiplicand = 2; multiplicand < 99; multiplicand++) {
            if (multiplicand % 10 == 0 || multiplicand % 11 == 0) continue;

            for (int multiplier = 123, product; (product = multiplicand * multiplier) < 9876; multiplier++) {
                if (countedProducts[product]) continue;

                long candidate = Functions.concatenateDigits(multiplicand, multiplier, product);
                if (candidate >= limit && Functions.isPandigital(candidate)) {
                    countedProducts[product] = true;
                    sum += product;
                }
            }
        }

        return sum;
    }
}
