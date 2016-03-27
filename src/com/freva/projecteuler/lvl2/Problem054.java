package com.freva.projecteuler.lvl2;

import com.freva.projecteuler.Problem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Euler problem #54:
//The file contains one-thousand random hands dealt to two players. Each line of the file contains ten cards (separated
//by a single space): the first five are Player 1's cards and the last five are Player 2's cards. You can assume that
//all hands are valid (no invalid characters or repeated cards), each player's hand is in no specific order, and in
//each hand there is a clear winner. How many hands does Player 1 win?
//Answer: 376, Time: 3ms

public class Problem054 implements Problem {
    private static final long FOUR_OF_A_KIND_CARDS = 0xFFF8000000000L;
    private static final long THREE_OF_A_KIND_CARDS = 0x7FFC000000L;
    private static final long TWO_OF_A_KIND_CARDS = 0x3FFE000L;

    private static final String CARD_RANKS = "23456789TJQKA";
    private static final String CARD_SUITS = "HCDS";


    public Number solve() {
        int count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader("res/054.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (getScore(line.substring(0, 14)) > getScore(line.substring(15))) {
                    count++;
                }
            }
        } catch (IOException ignored) { }

        return count;
    }

    /**
     * The scoring system uses a long to represent distribution of cards in hand, the long consists of four 13bit
     * segments where i'th bit in n'th segment, if set, means that there are n i-ranked cards. F.ex. if the 28th bit
     * is set, that means there are 28/13 = 2 cards of rank 28%13=2 (the 4 card, as 0=2, 1=3, ... 11=K, 12=A)
     * <p>
     * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
     * returns 1<<60 + 1111100000000b  (is special case of Straight flush, see below)
     * Straight Flush: All cards are consecutive values of same suit.
     * returns 1<<60 + [distribution of cards]
     * Four of a Kind: Four cards of the same value.
     * returns 1<<59 + [distribution of cards]
     * Full House: Three of a kind and a pair.
     * returns 1<<58 + [distribution of cards]
     * Flush: All cards of the same suit.
     * returns 1<<57 + [distribution of cards]
     * Straight: All cards are consecutive values.
     * returns 1<<56 + [distribution of cards]
     * Three of a Kind: Three cards of the same value.
     * returns 1<<55 + [distribution of cards]
     * Two Pairs: Two different pairs.
     * returns 1<< 54 + [distribution of cards]
     * One Pair: Two cards of the same value.
     * returns 1<< 53 + [distribution of cards]
     * High Card: Highest value card.
     * returns [distribution of cards]
     */
    private static long getScore(String hand) {
        final long distribution = getRankDistribution(hand);
        final boolean isFlush = isFlush(hand);
        final boolean isStraight = isStraight(distribution);

        if (isStraight) {
            if (isFlush) {                                          //Straight flush
                return (1L << 60) + distribution;
            } else {                                                //Straight
                return (1L << 56) + distribution;
            }
        }
        if (isFlush) {
            return (1L << 57) + distribution;
        } else if ((distribution & FOUR_OF_A_KIND_CARDS) > 0) {     //Four of a Kind
            return (1L << 59) + distribution;
        } else if ((distribution & THREE_OF_A_KIND_CARDS) > 0) {
            if ((distribution & TWO_OF_A_KIND_CARDS) > 0) {         //Full House
                return (1L << 58) + distribution;
            } else {                                                //Three of a Kind
                return (1L << 55) + distribution;
            }
        } else if ((distribution & TWO_OF_A_KIND_CARDS) > 0) {           //Two of a Kind
            final long twos = (distribution & TWO_OF_A_KIND_CARDS);
            if ((twos >> (Long.numberOfTrailingZeros(twos) + 1)) > 0) {  //Two Pairs
                return (1L << 54) + distribution;
            } else {                                                //One Pair
                return (1L << 53) + distribution;
            }
        }

        return distribution;                                        //Nothing, return highest card value
    }

    private static long getRankDistribution(String hand) {
        long frequencyCounter = 0;
        for (int i = 0; i < hand.length(); i += 3) {
            frequencyCounter += 1L << (CARD_RANKS.indexOf(hand.charAt(i)) * 3);
        }

        long distribution = 0;
        for (int i = 0; i < 13; i++) {
            int numTimesIAppeared = (int) ((frequencyCounter >> (i * 3)) & 7) - 1;
            if (numTimesIAppeared >= 0) {
                distribution |= 1L << (13 * numTimesIAppeared + i);
            }
        }

        return distribution;
    }

    private static boolean isFlush(String hand) {
        int suits = 0;
        for (int i = 1; i < hand.length(); i += 3) {
            suits |= 1 << CARD_SUITS.indexOf(hand.charAt(i));
        }
        return (suits >> Integer.numberOfTrailingZeros(suits)) == 1;
    }

    private static boolean isStraight(long distribution) {
        return distribution <= (1 << 12) && (distribution >> Long.numberOfTrailingZeros(distribution)) == 31;
    }
}

//#52.0ms
