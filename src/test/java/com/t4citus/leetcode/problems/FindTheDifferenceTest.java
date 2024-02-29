package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "389. Find the Difference",
        url = "https://leetcode.com/problems/find-the-difference/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FindTheDifferenceTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abcd", "abcde", 'e'),
                Arguments.of("", "y", 'y')
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String t, char expectedOutput) {
        // Given

        // When
        char difference = findTheDifference(s, t);

        // Then
        System.out.println("findTheDifference(" + s + ", " + t + ") = " + difference);
        Assertions.assertThat(difference).isEqualTo(expectedOutput);
    }

    public char findTheDifference(String s, String t) {
        int sum = 0;

        for (char c : s.toCharArray()) {
            sum += c - 'a';
        }

        System.out.println("1: " + sum);

        for (char c : t.toCharArray()) {
            sum -= c - 'a';
        }

        System.out.println("2: " + sum);

        return (char) (Math.abs(sum) + 'a');
    }
}
