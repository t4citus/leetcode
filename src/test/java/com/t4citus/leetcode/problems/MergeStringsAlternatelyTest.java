package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "1768. Merge Strings Alternately",
        url = "https://leetcode.com/problems/merge-strings-alternately/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MergeStringsAlternatelyTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abc", "pqr", "apbqcr"),
                Arguments.of("ab", "pqrs", "apbqrs"),
                Arguments.of("abcd", "pq", "apbqcd")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String word1, String word2, String expectedOutput) {
        // Given

        // When
        String merged = mergeAlternately(word1, word2);

        // Then
        System.out.println("mergeAlternately(" + word1 + ", " + word2 + ") = " + expectedOutput);
        Assertions.assertThat(merged).isEqualTo(expectedOutput);
    }

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        if (len1 == 0)
            return word2;

        if (len2 == 0)
            return word1;

        int max = Math.max(len1, len2);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < max; i++) {
            if (i < len1) {
                sb.append(word1.charAt(i));
            }
            if (i < len2) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }
}
