package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #099:
 * Answer: 709, Time: 8ms
 *
 * Comparing two numbers written in index form like 211 and 37 is not difficult, as any calculator would confirm that
 * 2^11 = 2048 < 3^7 = 2187.
 *
 * However, confirming that 632382^518061 > 519432^525806 would be much more difficult, as both numbers contain over
 * three million digits.
 *
 * Using the text file, res/099.txt, containing one thousand lines with a base/exponent pair on each line, determine
 * which line number has the greatest numerical value.
 * NOTE: The first two lines in the file represent the numbers in the example given above.
 */

public class Problem099 implements Problem {
	public Number solve() {
		int greatestValueLineNumber = 0;
        double logGreatestValue = 0;

		// Exploit the property that log(x^y) = y * log(x)
        try (BufferedReader br = new BufferedReader(new FileReader("res/099.txt"))) {
			for (int i = 1; i <= 1000; i++) {
                String[] nums = br.readLine().split(",");
                double temp = Double.parseDouble(nums[1]) * Math.log(Double.parseDouble(nums[0]));
				if (temp > logGreatestValue) {
					logGreatestValue = temp;
					greatestValueLineNumber = i;
				}
			}
		} catch (Exception ignored) { }
		
		return greatestValueLineNumber;
	}
}
