package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Problem;

//Euler problem #44:
//Find the pair of getPentagonal numbers, Pj and Pk, for which their sum and difference is getPentagonal and
// D = |Pk - Pj| is minimised; what is the value of D?
//Answer: 5482660, Time: 9ms

public class Problem044 implements Problem {
    public Number solve() {
        for (int d = 1; ; d++) {
            int pentagonalDifference = getPentagonal(d);

            //We start with the difference between the two pentagonal numbers, D, this way we can abort as soon as we
            //find one since it will be the smallest. The goal is to find n and m such that P(m)-P(n) = D:
            //We know that m > n, so D = P(n+i) - P(n) = (n+i)*(3*(n+i)+1)/2 - i*(3*i+1)/2, solving for n gives:
            //n = ((2*D)/i - 3*i - 1) / 6. Now we loop over i increasing it until we get n < 1
            for (int i = 1; ; i++) {
                int t = 2*pentagonalDifference - i*(3*i - 1);
                int a = t / (6*i);

                if (a < 1) break;
                if (6*a*i != t) continue;

                int pa = getPentagonal(a);
                int pb = pentagonalDifference + pa;

                int pentagonalSum = pa + pb;
                if (isPentagonal(pentagonalSum)) {
                    return pentagonalDifference;
                }
            }
        }
    }

    private static int getPentagonal(int n) {
        return n * (3*n - 1) / 2;
    }

    //Solving P = n(3n−1) / 2 for n gives:
    //n = (sqrt(24P + 1) + 1) / 6
    private static boolean isPentagonal(int candidate) {
        final double n = (1 + Math.sqrt(1 + 24 * candidate)) / 6;
        return (int) n == n;
    }
}
