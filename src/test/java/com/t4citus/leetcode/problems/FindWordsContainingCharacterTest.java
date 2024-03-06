package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "2942. Find Words Containing Character",
        url = "https://leetcode.com/problems/find-words-containing-character/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FindWordsContainingCharacterTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[]{"leet", "code"}, 'e', List.of(0, 1)),
                Arguments.of(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a', List.of(0, 2)),
                Arguments.of(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'z', List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] words, char x, List<Integer> expectedWordsContaining) {
        // Given

        // When
        List<Integer> wordsContaining = findWordsContaining(words, x);

        // Then
        System.out.println("findWordsContaining(" + Arrays.toString(words) + ", " + x + ") = " + wordsContaining);
        Assertions.assertThat(wordsContaining).containsExactlyInAnyOrder(expectedWordsContaining.toArray(new Integer[0]));
    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> indexes = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                indexes.add(i);
            }
        }

        return indexes;
    }
}
