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
        title = "66. Plus One",
        url = "https://leetcode.com/problems/plus-one/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PlusOneTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, new int[]{1, 2, 4}),
                Arguments.of(new int[]{4, 3, 2, 1}, new int[]{4, 3, 2, 2}),
                Arguments.of(new int[]{9}, new int[]{1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given

        // When
        int[] plusOne = plusOne(input);

        // Then
        System.out.println("plusOne(" + Arrays.toString(input) + ") = " + Arrays.toString(plusOne));
        Assertions.assertThat(IntUtil.equals(plusOne, expectedOutput)).isTrue();
    }

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) {
            return new int[0];
        }
        int[] sum = new int[digits.length];
        int carry = 1; // Setting carry initially to '1' represents the addition of '1' to the last position.

        for (int i = digits.length - 1; i >= 0; i--) {
            int val = digits[i] + carry;
            if (val == 10) {
                sum[i] = 0;
                carry = 1;
            } else {
                sum[i] = val;
                carry = 0;
            }
        }

        // In case the carry is '1' after processing all digits, a new array needs to be created with a leading '1'.
        if (carry == 1) {
            int[] newSum = new int[sum.length + 1];
            for (int i = 0; i < sum.length; i++) {
                newSum[i + 1] = sum[i];
            }
            newSum[0] = 1;
            sum = newSum;
        }

        return sum;
    }
}
