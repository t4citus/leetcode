package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@Leetcode(
        title = "119. Pascal's Triangle II",
        url = "https://leetcode.com/problems/pascals-triangle-ii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PascalTriangle2Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(3, List.of(1, 3, 3, 1)),
                Arguments.of(0, List.of(1)),
                Arguments.of(1, List.of(1, 1)),
                Arguments.of(13, List.of(1, 13, 78, 286, 715, 1287, 1716, 1716, 1287, 715, 286, 78, 13, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int rowIndex, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> row = getRow(rowIndex);

        // Then
        System.out.println("getRow(" + rowIndex + ") = " + row);
        Assertions.assertThat(row).isEqualTo(expectedOutput);
    }

    public List<Integer> getRow(int rowIndex) {
        int[][] a = new int[rowIndex + 1][rowIndex + 1];
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) a[i][j] = 1;
                else a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
            }
        }
        return Arrays.stream(a[rowIndex]).boxed().toList();
    }
}
