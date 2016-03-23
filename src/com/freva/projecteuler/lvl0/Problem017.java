package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #17:
//If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
//Answer: 21124, Time: 0ms

public class Problem017 implements Problem {
    //Word lengths of the first twenty numbers, position i refers to the i'th number, so firstTwenty[6] = 3 (six)
    private static final int[] firstTwenty = {0, 3, 3, 5, 4, 4, 3, 5, 5, 4, 3, 6, 6, 8, 8, 7, 7, 9, 8, 8};
    //Word lengths of the tens, position i refers to the i'th tenth, so tens[5] = 5 (fifty)
    private static final int[] tens = {0, 0, 6, 6, 5, 5, 5, 7, 6, 6};


	public Number solve() {
        int total = 11; //Initialize to 11 for "one thousand"

        for (int i=1; i<1000; i++) {
            total += getNumberLength(i);
        }

        return total;
	}

    private static int getNumberLength(int number) {
        int length = 0;

        //Add length of the tens + last digit / last two digits if <20:
        final int lastTwoDigits = number%100;
        length += (lastTwoDigits < 20) ? firstTwenty[lastTwoDigits] : tens[lastTwoDigits/10] + firstTwenty[lastTwoDigits%10];

        //Add hundreds if present:
        if (number >= 100) {
            //Add 7 for "hundred", if lastTwoDigits is any other number than two, we also need to add 3 for "and"
            length += firstTwenty[number/100] + 7 + (lastTwoDigits != 0 ? 3 : 0);
        }

        return length;
    }
}
