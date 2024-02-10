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
        title = "1920. Build Array from Permutation",
        url = "https://leetcode.com/problems/build-array-from-permutation/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BuildArrayFromPermutationTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 2, 1, 5, 3, 4}, new int[]{0, 1, 2, 4, 5, 3}),
                Arguments.of(new int[]{5, 0, 1, 2, 3, 4}, new int[]{4, 5, 0, 1, 2, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given

        // When
        int[] arr = buildArray(input);

        // Then
        System.out.println("buildArray(" + Arrays.toString(input) + ") = " + Arrays.toString(expectedOutput));
        Assertions.assertThat(equals(arr, expectedOutput)).isTrue();
    }

    public int[] buildArray(int[] nums) {
        if (nums.length == 0)
            return new int[0];

        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = nums[nums[i]];
        }

        return arr;
    }
}
