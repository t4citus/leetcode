package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "977. Squares of a Sorted Array",
        url = "https://leetcode.com/problems/squares-of-a-sorted-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SquaresOfSortedArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{-4, -1, 0, 3, 10}, new int[]{0, 1, 9, 16, 100}),
                Arguments.of(new int[]{-7, -3, 2, 3, 11}, new int[]{4, 9, 9, 49, 121}),
                Arguments.of(new int[]{-5, -3, -2, -1}, new int[]{1, 4, 9, 25})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int[] expectedSortedSquares) {
        // Given
        String intsAsString = Arrays.toString(ints);

        // When
        int[] sortedSquares = sortedSquares(ints);

        // Then
        System.out.println("sortedSquares(" + intsAsString + ") = " + Arrays.toString(sortedSquares));
        Assertions.assertThat(sortedSquares).isEqualTo(expectedSortedSquares);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionWithIntStream_thenReturnsAsExpected(int[] ints, int[] expectedSortedSquares) {
        // Given

        // When
        int[] sortedSquares = sortedSquaresStream(ints);

        // Then
        System.out.println("sortedSquaresStream(" + Arrays.toString(ints) + ") = " + Arrays.toString(sortedSquares));
        Assertions.assertThat(sortedSquares).isEqualTo(expectedSortedSquares);
    }

    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        int[] merged = new int[nums.length];
        int lo = 0, hi = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[lo] >= nums[hi]) {
                merged[i] = nums[lo++];
            } else {
                merged[i] = nums[hi--];
            }
        }

        return merged;
    }

    public int[] sortedSquaresStream(int[] nums) {
        return Arrays.stream(nums).map(i -> i * i).sorted().toArray();
    }

    @Test
    public void testSort() {
        // int[] unsorted = new int[]{25, 9, 4, 1};
        int[] unsorted = new int[]{16, 1, 0, 9, 100};
        int l = 0, r = unsorted.length - 1;

        while (l < r) {
            if (unsorted[l] <= unsorted[r]) {
                r--;
            } else {
                int tmp = unsorted[l];
                unsorted[l] = unsorted[r];
                unsorted[r] = tmp;
                l++;
            }
        }

        System.out.println(Arrays.toString(unsorted));
    }
}
