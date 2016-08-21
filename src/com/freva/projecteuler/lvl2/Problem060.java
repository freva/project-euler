package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.MillerRabin;
import com.freva.projecteuler.Problem;

//Euler problem #60:
//Find the lowest sum for a set of five primes for which any two primes concatenate to produce another prime.
//Answer: 26033, Time: 390ms

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
