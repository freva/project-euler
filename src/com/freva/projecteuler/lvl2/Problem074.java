package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #74:
//How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
//Answer: 402, Time: ms

public class Problem074 implements Problem {
    public Number solve() {
        final int LIMIT = 1_000_000;
        final int[] cache = new int[LIMIT];
        cache[169] = cache[363_601] = cache[1_454] = 3;
        cache[871] = cache[45_361] = 2;
        cache[872] = cache[45_362] = 2;
        cache[40_585] = cache[145] = cache[1] = cache[2] = 1;

        int counter = 0;
        for (int i = 3; i < LIMIT; i++) {
            if (lengthOfDigitFactorialsChain(i, cache) == 60) {
                counter++;
            }
        }
        return counter;
    }

    private static int lengthOfDigitFactorialsChain(int a, int[] cache) {
        for (int len = 1, n = a; ; len++) {
            n = sumOfDigitFactorials(n);
            if (n < cache.length && cache[n] != 0)  {
                if (a < cache.length) cache[a] = len + cache[n];
                return len + cache[n];
            }
        }
    }

    private static int sumOfDigitFactorials(int n) {
        int r = 0;
        while (n != 0) {
            r += Functions.TEN_FACTORIALS[n % 10];
            n /= 10;
        }
        return r;
    }
}
