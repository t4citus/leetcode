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
        title = "628. Maximum Product of Three Numbers",
        url = "https://leetcode.com/problems/maximum-product-of-three-numbers/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MaximumProductOfThreeNumbersTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{1, 2, 3, 4}, 24),
                Arguments.of(new int[]{-1, -2, -3}, -6),
                Arguments.of(new int[]{-100, -98, -1, 2, 3, 4}, 39200)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] nums, int expectedMaximumProduct) {
        // Given
        String numsString = Arrays.toString(nums);

        // When
        int maximumProduct = maximumProduct(nums);

        // Then
        System.out.println("maximumProduct(" + numsString + ") = " + maximumProduct);
        Assertions.assertThat(maximumProduct).isEqualTo(expectedMaximumProduct);
    }

    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE; // max1 > max2 > max3
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE; // min1 < min2

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }

        int left = (min1 < 0 && min2 < 0 ? min1 * min2 * max1 : 0);
        int right = max1 * max2 * max3;

        return Math.max(left, right);
    }
}
