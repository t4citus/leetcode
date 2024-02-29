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
        title = "3042. Count Prefix and Suffix Pairs I",
        url = "https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class CountPrefixAndSuffixPairs1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[]{"a", "aba", "ababa", "aa"}, 4),
                Arguments.of(new String[]{"pa", "papa", "ma", "mama"}, 2),
                Arguments.of(new String[]{"abab", "ab"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] words, int expectedPairCount) {
        // Given

        // When
        int pairCount = countPrefixSuffixPairs(words);

        // Then
        System.out.println("countPrefixSuffixPairs(" + Arrays.toString(words) + ") = " + pairCount);
        Assertions.assertThat(pairCount).isEqualTo(expectedPairCount);
    }

    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) count += 1;
            }
        }

        return count;
    }

    public boolean isPrefixAndSuffix(String prefixOrSuffix, String word) {
        return word.startsWith(prefixOrSuffix) && word.endsWith(prefixOrSuffix);
    }
}
