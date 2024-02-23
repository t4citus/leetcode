package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "125. Valid Palindrome",
        url = "https://leetcode.com/problems/valid-palindrome/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ValidPalindromeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of(" ", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String input, boolean expectedOutput) {
        // Given

        // When
        boolean isPalindrome = isPalindrome(input);

        // Then
        System.out.println("isPalindrome(" + input + ") = " + isPalindrome);
        Assertions.assertThat(isPalindrome).isEqualTo(expectedOutput);
    }

    public boolean isPalindrome(String s) {
        if (s == null) return false;

        String parsed = s.toLowerCase().replaceAll("[^a-z0-9]+", "");
        if (parsed.isEmpty()) return true;

        char[] chars = parsed.toCharArray();
        int l = 0, r = chars.length - 1;

        while (l <= r) {
            if (chars[l++] != chars[r--]) return false;
        }

        return true;
    }
}
