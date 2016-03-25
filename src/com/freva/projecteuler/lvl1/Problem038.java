package com.freva.projecteuler.lvl1;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

//Euler problem #38:
//What is the largest 1 to 9 pandigital 9-digit number that can be formed as the concatenated product of an integer
//with (1,2, ... , n) where n > 1?
//Answer: 932718654, Time: 0ms

public class Problem038 implements Problem {
    public Number solve() {
        //Enough to search only 4 digit starting with 9. 9500+ will lead to 2*i = 19xxx, giving 2 9s
        for (int i = 9476; ; i--) {
            long val = Functions.concatenateDigits(i, 2*i);

            if(Functions.isPandigital(val)) {
                return val;
            }
        }
    }
}
