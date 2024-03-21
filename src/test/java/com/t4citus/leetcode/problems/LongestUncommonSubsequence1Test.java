package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "521. Longest Uncommon Subsequence I",
        url = "https://leetcode.com/problems/longest-uncommon-subsequence-i/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LongestUncommonSubsequence1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aba", "cdc", 3),
                Arguments.of("aaa", "bbb", 3),
                Arguments.of("aaa", "aaa", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String a, String b, int expectedLongest) {
        // Given

        // When
        int longest = findLUSlength(a, b);

        // Then
        System.out.println("findLUSlength(" + a + ", " + b + ") = " + longest);
        Assertions.assertThat(longest).isEqualTo(expectedLongest);
    }

    /**
     * The problem is not aiming at the comparison of the frequencies of substrings. The definition of the
     * 'longest uncommon subsequence' is, that a sequence is part of one string, but not the other. For example,
     * for the two strings s1 = "abcd", s2 = "abc" the length of the longest uncommon subsequence is 4, as "abcd"
     * is a subsequence of s1, but not s2. This is obviously true, for all strings with different sizes. If the
     * sizes are equal, the strings are either equal (that result in a '0') or not equal that results in the case
     * mentioned above.
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
