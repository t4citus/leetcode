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
        title = "557. Reverse Words in a String III",
        url = "https://leetcode.com/problems/reverse-words-in-a-string-iii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReverseWordsInString3Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Let's take LeetCode contest", "s'teL ekat edoCteeL tsetnoc"),
                Arguments.of("Mr Ding", "rM gniD")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String expectedReversed) {
        // Given

        // When
        String reversed = reverseWords(s);

        // Then
        System.out.println("reverseWords(" + s + ") = " + reversed);
        Assertions.assertThat(reversed).isEqualTo(expectedReversed);
    }

    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int lo = 0, hi = 0;

        while (lo < s.length() && hi <= s.length()) {
            if (hi == s.length()) {
                reverse(chars, lo, hi);
                break;
            }
            if (chars[hi] != ' ') {
                hi += 1;
            } else {
                reverse(chars, lo, hi);
                lo = hi + 1;
                hi = lo;
            }
        }

        return String.valueOf(chars);
    }

    public void reverse(char[] chars, int lo, int hi) {
        hi -= 1;
        while (lo < hi) {
            char tmp = chars[hi];
            chars[hi] = chars[lo];
            chars[lo] = tmp;
            lo += 1;
            hi -= 1;
        }
    }
}
