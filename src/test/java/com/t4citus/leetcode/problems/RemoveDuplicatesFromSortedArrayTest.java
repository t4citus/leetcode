package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

@Leetcode(
        title = "26. Remove Duplicates from Sorted Array",
        url = "https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RemoveDuplicatesFromSortedArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr(1, 1, 2), 2, arr(1, 2, 1000)),
                Arguments.of(arr(0, 0, 1, 1, 1, 2, 2, 3, 3, 4), 5, arr(0, 1, 2, 3, 4, 1000, 1000, 1000, 1000, 1000)),
                Arguments.of(arr(1, 1), 1, arr(1, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int n, int[] expectedOutput) {
        // Given
        int[] inputCopy = Arrays.copyOf(input, input.length);

        // When
        int pos = removeDuplicates(input);

        // Then
        System.out.println("removeDuplicates(" + Arrays.toString(inputCopy) + ", " + n + ") = (" + pos + ", " + Arrays.toString(input) + ")");
        Assertions.assertThat(pos).isEqualTo(n);
        Assertions.assertThat(equals(input, expectedOutput, pos)).isTrue();
    }

    public int removeDuplicates(int[] nums) {
        int ptr = 1; // insert pointer
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[ptr] = nums[i];
                ptr++;
            }
        }
        return ptr;
    }

    public static int[] arr(int... values) {
        return values == null ? new int[]{} : values;
    }

    public static boolean equals(int[] left, int[] right, int n) {
        if (left.length != right.length) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }
}
