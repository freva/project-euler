package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.MillerRabin;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #060:
 * Answer: 26033, Time: 390ms
 *
 * The primes 3, 7, 109, and 673, are quite remarkable. By taking any two primes and concatenating them in any order
 * the result will always be prime. For example, taking 7 and 109, both 7109 and 1097 are prime. The sum of these four
 * primes, 792, represents the lowest sum for a set of four primes with this property.
 *
 * Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
 */

public class Problem060 implements Problem {
    public Number solve() {
        final int[] primes = Functions.getPrimesBelow(10_000);
        final boolean[][] isPair = new boolean[primes.length][primes.length];
        for (int i = 0; i < primes.length; i++) {
            for (int j = i + 1; j < primes.length; j++) {
                if (isConcatenatePrime(primes[i], primes[j])) {
                    isPair[i][j] = true;
                }
            }
        }

        int[] nums = new int[5];
        combinationDFS(nums, 0, isPair);
        return primes[nums[0]] + primes[nums[1]] + primes[nums[2]] + primes[nums[3]] + primes[nums[4]];
    }


    private static boolean combinationDFS(int[] numbers, int length, boolean[][] isPair) {
        for (int a = (length == 0 ? 0 : numbers[length - 1] + 1); a < isPair.length; a++) {
            int counter = 0;
            for (int b = 0; b < length; b++) {
                if (isPair[numbers[b]][a]) counter++;
            }

            if (counter == length) {
                numbers[length] = a;
                if (length == numbers.length - 1 || combinationDFS(numbers, length + 1, isPair)) return true;
            }
        }

        return false;
    }

    private static boolean isConcatenatePrime(int m, int n) {
        final long mn = Functions.concatenateDigits(m, n);
        final long nm = Functions.concatenateDigits(n, m);

        return MillerRabin.isPrime(mn) && MillerRabin.isPrime(nm);
    }
}
