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
        title = "748. Shortest Completing Word",
        url = "https://leetcode.com/problems/shortest-completing-word/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ShortestCompletingWordTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}, "steps"),
                Arguments.of("1s3 456", new String[]{"looks", "pest", "stew", "show"}, "pest")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String licensePlate, String[] words, String expectedShortestWord) {
        // Given

        // When
        String shortestWord = shortestCompletingWord(licensePlate, words);

        // Then
        System.out.println("shortestCompletingWord(" + licensePlate + ", " + Arrays.toString(words) + ") = " + shortestWord);
        Assertions.assertThat(shortestWord).isEqualTo(expectedShortestWord);
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] counts = new int[26];
        String minWord = null;

        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                counts[Character.isUpperCase(ch) ? ch - 'A' : ch - 'a']++;
            }
        }

        for (String word : words) {
            int[] wordCounts = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                wordCounts[ch - 'a']++;
            }

            if (isComplete(counts, wordCounts)) {
                if (minWord == null || word.length() < minWord.length())
                    minWord = word;
            }
        }

        return minWord;
    }

    public static boolean isComplete(int[] licenceCounts, int[] wordCounts) {
        if (licenceCounts.length != wordCounts.length)
            return false;
        for (int i = 0; i < wordCounts.length; i++) {
            if (licenceCounts[i] > wordCounts[i])
                return false;
        }
        return true;
    }
}
