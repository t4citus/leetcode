package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "392. Is Subsequence",
        url = "https://leetcode.com/problems/is-subsequence/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class IsSubsequenceTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("", "ahbgdc", true),
                Arguments.of("abc", "", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String t, boolean expectedOutput) {
        // Given

        // When
        boolean subsequence = isSubsequence(s, t);

        // Then
        System.out.println("isSubsequence(" + s + ", " + t + ") = " + subsequence);
        Assertions.assertThat(subsequence).isEqualTo(expectedOutput);
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) return true;
        if (t.isEmpty()) return false;

        char[] chars = s.toCharArray();
        int i = 0;

        for (char ch : t.toCharArray()) {
            if (chars[i] == ch) {
                if (++i == chars.length) return true;
            }
        }

        return false;
    }
}
