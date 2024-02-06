package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class PalindromeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, boolean expectedOutput) {
        // Given

        // When
        boolean isPalindrome = isPalindrome(input);

        // Then
        System.out.println("The input '" + input + "' is " + (isPalindrome ? "not a palindrome" : "a palindrome"));
        Assertions.assertThat(isPalindrome).isEqualTo(expectedOutput);
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x > 0 && x % 10 == 0))
            return false;

        long reversed = Long.parseLong(new StringBuilder(String.valueOf(x)).reverse().toString());
        return ((long) x) == reversed;
    }
}
