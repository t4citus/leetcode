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
        title = "485. Max Consecutive Ones",
        url = "https://leetcode.com/problems/max-consecutive-ones/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MaxConsecutiveOnesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1,1,0,1,1,1}, 3),
                Arguments.of(new int[]{1,0,1,1,0,1}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedMaxOnes) {
        // Given

        // When
        int maxOnes = findMaxConsecutiveOnes(ints);

        // Then
        System.out.println("findMaxConsecutiveOnes(" + Arrays.toString(ints) + ") = " + maxOnes);
        Assertions.assertThat(maxOnes).isEqualTo(expectedMaxOnes);
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, curr = 0;

        for (int n : nums) {
            if (n == 1) {
                curr++;
            } else {
                max = Math.max(max, curr);
                curr = 0;
            }
        }

        if (nums[nums.length - 1] == 1) {
            max = Math.max(max, curr);
        }

        return max;
    }
}
