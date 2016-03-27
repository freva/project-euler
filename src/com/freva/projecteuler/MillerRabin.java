package com.freva.projecteuler;

public class MillerRabin {
    //Deterministic up to 4,759,123,141
    private static int[] getPrimesToTest(long n) {
        if (n < 2047) {
            return new int[]{2};
        } else if (n < 1_373_653) {
            return new int[]{2, 3};
        } else if (n < 9_080_191) {
            return new int[]{31, 73};
        } else if (n < 25_326_001) {
            return new int[]{2, 3, 5};
        }

        return new int[]{2, 3, 5, 7};
    }

    private static boolean testNumber(long n, long a) {
        long s = 0;
        long d = n - 1;
        for (; (d & 1) == 0; s++) {
            d >>= 1;
        }

        long x = Functions.modPow(a, d, n);
        if (x != 1 && x != n - 1) {
            for (long r = 1; r < s; r++) {
                x = (x * x) % n;
                if (x == 1) {
                    return false;
                } else if (x == n - 1) {
                    return true;
                }
            }
            return false;
        }

        return true;
    }

    public static boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if ((n & 1) == 0) return false;

        for (long test : getPrimesToTest(n)) {
            if (test < n && !testNumber(n, test)) {
                return false;
            }
        }

        return true;
    }
}
