package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #018:
 * Answer: 171, Time: 0ms
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 * 1 Jan 1900 was a Monday.
 * Thirty days has September, April, June and November.
 * All the rest have thirty-one,
 * Saving February alone, Which has twenty-eight, rain or shine. And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 */

public class Problem019 implements Problem {
    public Number solve() {
        final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int currentDayOfTheWeek = 365 % 7; // 01/01/1900 is Monday (0), 01/01/1901 is X (365%7)
        int numberOfSundays = 0;

        for (int year = 1901; year < 2001; year++) {
            for (int month = 0; month < 12; month++) {
                currentDayOfTheWeek += daysInMonth[month];

                // Account for leap day
                if (month == 1 && year % 4 == 0) {
                    currentDayOfTheWeek++;
                }

                if ((currentDayOfTheWeek %= 7) == 6) {
                    numberOfSundays++;
                }
            }
        }

        return numberOfSundays;
    }
}
