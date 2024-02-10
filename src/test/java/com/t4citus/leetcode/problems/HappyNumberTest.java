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
        title = "202. Happy Number",
        url = "https://leetcode.com/problems/happy-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class HappyNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(19, true),
                Arguments.of(2, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, boolean expectedOutput) {
        // Given

        // When
        boolean isHappy = isHappy(input);

        // Then
        System.out.println("isHappy(" + input + ") = " + isHappy + " (expected: " + expectedOutput + ")");
    }

    /*
        Example:
        input: 19
        1^2 + 9^2 = 82
        8^2 + 2^2 = 68
        6^2 + 8^2 = 100
        1^2 + 0^2 + 0^2 = 1
         */
    public boolean isHappy(int n) {
        int sum, rest, loop = 0;
        while (loop < 100) {
            sum = 0;
            while (n > 0) {
                rest = n % 10;
                n /= 10;
                sum += rest * rest;
            }
            if (sum == 1)
                return true;

            n = sum;
            loop++;
        }

        return false;
    }
}
