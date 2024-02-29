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
        title = "459. Repeated Substring Pattern",
        url = "https://leetcode.com/problems/repeated-substring-pattern/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RepeatedSubstringPatternTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abab", true),
                Arguments.of("aba", false),
                Arguments.of("abcabcabcabc", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, boolean expectedOutput) {
        // Given

        // When
        boolean repeated = repeatedSubstringPattern(s);

        // Then
        System.out.println("repeatedSubstringPattern(" + s + ") = " + repeated);
        Assertions.assertThat(repeated).isEqualTo(expectedOutput);
    }

    public boolean repeatedSubstringPattern(String s) {
        // Learn LPS Arrays and KMP Algorithm
        // https://leetcode.com/problems/repeated-substring-pattern/solutions/3944475/java-solution-with-intuition-using-kmp-beats-95
        if (s.length() == 1) return false;

        int len = s.length();
        int halfLen  = len / 2;

        for (int i = 1; i <= halfLen; i++) {
            if (len % i == 0) {
                String pattern = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                while (sb.length() < len) {
                    sb.append(pattern);
                }
                if (sb.toString().equals(s)) return true;
            }
        }

        return false;
    }
}
