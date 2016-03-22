package com.freva.projecteuler;

public class Functions {
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
}
