package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Leetcode(
        title = "290. Word Pattern",
        url = "https://leetcode.com/problems/word-pattern/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class WordPatternTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abba", "dog cat cat dog", true),
                Arguments.of("abba", "dog cat cat fish", false),
                Arguments.of("aaaa", "dog cat cat dog", false),
                Arguments.of("abba", "dog dog dog dog", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String pattern, String s, boolean expectedHasMatch) {
        // Given

        // When
        boolean hasMatch = wordPattern(pattern, s);

        // Then
        System.out.println("wordPattern(" + pattern + ", " + s + ") = " + hasMatch);
        Assertions.assertThat(hasMatch).isEqualTo(expectedHasMatch);
    }

    public boolean wordPattern(String pattern, String s) {
        char[] chars = pattern.toCharArray();
        String[] words = s.split(" ");

        if (chars.length != words.length) return false;

        Map<Character, String> wordMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (!wordMap.containsKey(chars[i])) {
                if (wordMap.containsValue(words[i])) return false;
                wordMap.put(chars[i], words[i]);
            } else {
                if (!wordMap.get(chars[i]).equals(words[i])) return false;
            }

        }

        return true;
    }
}
