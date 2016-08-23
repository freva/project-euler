package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #006:
 * Answer: 25164150, Time: 0ms
 *
 * The sum of the squares of the first ten natural numbers is: 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is: (1 + 2 + ... + 10)^2 = 552 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */

public class Problem006 implements Problem {
    public Number solve() {
        int n = 100;
        int sumOfNumbers = n * (n + 1) / 2;
        int sumOfSquares = n * (n + 1) * (2 * n + 1) / 6;

        return sumOfNumbers * sumOfNumbers - sumOfSquares;
    }
}
