package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "434. Number of Segments in a String",
        url = "https://leetcode.com/problems/number-of-segments-in-a-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class NumberOfSegmentsInStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Hello, my name is John", 5),
                Arguments.of("Hello", 1),
                Arguments.of("", 0),
                Arguments.of("   ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int expectedCount) {
        // Given

        // When
        int count = countSegments(s);

        // Then
        System.out.println("countSegments(" + s + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }

    /**
     * The idea is to count the switches between whitespaces and non-whitespaces. So whenever the character is a
     * non-whitespace preceded by a whitespace the count gets increased. That also means that a whitespace followed
     * by a whitespace gets ignored.
     */
    public int countSegments(String s) {
        if (s.length() == 0) return 0;

        int count = 0;
        boolean whitespace = true;

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                whitespace = true;
            } else if (whitespace) {
                count++;
                whitespace = false;
            }
        }

        return count;
    }
}
