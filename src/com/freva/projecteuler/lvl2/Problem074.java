package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #074:
 * Answer: 402, Time: 23ms
 *
 * The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:
 * 1! + 4! + 5! = 1 + 24 + 120 = 145
 *
 * Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns
 * out that there are only three such loops that exist:
 * 169 → 363601 → 1454 → 169
 * 871 → 45361 → 871
 * 872 → 45362 → 872
 *
 * It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,
 * 69 → 363600 → 1454 → 169 → 363601 (→ 1454)
 * 78 → 45360 → 871 → 45361 (→ 871)
 * 540 → 145 (→ 145)
 *
 * Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting
 * number below one million is sixty terms.
 *
 * How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?
 */

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
