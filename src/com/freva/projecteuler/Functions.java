package com.freva.projecteuler;

import java.math.BigInteger;
import java.util.Arrays;

public class Functions {
    /**
     * Factorials for the first ten numbers (all single digits). TEN_FACTORIALS[3] = 3!
     */
    public static final int[] TEN_FACTORIALS = new int[] {1, 1, 2, 6, 24, 120, 720, 5040, 40_320, 362_880, 3_628_800};

    /**
     * Contains the ten first prime numbers
     */
    public static final int[] TEN_PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    /**
     * Contains the then first square numbers
     */
    public static final int[] TEN_SQUARES = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81};


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


    public static long modPow(long a, long b, long mod) {
        long result = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                result = (result * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return result;
    }

    public static long pow(int a, int b) {
        long result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return result;
    }

    /**
     * Generates an array of length n + 1 where i'th index is set to true if i is composite and false if i is prime
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        final boolean[] isComposite = new boolean[n + 1];
        isComposite[0] = isComposite[1] = true;

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
    public static int[] getPrimesBelow(int n) {
        final boolean[] isComposite = sieveOfEratosthenes(n);

        int index = 0;
        final int[] primes = new int[(int) (n / (Math.log(n)-4))];
        for(int i = 2; i <= n; i++) {
            if (! isComposite[i]) {
                primes[index++] = i;
            }
        }

        return Arrays.copyOfRange(primes, 0, index);
    }

    /**
     * Gets the n first prime numbers using sieveOfEratosthenes() with upper limit at n * (log(n) + log(log(n)))
     */
    public static int[] getNPrimes(int n) {
        final boolean[] isComposite = sieveOfEratosthenes((int) (n * (Math.log(n) + Math.log(Math.log(n)))));

        final int[] primes = new int[n + 1];
        for(int i = 2, index = 0; index <= n; i++) {
            if (! isComposite[i]) {
                primes[index++] = i;
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

    /**
     * Checks if numbers contains some digit more than once
     */
    public static boolean hasDuplicateDigits(long number) {
        for (int digits = 0, temp = 0; number > 0; temp = digits, number /= 10) {
            digits |= 1 << (number % 10);
            if (temp == digits) {
                return true;
            }
        }

        return false;
    }

    /**
     * Concatenates digits to a single long
     */
    public static long concatenateDigits(int... digits) {
        if (digits.length == 1) return digits[0];

        long concatenated = digits[0];
        for (int j = 1, temp; j < digits.length; j++) {
            temp = digits[j];
            while (temp > 0) {
                temp /= 10;
                concatenated *= 10;
            }
            concatenated += digits[j];
        }

        return concatenated;
    }

    /**
     * Checks if the numbers are digit permutations of each other, f.ex. 123, 231, 312 => true, 1234, 3244 => false
     */
    public static boolean arePermutationsOfEachOther(int... numbers) {
        final long firstSignature = getNumberSignature(numbers[0]);

        for (int i = 1; i<numbers.length; i++) {
            if (firstSignature != getNumberSignature(numbers[i])) {
                return false;
            }
        }

        return true;
    }

    public static long getNumberSignature(long number) {
        long signature = 1;
        while (number > 0) {
            signature *= TEN_PRIMES[(int) (number % 10)];
            number /= 10;
        }

        return signature;
    }

    public static int sumOfDigits(BigInteger bigInteger) {
        int sumOfDigits = 0;
        for (char c : bigInteger.toString().toCharArray()) {
            sumOfDigits += c - '0';
        }

        return sumOfDigits;
    }
}
