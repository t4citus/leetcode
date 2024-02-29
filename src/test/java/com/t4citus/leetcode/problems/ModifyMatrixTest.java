package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "",
        url = "",
        difficulty = Leetcode.Difficulty.EASY
)
public class ModifyMatrixTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        matrix(row(1, 2, -1), row(4, -1, 6), row(7, 8, 9)),
                        matrix(row(1, 2, 9), row(4, 8, 6), row(7, 8, 9))
                ),
                Arguments.of(
                        matrix(row(3, -1), row(5, 2)),
                        matrix(row(3, 2), row(5, 2))
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[][] matrix, int[][] expectedModifiedMatrix) {
        // Given
        String matrixAsString = toString(matrix);

        // When
        int[][] modifiedMatrix = modifiedMatrix(matrix);

        // Then
        System.out.println("modifiedMatrix(" + matrixAsString + ") = " + toString(modifiedMatrix));
        Assertions.assertThat(IntUtil.equals(modifiedMatrix, expectedModifiedMatrix)).isTrue();
    }

    record Point(int x, int y) {}

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[] max = new int[n];
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    points.add(new Point(i, j));
                }
                max[j] = Math.max(max[j], matrix[i][j]);
            }
        }

        for (Point p : points) {
            matrix[p.x][p.y] = max[p.y];
        }

        return matrix;
    }

    private static int[] row(int... values) {
        return values;
    }

    private static int[][] matrix(int[]... rows) {
        return rows;
    }

    private static String toString(int[][] matrix) {
        return Arrays.toString(Arrays.stream(matrix)
                .map(Arrays::toString)
                .toArray(String[]::new));
    }
}
