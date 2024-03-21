package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "859. Buddy Strings",
        url = "https://leetcode.com/problems/buddy-strings/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BuddyStringsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("ab", "ba", true),
                Arguments.of("ab", "ab", false),
                Arguments.of("aa", "aa", true),
                Arguments.of("abcaa", "abcbb", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String goal, boolean expectedBuddyStrings) {
        // Given

        // When
        boolean buddyStrings = buddyStrings(s, goal);

        // Then
        System.out.println("buddyStrings(" + s + ", " + goal + ") = " + buddyStrings);
        Assertions.assertThat(buddyStrings).isEqualTo(expectedBuddyStrings);
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                counts[ch - 'a']++;
                if (counts[ch - 'a'] >= 2) {
                    return true;
                }
            }
        }

        int swapCount = 0;
        char[] from = new char[2];
        char[] to = new char[2];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (swapCount >= 2) return false;
                from[swapCount] = s.charAt(i);
                to[swapCount] = goal.charAt(i);
                swapCount++;
            }
        }

        return (swapCount == 2 && from[0] == to[1] && from[1] == to[0]);
    }
}
