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
        title = "3028. Ant on the Boundary",
        url = "https://leetcode.com/problems/ant-on-the-boundary/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class AntOnTheBoundaryTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, -5}, 1),
                Arguments.of(new int[]{3, 2, -3, -4}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedBoundaryCount) {
        // Given

        // When
        int boundaryCount = returnToBoundaryCount(ints);

        // Then
        System.out.println("returnToBoundaryCount(" + Arrays.toString(ints) + ") = " + boundaryCount);
        Assertions.assertThat(boundaryCount).isEqualTo(expectedBoundaryCount);
    }

    public int returnToBoundaryCount(int[] nums) {
        int count = 0, pos = 0;
        for (int n : nums) {
            pos += n;
            if (pos == 0) {
                count++;
            }
        }
        return count;
    }
}
