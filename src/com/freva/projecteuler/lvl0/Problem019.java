package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

//Euler problem #19:
//How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
//Answer: 171, Time: 0ms

public class Problem019 implements Problem {
	public Number solve() {
        final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int day = 365 % 7; //01/01/1900 is Monday (0), 01/01/1901 is X (365%7)
        int counter = 0;

		for (int year = 1901; year < 2001; year++) {
			for (int month = 0; month < 12; month++) {
				day += daysInMonth[month];

                //Account for leap day
				if (month==1 && year % 4 == 0) {
                    day++;
                }

				if ((day %= 7) == 6) {
                    counter++;
                }
			}
		}
		
		return counter;
	}
}
