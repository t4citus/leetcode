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
        title = "283. Move Zeroes",
        url = "https://leetcode.com/problems/move-zeroes/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MoveZerosTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 3, 12}, new int[]{1, 3, 12, 0, 0}),
                Arguments.of(new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{0, 0, 1}, new int[]{1, 0, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given

        // When
        int[] initial = Arrays.copyOf(input, input.length);
        moveZeroes(input);

        // Then
        System.out.println("moveZeroes(" + Arrays.toString(initial) + ") = " + Arrays.toString(input));
        Assertions.assertThat(equals(input, expectedOutput)).isTrue();
    }

    public void moveZeroes(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                pos++;
            }
        }
        while (pos < nums.length) {
            nums[pos] = 0;
            pos++;
        }
    }
}
