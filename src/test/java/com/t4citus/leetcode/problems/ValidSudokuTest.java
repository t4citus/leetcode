package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Leetcode(
        title = "36. Valid Sudoku",
        url = "https://leetcode.com/problems/valid-sudoku/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class ValidSudokuTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        board(
                                row('5', '3', '.', '.', '7', '.', '.', '.', '.'),
                                row('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                                row('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                                row('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                                row('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                                row('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                                row('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                                row('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                                row('.', '.', '.', '.', '8', '.', '.', '7', '9')
                        ),
                        true
                ),
                Arguments.of(
                        board(
                                row('8', '3', '.', '.', '7', '.', '.', '.', '.'),
                                row('6', '.', '.', '1', '9', '5', '.', '.', '.'),
                                row('.', '9', '8', '.', '.', '.', '.', '6', '.'),
                                row('8', '.', '.', '.', '6', '.', '.', '.', '3'),
                                row('4', '.', '.', '8', '.', '3', '.', '.', '1'),
                                row('7', '.', '.', '.', '2', '.', '.', '.', '6'),
                                row('.', '6', '.', '.', '.', '.', '2', '8', '.'),
                                row('.', '.', '.', '4', '1', '9', '.', '.', '5'),
                                row('.', '.', '.', '.', '8', '.', '.', '7', '9')
                        ),
                        false
                ),
                Arguments.of(
                        board(
                                row('.', '.', '4', '.', '.', '.', '6', '3', '.'),
                                row('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                                row('5', '.', '.', '.', '.', '.', '.', '9', '.'),
                                row('.', '.', '.', '5', '6', '.', '.', '.', '.'),
                                row('4', '.', '3', '.', '.', '.', '.', '.', '1'),
                                row('.', '.', '.', '7', '.', '.', '.', '.', '.'),
                                row('.', '.', '.', '5', '.', '.', '.', '.', '.'),
                                row('.', '.', '.', '.', '.', '.', '.', '.', '.'),
                                row('.', '.', '.', '.', '.', '.', '.', '.', '.')
                        ),
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(char[][] board, boolean expectedValidSudoku) {
        // Given
        String boardAsString = toString(board);

        // When
        boolean validSudoku = isValidSudoku(board);

        // Then
        System.out.println("isValidSudoku(" + boardAsString + ") = " + validSudoku);
        Assertions.assertThat(validSudoku).isEqualTo(expectedValidSudoku);
    }

    public boolean isValidSudoku(char[][] board) {
        int[] counts = new int[10];

        // check rows
        for (char[] row : board) {
            Arrays.fill(counts, 0);
            for (char ch : row) {
                if (ch != '.') {
                    counts[ch - '1']++;
                    if (counts[ch - '1'] > 1) return false;
                }
            }
        }

        // check columns
        for (int col = 0; col < 9; col++) {
            Arrays.fill(counts, 0);
            for (int row = 0; row < 9; row++) {
                char ch = board[row][col];
                if (ch != '.') {
                    counts[ch - '1']++;
                    if (counts[ch - '1'] > 1) return false;
                }
            }
        }

        // check 3x3 boxes
        for (int br = 0; br < 3; br++) {
            for (int bc = 0; bc < 3; bc++) {
                int topLeftX = br * 3;
                int topLeftY = bc * 3;
                char[] box = {
                        board[topLeftX][topLeftY],
                        board[topLeftX][topLeftY + 1],
                        board[topLeftX][topLeftY + 2],
                        board[topLeftX + 1][topLeftY],
                        board[topLeftX + 1][topLeftY + 1],
                        board[topLeftX + 1][topLeftY + 2],
                        board[topLeftX + 2][topLeftY],
                        board[topLeftX + 2][topLeftY + 1],
                        board[topLeftX + 2][topLeftY + 2]
                };

                Arrays.fill(counts, 0);
                for (char ch : box) {
                    if (ch != '.') {
                        counts[ch - '1']++;
                        if (counts[ch - '1'] > 1) return false;
                    }
                }
            }
        }

        return true;
    }

    private static char[] row(char... values) {
        return values;
    }

    private static char[][] board(char[]... rows) {
        return rows;
    }

    private static String toString(char[][] board) {
        return Arrays.stream(board).map(Arrays::toString).collect(Collectors.joining(", "));
    }
}
