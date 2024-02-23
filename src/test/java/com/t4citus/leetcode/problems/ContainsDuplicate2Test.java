package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Leetcode(
        title = "219. Contains Duplicate II",
        url = "https://leetcode.com/problems/contains-duplicate-ii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ContainsDuplicate2Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 1}, 3, true),
                Arguments.of(new int[]{1, 0, 1, 1}, 1, true),
                Arguments.of(new int[]{1, 2, 3, 1, 2, 3}, 2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int k, boolean expectedOutput) {
        // Given

        // When
        boolean contains = containsNearbyDuplicate(input, k);

        // Then
        System.out.println("containsNearbyDuplicate(" + Arrays.toString(input) + ", " + k + ") = " + contains);
        Assertions.assertThat(contains).isEqualTo(expectedOutput);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        Set<Integer> inRange = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (inRange.contains(nums[i])) {
                return true;
            }

            inRange.add(nums[i]);

            // Preserve only the numbers that are in range of k.
            if (inRange.size() > k) {
                inRange.remove(nums[i - k]);
            }
        }

        return false;
    }
}
