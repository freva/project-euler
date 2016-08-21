package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

//Euler problem #61:
//Find the sum of the only ordered set of six cyclic 4-digit numbers for which each polygonal type: triangle, square,
//pentagonal, hexagonal, heptagonal, and octagonal, is represented by a different number in the set.
//Answer: 28684, Time: 0ms

public class Problem061 implements Problem {
    public Number solve() {
        //Fills polygons with polygonal numbers numberOfFractionsBetween 1000 < x < 10000 with x%100 >= 10.
        //polygons is reverse ordered (polygons[0] are octagonal numbers, polygons[5] are the triangle numbers)
        final int[][] polygons = new int[6][100];
        for (int i = 0; i < polygons.length; i++) {
            for (int j = 0, number = 0, add = 1; number < 10_000; number += add, add += i + 1) {
                if (number > 1000 && number % 100 >= 10) {
                    polygons[polygons.length - 1 - i][j++] = number;
                }
            }
        }

        //Iterate over one of the polygons and try all possible variants
        for (int i = 0; ; i++) {
            int sum = sumOfPolygonalCycle(polygons, 1, polygons[0][i] / 100, polygons[0][i] % 100);
            if (sum != 0) return polygons[0][i] + sum;
        }
    }

    /**
     * Attempts to find a polygonal type number cycle using DFS in order.
     *
     * @param polygons array of polygonal type numbers, doesn't matter in which order
     * @param used     integer declaring which polygonal types have already been used. If polygonal[i] is already used,
     *                 then i'th bit of 'used' will be set
     * @param start    First two digits of the cycle
     * @param end      Last two digits of the cycle
     * @return Sum of all the numbers in the cycle if a cycle is found, 0 otherwise
     */
    private static int sumOfPolygonalCycle(int[][] polygons, int used, int start, int end) {
        //Iterate over polygonal types
        for (int i = 0; i < polygons.length; i++) {
            //Until we find a type that we haven't used yet
            if ((used & (1 << i)) == 0) {
                //Iterate over all numbers for that polygonal type
                for (int j = 0; polygons[i][j] != 0; j++) {
                    //If this number can be attached to the front of the already found cycle...
                    if (end == polygons[i][j] / 100) {
                        //If we have used all polygonal types once...
                        if (Integer.bitCount(used) == polygons.length - 1) {
                            //If the new end of the cycle matches the start of the cycle, we are done! Return last number
                            if (polygons[i][j] % 100 == start) return polygons[i][j];

                        } else {
                            //We still have polygonal types left, search deeper!
                            int answer = sumOfPolygonalCycle(polygons, used | (1 << i), start, polygons[i][j] % 100);
                            //If we received non-zero result, that means we found a cycle, add our number and return to parent
                            if (answer > 0) {
                                return answer + polygons[i][j];
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
