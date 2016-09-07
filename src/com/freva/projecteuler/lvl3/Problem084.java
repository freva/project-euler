package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Problem;

import java.util.Random;

/**
 * Project Euler problem #084:
 * Answer: 101524, Time: 16ms
 *
 * In the game, Monopoly, the standard board is set up in the following way:
 * GO	A1	CC1	A2	T1	R1	B1	CH1	B2	B3	JAIL
 * H2                                       C1
 * T2                                       U1
 * H1                                       C2
 * CH3                                      C3
 * R4                                       R2
 * G3                                       D1
 * CC3                                      CC2
 * G2                                       D2
 * G1                                       D3
 * G2J	F3	U2	F2	F1	R3	E3	E2	CH2	E1	FP
 *
 * A player starts on the GO square and adds the scores on two 6-sided dice to determine the number of squares they
 * advance in a clockwise direction. Without any further rules we would expect to visit each square with equal probab-
 * ility: 2.5%. However, landing on G2J (Go To Jail), CC (community chest), and CH (chance) changes this distribution.
 *
 * In addition to G2J, and one card from each of CC and CH, that orders the player to go directly to jail, if a player
 * rolls three consecutive doubles, they do not advance the result of their 3rd roll. Instead they proceed directly to
 * jail.
 *
 * At the beginning of the game, the CC and CH cards are shuffled. When a player lands on CC or CH they take a card
 * from the top of the respective pile and, after following the instructions, it is returned to the bottom of the pile.
 * There are sixteen cards in each pile, but for the purpose of this problem we are only concerned with cards that
 * order a movement; any instruction not concerned with movement will be ignored and the player will remain on the
 * CC/CH square.
 *
 * Community Chest (2/16 cards):
 *      Advance to GO
 *      Go to JAIL
 * Chance (10/16 cards):
 *      Advance to GO
 *      Go to JAIL
 *      Go to C1
 *      Go to E3
 *      Go to H2
 *      Go to R1
 *      Go to next R (railway company)
 *      Go to next R
 *      Go to next U (utility company)
 *      Go back 3 squares.
 *
 * The heart of this problem concerns the likelihood of visiting a particular square. That is, the probability of
 * finishing at that square after a roll. For this reason it should be clear that, with the exception of G2J for which
 * the probability of finishing on it is zero, the CH squares will have the lowest probabilities, as 5/8 request a
 * movement to another square, and it is the final square that the player finishes at on each roll that we are
 * interested in. We shall make no distinction between "Just Visiting" and being sent to JAIL, and we shall also ignore
 * the rule about requiring a double to "get out of jail", assuming that they pay to get out on their next turn.
 *
 * By starting at GO and numbering the squares sequentially from 00 to 39 we can concatenate these two-digit numbers to
 * produce strings that correspond with sets of squares.
 *
 * Statistically it can be shown that the three most popular squares, in order, are JAIL (6.24%) = Square 10,
 * E3 (3.18%) = Square 24, and GO (3.09%) = Square 00. So these three most popular squares can be listed with the
 * six-digit modal string: 102400.
 *
 * If, instead of using two 6-sided dice, two 4-sided dice are used, find the six-digit modal string.
 */

public class Problem084 implements Problem {
    public Number solve() {
        final Random rnd = new Random();
        final int[] cards = {0, 10, 11, 24, 39, 5, 40, 40, 41, -3, 42, 42, 42, 42, 42, 42};
        final int[] freq = new int[40];

        int pos = 0;
        int consecutiveDoubleCounter = 0;
        int currentCardIndex = 0;

        for (int i = 0; i < 300_000; i++) {
            int d1 = rnd.nextInt(4);
            int d2 = rnd.nextInt(4);

            if (d1 == d2) {
                consecutiveDoubleCounter++;
            } else {
                consecutiveDoubleCounter = 0;
            }

            if (consecutiveDoubleCounter == 3) { // If we roll 3 consecutive doubles in a row
                pos = 10;                        // go to JAIL
                consecutiveDoubleCounter = 0;
            } else {
                pos = (pos + d1 + d2 + 2) % freq.length;

                switch (pos) {
                    case 2:     // If we are on one of the Community Chest cells,
                    case 17:
                    case 33:
                        currentCardIndex = (currentCardIndex + 1) % cards.length;
                        if (currentCardIndex == 0)      pos = 0;    // If the current card is the first card, go to GO
                        else if (currentCardIndex == 1) pos = 10;   // If it's the second card, go to JAIL
                        break;

                    case 7:     // If we are on one of the Chance cells,
                    case 22:
                    case 36:
                        currentCardIndex = (currentCardIndex + 1) % cards.length;
                             if (cards[currentCardIndex] < 0)  pos += cards[currentCardIndex]; // Go back 3 cells
                        else if (cards[currentCardIndex] < 40) pos = cards[currentCardIndex];  // Simple go-to cell
                        else if (cards[currentCardIndex] == 40) {   // The railway card
                            if      (pos == 7)  pos = 15;   // CH1 to R2
                            else if (pos == 22) pos = 25;   // CH2 to R3
                            else                pos = 5;    // CH3 to R1
                        } else if (cards[currentCardIndex] == 41) { // The utility card
                            pos = (pos == 22) ? 28 : 12;    // CH2 to U2, otherwise U1
                        }
                        break;

                    case 30:    // G2J to JAIL
                        pos = 10;
                        break;
                }
            }

            freq[pos]++;
        }

        int solution = 0;
        for (int i = 0; i < 3; i++) {
            int largestIndex = getIndexOfLargestElement(freq);
            solution = 100 * solution + largestIndex;
            freq[largestIndex] = 0;
        }

        return solution;
    }

    private static int getIndexOfLargestElement(int array[]) {
        int largestIndex = 0;

        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[largestIndex]) {
                largestIndex = i;
            }
        }

        return largestIndex;
    }
}