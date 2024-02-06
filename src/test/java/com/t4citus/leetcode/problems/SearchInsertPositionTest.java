package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SearchInsertPositionTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1,3,5,6}, 5, 2),
                Arguments.of(new int[]{1,3,5,6}, 2, 1),
                Arguments.of(new int[]{1,3,5,6}, 7, 4),
                Arguments.of(new int[]{1,3,5,6}, 1, 0),
                Arguments.of(new int[]{1,3,5,6}, 1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] numbers, int target, int expectedOutput) {
        // Given

        // When
        int pos = searchInsert(numbers, target);

        // Then
        System.out.println("The position of the inserted element " + target + " is " + pos + ".");
        Assertions.assertThat(pos).isEqualTo(expectedOutput);
    }

    public int searchInsert(int[] nums, int target) {
        if (nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length - 1] < target) {
            return nums.length;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < target && nums[i + 1] >= target) {
                return i + 1;
            }
        }
        return -1;
    }
}
