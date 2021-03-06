package com.freva.projecteuler.lvl0;

import com.freva.projecteuler.Problem;

/**
 * Project Euler problem #008:
 * Answer: 23514624000, Time: 0ms
 *
 * The four adjacent digits in the 1000-digit number that have the greatest product are 9 × 9 × 8 × 9 = 5832.
 * Find the thirteen adjacent digits in the 1000-digit number that have the greatest product. What is the value of
 * this product?
 */

public class Problem008 implements Problem {
    public Number solve() {
        final String input = "73167176531330624919225119674426574742355349194934969835203127745063262395783180169848" +
                "018694788518438586156078911294949545950173795833195285320880551112540698747158523863050715693290963" +
                "295227443043557668966489504452445231617318564030987111217223831136222989342338030813533627661428280" +
                "644448664523874930358907296290491560440772390713810515859307960866701724271218839987979087922749219" +
                "016997208880937766572733300105336788122023542180975125454059475224352584907711670556013604839586446" +
                "706324415722155397536978179778461740649551492908625693219784686224828397224137565705605749026140797" +
                "296865241453510047482166370484403199890008895243450658541227588666881164271714799244429282308634656" +
                "748139191231628245861786645835912456652947654568284891288314260769004224219022671055626321111109370" +
                "544217506941658960408071984038509624554443629812309878799272442849091888458015616609791913387549920" +
                "052406368991256071760605886116467109405077541002256983155200055935729725716362695618826704282524836" +
                "00823257530420752963450";

        final int sequenceLength = 13;
        long sequence = 0;
        long largestProduct = 0;

        for (int i = 0; i < input.length(); i++) {
            sequence = (sequence << 4) | (input.charAt(i) - '0'); // Push current digit into long, occupying the last 4 bits

            long product = 1;
            for (int j = 0; j < sequenceLength; j++) { // Go through groups of 4 and 4 bits, multiplying them with each other
                product *= (sequence >> (4 * j)) & 0xF;
            }

            if (product > largestProduct) {
                largestProduct = product;
            }
        }

        return largestProduct;
    }
}
