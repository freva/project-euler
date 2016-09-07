package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #086:
 * Answer: 1818, Time: 20ms
 *
 * A spider, S, sits in one corner of a cuboid room, measuring 6 by 5 by 3, and a fly, F, sits in the opposite corner.
 * By travelling on the surfaces of the room the shortest "straight line" distance from S to F is 10.
 *
 * However, there are up to three "shortest" path candidates for any given cuboid and the shortest route doesn't
 * always have integer length.
 *
 * It can be shown that there are exactly 2060 distinct cuboids, ignoring rotations, with integer dimensions, up to a
 * maximum size of M by M by M, for which the shortest route has integer length when M = 100. This is the least value
 * of M for which the number of solutions first exceeds two thousand; the number of solutions when M = 99 is 1975.
 *
 * Find the least value of M such that the number of solutions first exceeds one million.
 */

public class Problem086 implements Problem {
    public Number solve() {
        /**
         * The shortest path in a cube of size x, y, z with x <= y <= z is sqrt((x+y)^2 + z^2). We can simplify our
         * search by defining x + y = j and z = i, then j <= 2*i. If sqrt(j^2 + i^2) produces an integer, we have
         * a solution. Each solution of the previous equation produces several solutions of the original problem
         * since x and y can take different values while still producing the same j. Number of original solutions is
         * equal to the number of ways of choosing x and y while maintaining 1 <= x <= y <= z <= M and x + y = j
         */
        final int target = 1_000_000;
        for (int i = 2, count = 0; ; i++) {
            for (int j = 3; j <= 2 * i; j++) {
                double sqrt = Math.sqrt(j * j + i * i);

                if (sqrt == (int) sqrt) {
                    count += (j > i) ? i - (j - 1) / 2 : j / 2;

                    if (count >= target) {
                        return i;
                    }
                }

            }
        }
    }
}
