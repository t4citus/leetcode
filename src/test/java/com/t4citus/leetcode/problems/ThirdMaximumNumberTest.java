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
        title = "414. Third Maximum Number",
        url = "https://leetcode.com/problems/third-maximum-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ThirdMaximumNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1}, 1),
                Arguments.of(new int[]{1, 2}, 2),
                Arguments.of(new int[]{2, 2, 3, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedThirdMax) {
        // Given

        // When
        int thirdMax = thirdMax(ints);

        // Then
        System.out.println("thirdMax(" + Arrays.toString(ints) + ") = " + thirdMax);
        Assertions.assertThat(thirdMax).isEqualTo(expectedThirdMax);
    }

    public int thirdMax(int[] nums) {
        long min = Long.MIN_VALUE, mid = Long.MIN_VALUE, max = Long.MIN_VALUE;

        for (int n : nums) {
            if (n == min || n == mid || n == max) {
                continue;
            }
            if (n > max) {
                min = mid;
                mid = max;
                max = n;
            } else if (n > mid) {
                min = mid;
                mid = n;
            } else if (n > min) {
                min = n;
            }
        }

        return min == Long.MIN_VALUE ? (int) max : (int) min;
    }
}
