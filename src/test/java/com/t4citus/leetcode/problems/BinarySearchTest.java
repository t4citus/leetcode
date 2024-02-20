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
        title = "704. Binary Search",
        url = "https://leetcode.com/problems/binary-search/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BinarySearchTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr(-1, 0, 3, 5, 9, 12), 9, 4),
                Arguments.of(arr(-1, 0, 3, 5, 9, 12), 2, -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int target, int expectedOutput) {
        // Given

        // When
        int index = search(input, target);

        // Then
        System.out.println("search(" + Arrays.toString(input) + ", " + target + ") = " + index);
        Assertions.assertThat(index).isEqualTo(expectedOutput);
    }

    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0] == target ? 0 : -1;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) low = mid + 1;
            if (nums[mid] > target) high = mid - 1;
        }

        return -1;
    }

    public static int[] arr(int... values) {
        return values == null ? new int[]{} : values;
    }
}
