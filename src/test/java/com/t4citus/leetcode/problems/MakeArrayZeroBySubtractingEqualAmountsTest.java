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
        title = "2357. Make Array Zero by Subtracting Equal Amounts",
        url = "https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MakeArrayZeroBySubtractingEqualAmountsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 0, 3, 5}, 3),
                Arguments.of(new int[]{0}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int expectedOutput) {
        // Given

        // When
        int[] copy = Arrays.copyOf(input, 0);
        int min = minimumOperations(input);

        // Then
        System.out.println("minimumOperations(" + Arrays.toString(copy) + ") = " + expectedOutput);
        Assertions.assertThat(min).isEqualTo(expectedOutput);
    }

    public int minimumOperations(int[] nums) {
        int times = 0;
        boolean allZero;
        while (true) {
            // Check
            allZero = true;
            for (int num : nums) {
                if (num != 0) {
                    allZero = false;
                    break;
                }
            }
            if (allZero)
                break;

            int min = min(nums);
            // Subtract
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[i] -= min;
                }
            }
            times++;
        }

        return times;
    }

    public int min(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0 && (min == 0 || nums[i] < min)) {
                min = nums[i];
            }
        }
        return min;
    }
}
