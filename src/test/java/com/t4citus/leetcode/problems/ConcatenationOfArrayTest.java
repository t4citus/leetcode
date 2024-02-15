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
        title = "1929. Concatenation of Array",
        url = "https://leetcode.com/problems/concatenation-of-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ConcatenationOfArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1}, new int[]{1, 2, 1, 1, 2, 1}),
                Arguments.of(new int[]{1, 3, 2, 1}, new int[]{1, 3, 2, 1, 1, 3, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given

        // When
        int[] concat = getConcatenation(input);

        // Then
        System.out.println("getConcatenation(" + Arrays.toString(input) + ") = " + Arrays.toString(expectedOutput));
        Assertions.assertThat(IntUtil.equals(concat, expectedOutput)).isTrue();
    }

    public int[] getConcatenation(int[] nums) {
        if (nums.length == 0)
            return new int[0];

        int len = nums.length;
        int[] arr = new int[2 * len];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[i];
            arr[i + len] = nums[i];
        }

        return arr;
    }
}
