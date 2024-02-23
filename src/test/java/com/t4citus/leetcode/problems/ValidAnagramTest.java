package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "242. Valid Anagram",
        url = "https://leetcode.com/problems/valid-anagram/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ValidAnagramTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String t, boolean expectedOutput) {
        // Given

        // When
        boolean anagram = isAnagram(s, t);

        // Then
        System.out.println("isAnagram(" + s + ", " + t + ") = " + anagram);
        Assertions.assertThat(anagram).isEqualTo(expectedOutput);
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        for (int c : counts) {
            if (c != 0) {
                return false;
            }
        }

        return true;
    }
}
