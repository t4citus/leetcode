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
        title = "268. Missing Number",
        url = "https://leetcode.com/problems/missing-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MissingNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 0, 1}, 2),
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}, 8)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int expectedOutput) {
        // Given
        String inputString = Arrays.toString(input);

        // When
        int missingNumber = missingNumber(input);

        // Then
        System.out.println("missingNumber(" + inputString + ") = " + missingNumber);
        Assertions.assertThat(missingNumber).isEqualTo(expectedOutput);
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int sum = n * (n + 1) / 2; // Gauß Formula

        for (int num : nums) {
            sum -= num;
        }

        return sum;
    }
}
