package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "541. Reverse String II",
        url = "https://leetcode.com/problems/reverse-string-ii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReverseString2Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abcdefg", 2, "bacdfeg"),
                Arguments.of("abcd", 2, "bacd"),
                Arguments.of("abcdefg", 8, "gfedcba")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int k, String expectedReversed) {
        // Given

        // When
        String reversed = reverseStr(s, k);

        // Then
        System.out.println("reverseStr(" + s + ", " + k + ") = " + reversed);
        Assertions.assertThat(reversed).isEqualTo(expectedReversed);
    }

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length - 1;
        int start = 0;
        int end = Math.min(start + k - 1, len);
        boolean swap = true;

        while (start < end && end <= len) {
            int i = start, j = end;
            if (swap) {
                while (i < j) {
                    char tmp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = tmp;
                    i++;
                    j--;
                }
            }
            swap = !swap;
            start = end + 1;
            end = Math.min(start + k - 1, len);
        }

        return String.valueOf(chars);
    }
}
