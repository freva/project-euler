package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

import java.math.BigInteger;

/**
 * Project Euler problem #066:
 * Answer: 661, Time: 30ms
 *
 * Consider quadratic Diophantine equations of the form: x^2 – Dy^2 = 1
 * For example, when D=13, the minimal solution in x is 649^2 – 13×180^2 = 1.
 *
 * It can be assumed that there are no solutions in positive integers when D is square.
 *
 * By finding minimal solutions in x for D = {2, 3, 5, 6, 7}, we obtain the following:
 * 3^2 – 2×2^2 = 1
 * 2^2 – 3×1^2 = 1
 * 9^2 – 5×4^2 = 1
 * 5^2 – 6×2^2 = 1
 * 8^2 – 7×3^2 = 1
 *
 * Hence, by considering minimal solutions in x for D ≤ 7, the largest x is obtained when D=5.
 *
 * Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
 */

public class Problem066 implements Problem {
    public Number solve() {
        BigInteger maxMinX = BigInteger.ZERO;
        int maxD = 0;

        for (int D = 2; D <= 1000; D++) {
            BigInteger minX = minimalXSolution(D);
            if (maxMinX.compareTo(minX) < 0) {
                maxD = D;
                maxMinX = minX;
            }
        }

        return maxD;
    }

    private static BigInteger minimalXSolution(int n) {
        BigInteger n1 = BigInteger.ZERO, d1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE, d2 = BigInteger.ZERO;

        while (true) {
            BigInteger a = n1.add(n2);
            BigInteger b = d1.add(d2);

            BigInteger t = a.multiply(a).subtract(b.multiply(b.multiply(BigInteger.valueOf(n))));  // t = a^2 - n*b^2
            if (t.equals(BigInteger.ONE)) { // Pell solution found: (a, b)
                return a;
            } else if (t.equals(BigInteger.ZERO)) { // n was a square, abort
                return BigInteger.ZERO;
            } else { // Re-adjust lower or higher bound
                if (t.signum() > 0) {
                    n2 = a;
                    d2 = b;
                } else {
                    n1 = a;
                    d1 = b;
                }
            }
        }
    }
}
