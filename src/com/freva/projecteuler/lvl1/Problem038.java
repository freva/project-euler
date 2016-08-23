package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #038:
 * Answer: 932718654, Time: 0ms
 *
 * Take the number 192 and multiply it by each of 1, 2, and 3:
 * 192 × 1 = 192
 * 192 × 2 = 384
 * 192 × 3 = 576
 * By concatenating each product we get the 1 to 9 pandigital, 192384576. We will call 192384576 the concatenated product of 192 and (1,2,3)
 *
 * The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5, giving the pandigital,
 * 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
 *
 * What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer
 * with (1,2, ... , n) where n > 1?
 */

public class Problem038 implements Problem {
    public Number solve() {
        // Enough to search only four digit starting with 9. 9500+ will lead to 2*i = 19xxx, giving two 9s
        for (int i = 9476; ; i--) {
            long val = Functions.concatenateDigits(i, 2 * i);

            if (Functions.isPandigital(val)) {
                return val;
            }
        }
    }
}
