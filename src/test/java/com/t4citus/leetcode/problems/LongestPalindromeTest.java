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
        title = "409. Longest Palindrome",
        url = "https://leetcode.com/problems/longest-palindrome/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LongestPalindromeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abccccdd", 7),
                Arguments.of("a", 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int expectedLength) {
        // Given

        // When
        int length = longestPalindrome(s);

        // Then
        System.out.println("longestPalindrome(" + s + ") = " + length);
        Assertions.assertThat(length).isEqualTo(expectedLength);
    }

    public int longestPalindrome(String s) {
        int[] counts = new int[26 * 2]; // lower + upper

        for (char ch : s.toCharArray()) {
            if (Character.isLowerCase(ch))
                counts[ch - 'a']++;
            else
                counts[ch - 'A' + 26]++;
        }

        int even = 0, odd = 0;
        for (int c : counts) {
            if (c % 2 == 0) {
                even += c / 2;
            } else {
                odd += 1;
                even += (c - 1) / 2;
            }
        }

        System.out.println(Arrays.toString(counts));
        System.out.println("even=" + even + ", odd=" + odd);

        return 2 * even + (odd > 0 ? 1 : 0);
    }
}
