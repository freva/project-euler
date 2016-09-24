package com.freva.projecteuler.lvl3;

import com.freva.projecteuler.Functions;
import com.freva.projecteuler.Problem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * Project Euler problem #096:
 * Answer: 24702, Time: 6ms
 *
 * Su Doku (Japanese meaning number place) is the name given to a popular puzzle concept. Its origin is unclear, but
 * credit must be attributed to Leonhard Euler who invented a similar, and much more difficult, puzzle idea called
 * Latin Squares. The objective of Su Doku puzzles, however, is to replace the blanks (or zeros) in a 9 by 9 grid in
 * such that each row, column, and 3 by 3 box contains each of the digits 1 to 9. Below is an example of a typical
 * starting puzzle grid and its solution grid.
 *
 * A well constructed Su Doku puzzle has a unique solution and can be solved by logic, although it may be necessary to
 * employ "guess and test" methods in order to eliminate options (there is much contested opinion over this). The
 * complexity of the search determines the difficulty of the puzzle; the example above is considered easy because it
 * can be solved by straight forward direct deduction.
 *
 * The text file, res/096.txt, contains fifty different Su Doku puzzles ranging in difficulty, but all with unique
 * solutions (the first puzzle in the file is the example above).
 *
 * By solving all fifty puzzles find the sum of the 3-digit numbers found in the top left corner of each solution grid;
 * for example, 483 is the 3-digit number found in the top left corner of the solution grid above.
 */

public class Problem096 implements Problem {
    public Number solve() {
        int total = 0;

        int[] board = new int[9 * 9];
        final int[] possibleValues = new int[board.length];
        try (BufferedReader br = new BufferedReader(new FileReader("res/096.txt"))) {
            for (int game = 0; game < 50; game++) {
                br.readLine();

                Arrays.fill(possibleValues, 0b1111111110);
                for (int ln = 0, cellNumber = 0; ln < 9; ln++) {
                    for (char c : br.readLine().toCharArray()) {
                        setCellValue(board, possibleValues, cellNumber++, (int) c - '0');
                    }
                }

                board = solveSudoku(board, possibleValues);
                assert board != null;
                total += Functions.concatenateDigits(board[0], board[1], board[2]);
            }
        } catch (IOException ignored) { }

        return total;
    }


    private static int[] solveSudoku(int[] board, int[] possibleValues) {
        int solved;
        boolean hasChanged;
        do {
            solved = 0;
            hasChanged = false;

            for (int i = 0; i < board.length; i++) {
                if (board[i] != 0) solved++;

                    // If we still haven't set the cell value, and there is only 1 option, set it
                else if (Integer.bitCount(possibleValues[i]) == 1) {
                    setCellValue(board, possibleValues, i, Integer.numberOfTrailingZeros(possibleValues[i]));
                    solved++;
                    hasChanged = true;

                    // If a cell has no options left, we are in an illegal state because of wrong guess
                } else if (Integer.bitCount(possibleValues[i]) == 0) return null;
            }
        } while (solved != board.length && hasChanged);
        if (solved == board.length) return board; // If we have filled all the cells, we are done!

        // Otherwise, find the cell with the smallest domain size and try guessing all of them until we find the solution
        int smallestDomainCellNumber = getSmallestDomainCellNumber(possibleValues);
        for (int i = 1; i < 10; i++) {
            if ((possibleValues[smallestDomainCellNumber] & (1 << i)) > 0) {
                int[] guessedBoard = board.clone();
                int[] guessedPossibleValues = possibleValues.clone();
                setCellValue(guessedBoard, guessedPossibleValues, smallestDomainCellNumber, i);

                guessedBoard = solveSudoku(guessedBoard, guessedPossibleValues);
                if (guessedBoard != null) return guessedBoard;
            }
        }

        return null;
    }

    private static void setCellValue(int[] board, int[] possibleValues, int cellNumber, int cellValue) {
        board[cellNumber] = cellValue;
        if (cellValue == 0) return;

        int row = cellNumber / 9;
        int col = cellNumber % 9;

        // Unset the cellValue'th bit for all cells on the row and column that the cellNumber is on
        for (int i = 0; i < 9; i++) {
            possibleValues[9 * row + i] &= ~(1 << cellValue);
            possibleValues[9 * i + col] &= ~(1 << cellValue);
        }

        // Unset the cellValue'th bit for all the cells in the 3x3 block that the cellNumber is in
        int firstRowInBlock = (row / 3) * 3;
        int firstColInBlock = (col / 3) * 3;
        for (int rowInBlock = firstRowInBlock; rowInBlock < firstRowInBlock + 3; rowInBlock++) {
            for (int colInBlock = firstColInBlock; colInBlock < firstColInBlock + 3; colInBlock++) {
                possibleValues[9 * rowInBlock + colInBlock] &= ~(1 << cellValue);
            }
        }

        possibleValues[cellNumber] = 1 << cellValue; // cellNumbers only possibility is cellValue
    }

    private static int getSmallestDomainCellNumber(int[] possibleValues) {
        int smallestDomainCellNumber = -1;
        int smallestDomainLength = Integer.MAX_VALUE;

        for (int i = 0; i < possibleValues.length; i++) {
            int domainLength = Integer.bitCount(possibleValues[i]);
            if (domainLength > 1 && domainLength < smallestDomainLength) {
                smallestDomainCellNumber = i;
                smallestDomainLength = domainLength;
            }
        }
        return smallestDomainCellNumber;
    }
}