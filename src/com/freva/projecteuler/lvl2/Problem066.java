package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

import java.math.BigInteger;

//Euler problem #66:
//Find the value of D ≤ 1000 in minimal solutions of x for which the largest value of x is obtained.
//Answer: 661, Time: 30ms

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

            BigInteger t = a.multiply(a).subtract(b.multiply(b.multiply(BigInteger.valueOf(n))));  //t = a^2 - n*b^2
            if (t.equals(BigInteger.ONE)) { //Pell solution found: (a, b)
                return a;
            } else if (t.equals(BigInteger.ZERO)) { //n was a square, abort
                return BigInteger.ZERO;
            } else { //Re-adjust lower or higher bound
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
