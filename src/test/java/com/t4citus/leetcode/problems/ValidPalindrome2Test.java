package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "680. Valid Palindrome II",
        url = "https://leetcode.com/problems/valid-palindrome-ii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ValidPalindrome2Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aba", true),
                Arguments.of("abca", true),
                Arguments.of("abc", false),
                Arguments.of("cupuufxoohdhooxfuupucu", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, boolean expectedValid) {
        // Given

        // When
        boolean valid = validPalindrome(s);

        // Then
        System.out.println("validPalindrome(" + s + ") = " + valid);
        Assertions.assertThat(valid).isEqualTo(expectedValid);
    }

    public boolean validPalindrome(String s) {
        return isPalindrome(s, 0, s.length() - 1, true);
    }

    public boolean isPalindrome(String s, int lo, int hi, boolean canSkip) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                if (!canSkip) return false;

                if (s.charAt(lo + 1) == s.charAt(hi) && isPalindrome(s, lo + 1, hi, false)) {
                    return true;
                }

                return s.charAt(lo) == s.charAt(hi - 1) && isPalindrome(s, lo, hi - 1, false);
            }
            lo++;
            hi--;
        }
        return true;
    }
}
