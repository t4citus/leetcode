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
        title = "1. Two Sum",
        url = "https://leetcode.com/problems/two-sum/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class TwoSumTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3,2,4}, 6, new int[]{1,2}),
                Arguments.of(new int[]{3,3}, 6, new int[]{0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int target, int[] expectedOutput) {
        // Given

        // When
        int[] result = twoSumWithMap(input, target);

        // Then
        System.out.println("twoSum(" + Arrays.toString(input) + ", " + target + ") = " + Arrays.toString(expectedOutput));
        Assertions.assertThat(IntUtil.equals(result, expectedOutput)).isTrue();
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    public int[] twoSumWithMap(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (cache.containsKey(diff)) {
                return new int[]{cache.get(diff), i};
            }
            cache.put(nums[i], i);
        }
        return new int[]{};
    }


}
