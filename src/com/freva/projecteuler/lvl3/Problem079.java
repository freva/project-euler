package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Project Euler problem #079:
 * Answer: 73162890, Time: 0ms
 *
 * A common security method used for online banking is to ask the user for three random characters from a passcode.
 * For example, if the passcode was 531278, they may ask for the 2nd, 3rd, and 5th characters; the expected reply
 * would be: 317.
 *
 * The text file, res/079.txt, contains fifty successful login attempts.
 *
 * Given that the three characters are always asked for in order, analyse the file so as to determine the shortest
 * possible secret passcode of unknown length.
 */

public class Problem079 implements Problem {
	public Number solve() {
        String[] keys = new String[0];
        int[] occurrences = new int[10];

        try (BufferedReader br = new BufferedReader(new FileReader("res/079.txt"))) {
            keys = br.readLine().split(",");
        } catch (Exception ignored) { }

        /**
         * The strategy is to iterate over all keys while updating an array of digits that occurred to the right of it.
         * occurrences[i] r'th bit denotes whether r has appeared to the right of i in any of the keys. Also set the
         * digit itself as coming after itself.
         * After the array is built up, the left most digit of the passcode is the one with most bits set, while the
         * right most digit of the passcode is the one with fewest, but non-zero (because of each appeared digit will
         * have the self bit set) number of bits set.
         */
		for (String key : keys) {
            int num = Integer.parseInt(key);
            int firstDigit = num / 100;
            int secondDigit = (num / 10) % 10;
            int thirdDigit = num % 10;

            occurrences[firstDigit] |= 1 << firstDigit;
            occurrences[firstDigit] |= 1 << secondDigit;
            occurrences[firstDigit] |= 1 << thirdDigit;
            occurrences[secondDigit] |= 1 << secondDigit;
            occurrences[secondDigit] |= 1 << thirdDigit;
            occurrences[thirdDigit] |= 1 << thirdDigit;
        }

        int nextDigit;
        int passcode = 0;
        while ((nextDigit = getNextDigit(occurrences)) != -1) {
            passcode = 10 * passcode + nextDigit;
            occurrences[nextDigit] = 0;
        }

        return passcode;
	}

    private static int getNextDigit(int[] occurrences) {
        int maxIndex = -1;
        int maxValue = 0;

        for (int i = 0; i < occurrences.length; i++) {
            if (Integer.bitCount(occurrences[i]) > maxValue) {
                maxIndex = i;
                maxValue = Integer.bitCount(occurrences[i]);
            }
        }

        return maxIndex;
    }
}
