package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

import java.util.Arrays;

//Euler problem #47:
//Find the first four consecutive integers to have four distinct primes factors. What is the first of these numbers?
//Answer: 134043, Time: 7ms

public class Problem047 implements Problem {
    public Number solve() {
        final boolean[] isNonMultiComposite = getMultiComposites(200_000);

        for (int i = 5005; ; i++) {
            if (!isNonMultiComposite[i] || !isNonMultiComposite[i + 1] || !isNonMultiComposite[i + 2] || !isNonMultiComposite[i + 3])
                continue;

            int counter = 0;
            while (noOfDistinctPrimeFactors(i++) == 4) {
                counter++;
            }

            if (counter >= 4) {
                return i - counter - 1;
            }
        }
    }

    private static int noOfDistinctPrimeFactors(int n) {
        int numDistinctFactors = 0;
        double limit = Math.sqrt(n);
        for (int i = 2; n > 1 && i < limit; i++) {
            int temp = 0;
            while (n % i == 0) {
                n /= i;
                temp++;
                limit = Math.sqrt(n);
            }

            if (temp > 0) {
                numDistinctFactors++;
            }
        }
        return numDistinctFactors + (n > 1 ? 1 : 0);
    }

    private static boolean[] getMultiComposites(int n) {
        final boolean[] isTwoOrMoreComposite = Functions.sieveOfEratosthenes(n);

        for (int i = 2; i * i <= n; i++) {
            if (!isTwoOrMoreComposite[i]) {
                for (int j = i * i; j <= n; j *= i) {
                    isTwoOrMoreComposite[j] = false;
                }
            }
        }

        final boolean[] isThreeOrMoreComposite = Arrays.copyOf(isTwoOrMoreComposite, n + 1);
        for (int i = 2; i * i <= n; i++) {
            if (isTwoOrMoreComposite[i]) continue;

            for (int j = i; i * j <= n; j++) {
                if (isTwoOrMoreComposite[j]) continue;

                for (int product = i * j; product <= n; product += product) {
                    isThreeOrMoreComposite[product] = false;
                }
            }
        }

        return isThreeOrMoreComposite;
    }
}
