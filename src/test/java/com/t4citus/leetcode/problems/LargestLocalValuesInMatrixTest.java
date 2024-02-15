package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "2373. Largest Local Values in a Matrix",
        url = "https://leetcode.com/problems/largest-local-values-in-a-matrix/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LargestLocalValuesInMatrixTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(grid(arr(9, 9, 8, 1), arr(5, 6, 2, 6), arr(8, 2, 6, 4), arr(6, 2, 2, 2)), grid(arr(9, 9), arr(8, 6))),
                Arguments.of(grid(arr(1, 1, 1, 1, 1), arr(1, 1, 1, 1, 1), arr(1, 1, 2, 1, 1), arr(1, 1, 1, 1, 1), arr(1, 1, 1, 1, 1)), grid(arr(2, 2, 2), arr(2, 2, 2), arr(2, 2, 2))),
                Arguments.of(grid(arr(1, 2, 3), arr(4, 5, 6), arr(7, 8, 9)), grid(arr(9)))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[][] input, int[][] expectedOutput) {
        // Given

        // When
        int[][] localGrid = largestLocal(input);

        // Then
        System.out.println("largestLocal(" + toString(input) + ") = " + toString(localGrid));
        Assertions.assertThat(IntUtil.equals(localGrid, expectedOutput)).isTrue();
    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] localGrid = new int[n - 2][n - 2];

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < n - 2; j++) {
                localGrid[i][j] = max(grid, i + 1, j + 1);
            }
        }

        return localGrid;
    }

    public int max(int[][] grid, int row, int col) {
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if ((row + i) >= 0 && (row + i) < grid.length && (col + j) >= 0 && (col + j) < grid.length && grid[row + i][col + j] > max) {
                    max = grid[row + i][col + j];
                }
            }
        }
        return max;
    }

    static String toString(int[][] grid) {
        return Arrays.toString(Arrays.stream(grid)
                .map(Arrays::toString)
                .toArray(String[]::new));
    }

    static int[] arr(int... values) {
        return values;
    }

    static int[][] grid(int[]... values) {
        return values;
    }
}
