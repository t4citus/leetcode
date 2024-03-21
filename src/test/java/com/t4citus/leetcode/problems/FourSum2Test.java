package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Leetcode(
        title = "454. 4Sum II",
        url = "https://leetcode.com/problems/4sum-ii/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class FourSum2Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}, 2),
                Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}, new int[]{0}, 1),
                Arguments.of(new int[]{-1, -1}, new int[]{-1, 1}, new int[]{-1, 1}, new int[]{1, -1}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] nums1, int[] nums2, int[] nums3, int[] nums4, int expectedSumCount) {
        // Given

        // When
        int sumCount = fourSumCount(nums1, nums2, nums3, nums4);

        // Then
        System.out.println("fourSumCount(" + Arrays.toString(nums1) + ", " + Arrays.toString(nums2) + ", " + Arrays.toString(nums3) + ", " + Arrays.toString(nums4) + ") = " + sumCount);
        Assertions.assertThat(sumCount).isEqualTo(expectedSumCount);
    }

    public int fourSumCountBruteForce(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;

        for (int i : nums1)
            for (int j : nums2)
                for (int k : nums3)
                    for (int l : nums4)
                        if (i + j + k + l == 0) count++;

        return count;
    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        Map<Integer, Integer> sums = new HashMap<>();

        for (int i : nums1) {
            for (int j : nums2) {
                sums.put(i + j, sums.getOrDefault(i + j, 0) + 1);
            }
        }

        for (int k : nums3) {
            for (int l : nums4) {
                count += sums.getOrDefault(-1 * (k + l), 0);
            }
        }

        return count;
    }
}
