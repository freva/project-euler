package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #090:
 * Answer: 1217, Time: 2ms
 *
 * Each of the six faces on a cube has a different digit (0 to 9) written on it; the same is done to a second cube. By
 * placing the two cubes side-by-side in different positions we can form a variety of 2-digit numbers.
 *
 * In fact, by carefully choosing the digits on both cubes it is possible to display all of the square numbers below
 * one-hundred: 01, 04, 09, 16, 25, 36, 49, 64, and 81. For example, one way this can be achieved is by placing
 * {0, 5, 6, 7, 8, 9} on one cube and {1, 2, 3, 4, 8, 9} on the other cube.
 *
 * However, for this problem we shall allow the 6 or 9 to be turned upside-down so that an arrangement like
 * {0, 5, 6, 7, 8, 9} and {1, 2, 3, 4, 6, 7} allows for all nine square numbers to be displayed; otherwise it would
 * be impossible to obtain 09.
 *
 * In determining a distinct arrangement we are interested in the digits on each cube, not the order.
 * {1, 2, 3, 4, 5, 6} is equivalent to {3, 6, 4, 1, 2, 5}
 * {1, 2, 3, 4, 5, 6} is distinct from {1, 2, 3, 4, 5, 9}
 *
 * But because we are allowing 6 and 9 to be reversed, the two distinct sets in the last example both represent the
 * extended set {1, 2, 3, 4, 5, 6, 9} for the purpose of forming 2-digit numbers.
 *
 * How many distinct arrangements of the two cubes allow for all of the square numbers to be displayed?
 */

public class Problem090 implements Problem {
    public Number solve() {
        final int sixAndNineMask = (1 << 6) | (1 << 9);
        final int[] cubes = new int[210]; // 10 choose 6 = 210

        for (int j = 0, i = (1 << 6) - 1; j < cubes.length; j++) { // Smallest number with 6 bits set is 2^6 - 1
            if ((i & sixAndNineMask) != 0) { // If 6th or 9th bit is set
                cubes[j] = i | sixAndNineMask; // Set both of them
            } else {
                cubes[j] = i;
            }

            // Bitwise hack to generate next permutation with same number of ones
            int t = i | (i - 1);
            i = (t + 1) | (((~t & -~t) - 1) >> (Integer.numberOfTrailingZeros(i) + 1));
        }

        int numberDistinctArrangements = 0;
        for (int i = 0; i < cubes.length; i++) {
            for (int j = i + 1; j < cubes.length; j++) {
                if (hasArrangementsAllSquares(cubes[i], cubes[j])) {
                    numberDistinctArrangements++;
                }
            }
        }

        return numberDistinctArrangements;
    }

    private static boolean hasArrangementsAllSquares(int c1, int c2) {
        for (int i = 1; i < 10; i++) {
            int s1 = Functions.TEN_SQUARES[i] % 10;
            int s2 = Functions.TEN_SQUARES[i] / 10;

            // If c1 has s1th bit set and c2 has s2th bit set OR c1 has s2th bit set and c2 has s1th bit set
            if (((c1 & (1<<s1)) * (c2 & (1<<s2))) == 0 && ((c1 & (1<<s2)) * (c2 & (1<<s1))) == 0) {
                return false;
            }
        }

        return true;
    }
}