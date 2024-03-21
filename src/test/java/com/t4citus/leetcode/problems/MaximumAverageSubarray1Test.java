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
        title = "643. Maximum Average Subarray I",
        url = "https://leetcode.com/problems/maximum-average-subarray-i/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MaximumAverageSubarray1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75),
                Arguments.of(new int[]{5}, 1, 5.00),
                Arguments.of(new int[]{0, 1, 1, 3, 3}, 4, 2.00)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] nums, int k, double expectedMaxAverage) {
        // Given

        // When
        double maxAverage = findMaxAverage(nums, k);

        // Then
        System.out.println("findMaxAverage(" + Arrays.toString(nums) + ", " + k + ") = " + maxAverage);
        Assertions.assertThat(maxAverage).isEqualTo(expectedMaxAverage);
    }

    public double findMaxAverage(int[] nums, int k) {
        int prev = 0;
        for (int i = 0; i < k; i++) {
            prev += nums[i];
        }

        int max = prev;
        for (int i = 1; i + k - 1 < nums.length; i++) {
            prev = prev - nums[i - 1] + nums[i + k - 1];
            max = Math.max(max, prev);
        }

        return (double) max / k;
    }
}
