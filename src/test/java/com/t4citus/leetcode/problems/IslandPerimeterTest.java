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
        title = "463. Island Perimeter",
        url = "https://leetcode.com/problems/island-perimeter/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class IslandPerimeterTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(grid(row(0,1,0,0), row(1,1,1,0), row(0,1,0,0),row(1,1,0,0)), 16),
                Arguments.of(grid(row(1)), 4),
                Arguments.of(grid(row(1,0)), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[][] grid, int expectedPerimeter) {
        // Given

        // When
        int perimeter = islandPerimeter(grid);

        // Then
        System.out.println("islandPerimeter(" + toString(grid) + ") = " + perimeter);
        Assertions.assertThat(perimeter).isEqualTo(expectedPerimeter);
    }

    public static final int LAND = 1;
    public static final int WATER = 0;

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == LAND) {
                    // check left border
                    if (col == 0) perimeter += 1;
                    if (col > 0 && grid[row][col - 1] == WATER) perimeter += 1;
                    // check right border
                    if (col == grid[row].length - 1) perimeter += 1;
                    if (col < grid[row].length - 1 && grid[row][col + 1] == WATER) perimeter += 1;
                    // check top border
                    if (row == 0) perimeter += 1;
                    if (row > 0 && grid[row - 1][col] == WATER) perimeter += 1;
                    // check bottom border
                    if (row == grid.length - 1) perimeter += 1;
                    if (row < grid.length - 1 && grid[row + 1][col] == WATER) perimeter += 1;
                }
            }
        }

        return perimeter;
    }

    private static int[] row(int... values) {
        return values;
    }

    private static int[][] grid(int[]... rows) {
        return rows != null ? rows : new int[0][0];
    }

    private static String toString(int[][] grid) {
        return Arrays.stream(grid).map(Arrays::toString).collect(Collectors.joining(", "));
    }
}
