package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@Leetcode(
        title = "2716. Minimize String Length",
        url = "https://leetcode.com/problems/minimize-string-length/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MinimizeStringLengthTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aaabc", 3),
                Arguments.of("cbbd", 3),
                Arguments.of("dddaaa", 2),
                Arguments.of("bb", 1),
                Arguments.of("ecc", 2),
                Arguments.of("cauc", 3),
                Arguments.of("kkkkqdxre", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int expectedMinStringLength) {
        // Given

        // When
        int minStringLength = minimizedStringLength(s);

        // Then
        System.out.println("minimizedStringLength(" + s + ") = " + minStringLength);
        Assertions.assertThat(minStringLength).isEqualTo(expectedMinStringLength);
    }

    public int minimizedStringLength(String s) {
        int[] flags = new int[26];
        int count = 0;

        for (char ch : s.toCharArray()) {
            if (flags[ch - 'a'] == 0) {
                flags[ch - 'a']++;
                count += 1;
            }
        }
git git
        return count;
    }
}
