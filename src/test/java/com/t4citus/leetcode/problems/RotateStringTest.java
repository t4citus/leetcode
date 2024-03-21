package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "796. Rotate String",
        url = "https://leetcode.com/problems/rotate-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RotateStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abcde", "cdeab", true),
                Arguments.of("abcde", "abced", false),
                Arguments.of("bbbacddceeb", "ceebbbbacdd", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String goal, boolean expectedRotatable) {
        // Given

        // When
        boolean rotatable = rotateString(s, goal);

        // Then
        System.out.println("rotateString(" + s + ", " + goal + ") = " + rotatable);
        Assertions.assertThat(rotatable).isEqualTo(expectedRotatable);
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;
        return (goal + goal).contains(s);
    }
}
