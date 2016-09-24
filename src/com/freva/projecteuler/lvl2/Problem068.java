package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.ArrayFunctions;
import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #068:
 * Answer: 6531031914842725, Time: 0ms
 *
 * Consider the following "magic" 3-gon ring, filled with the numbers 1 to 6, and each line adding to nine. Working
 * clockwise, and starting from the group of three with the numerically lowest external node (4,3,2 in this example),
 * each solution can be described uniquely. For example, the above solution can be described by the set: 4,3,2; 6,2,1; 5,1,3.
 *
 * It is possible to complete the ring with four different totals: 9, 10, 11, and 12. There are eight solutions in total.
 *
 * Total	Solution Set
 * 9	4,2,3; 5,3,1; 6,1,2
 * 9	4,3,2; 6,2,1; 5,1,3
 * 10	2,3,5; 4,5,1; 6,1,3
 * 10	2,5,3; 6,3,1; 4,1,5
 * 11	1,4,6; 3,6,2; 5,2,4
 * 11	1,6,4; 5,4,2; 3,2,6
 * 12	1,5,6; 2,6,4; 3,4,5
 * 12	1,6,5; 3,5,4; 2,4,6
 * By concatenating each group it is possible to form 9-digit strings; the maximum string for a 3-gon ring is 432621513.
 *
 * Using the numbers 1 to 10, and depending on arrangements, it is possible to form 16- and 17-digit strings. What is
 * the maximum 16-digit string for a "magic" 5-gon ring?
 */

public class Problem068 implements Problem {
    private static final int LINE_SUM = 14;

    public Number solve() {
        /**
         * 16-digit string is forcing 10 to be in the outer ring. Also since we are looking for the maximum 16-digit
         * string, and the string is formed by starting with the numerically lowest external node, the other outer
         * numbers must be 6, 7, 8 and 9. We also know that the 16-digit string starts with '6'.
         *
         * All 'lines' have the same sum, x, there are 5 lines, with the inner ring being [1, 2, 3, 4, 5] in some
         * order, and the outer ring being [6, 7, 8, 9, 10] in some order, we have:
         * 5*x = 2*sum(inner ring) + sum(outer ring) = 2*15 + 40 = 70 ==> x = 14
         *
         * For each combination of outer ring, of which there are 4! = 24, we need to try all 5 inner ring numbers at a
         * position, the remaining inner ring positions are forced.
         */

        int[] outerRing = {6, 7, 8, 9, 10};
        long maximum = 0;
        while (outerRing[0] == 6) {
            for (int firstInnerRingNumber = 5; firstInnerRingNumber > 0; firstInnerRingNumber--) {
                long solution = solveFiveGon(outerRing, firstInnerRingNumber);
                if (solution > maximum) {
                    maximum = solution;
                }
            }
            ArrayFunctions.nextPermutation(outerRing);
        }

        return maximum;
    }

    /**
     * Attempts to find solution to a five-gon with a given outer-ring and the first digit of the inner-ring.
     */
    private static long solveFiveGon(int[] outerRing, int firstInnerRingNumber) {
        int[] solution = new int[15]; // The solution is a concatenation of 15 numbers (but 16-digits)
        solution[0] = outerRing[0]; // The first number in the 15-number solution is the first number of the outer-ring
        solution[1] = firstInnerRingNumber; // Then the first number of the inner ring
        solution[2] = LINE_SUM - solution[0] - solution[1]; // The last number of the first ine is forced
        int used = 1 << solution[2]; // Mark the last number of first line as used

        for (int line = 1; line < outerRing.length; line++) { // For each of the remaining lines, follow the same approach
            solution[3 * line] = outerRing[line];
            solution[3 * line + 1] = solution[3 * line - 1];
            solution[3 * line + 2] = LINE_SUM - solution[3 * line] - solution[3 * line + 1];

            // Make sure that the forced number is numberOfFractionsBetween 1 and 5, and that it has not been used before by checking it
            // against a bit mask where the i'th bit shows if number i has already been used in the inner-ring.
            if (solution[3 * line + 2] > 5 || (used | (1 << solution[3 * line + 2])) == used) return -1;
            else used |= (1 << solution[3 * line + 2]);
        }

        return Functions.concatenateDigits(solution);
    }
}
