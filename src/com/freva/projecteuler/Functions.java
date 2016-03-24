package com.freva.projecteuler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Functions {
    /**
     * Factorials for the first ten numbers (all single digits). TEN_FACTORIALS[3] = 3!
     */
    public static final int[] TEN_FACTORIALS = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40_320, 362_880};


    /**
     * Lexically reverses the number without going via String. 2341 => 1432
     * @param number Number to reverse
     * @return number reversed
     */
    public static long reverseNumber(long number) {
        long reversed = 0;
        for (long n=number; n > 0; ) {
            reversed = reversed*10 + (n % 10);
            n /= 10;
        }

        return reversed;
    }


    /**
     * Checks if number is palindromic
     * @param number number to check
     * @return true if palindromic, false otherwise
     */
    public static boolean isPalindrome(long number) {
        return reverseNumber(number) == number;
    }


    /**
     * Returns the largest positive integer that divides the numbers without a remainder
     */
    public static long greatestCommonDivisor(long a, long b) {
        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }


    /**
     * Returns the smallest positive integer that is divisible by both a and b
     */
    public static long leastCommonMultiple(long a, long b) {
        return a * (b / greatestCommonDivisor(a, b));
    }


    public static boolean isPrime(long n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;

        final long sqrtN = (long) Math.sqrt(n)+1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n%(i-1) == 0 || n%(i+1) == 0) {
                return false;
            }
        }

        return true;
    }

    /**
     * Generates an array of length n + 1 where i'th index is set to true if i is composite and false if i is prime
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        final boolean[] isComposite = new boolean[n + 1];

        for (int i=2; i*i <= n; i++) {
            if (! isComposite[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    isComposite[j] = true;
                }
            }
        }

        return isComposite;
    }

    /**
     * Very fast prime number generator
     * http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
     * @param n largest number to consider for primes
     * @return List of primes <= n
    */
    public static List<Integer> getPrimesBelow(int n) {
        final boolean[] isComposite = sieveOfEratosthenes(n);

        List<Integer> primes = new ArrayList<>((int) (n / (Math.log(n)-1)));
        for(int i = 2; i <= n; i++) {
            if (! isComposite[i]) {
                primes.add(i);
            }
        }

        return primes;
    }

    /**
     * Checks if number is 1 through n pandigital where n = length of number and is <= 9
     */
    public static boolean isPandigital(long number) {
        int digits = 0;
        int count = 1;

        for (; number > 0; number /= 10, count++) {
            digits |= 1 << (number % 10);
        }

        return digits == (1 << count) - 2;
    }

    public static long sum(Collection<Integer> numbers) {
        long sum = 0;
        for(Integer number: numbers) {
            sum += number;
        }

        return sum;
    }
}
