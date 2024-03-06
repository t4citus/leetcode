package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "2828. Check if a String Is an Acronym of Words",
        url = "https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class CheckIfStringIsAcronymOfWordsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of("alice","bob","charlie"), "abc", true),
                Arguments.of(List.of("an","apple"), "a", false),
                Arguments.of(List.of("never","gonna","give","up","on","you"), "ngguoy", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(List<String> words, String s, boolean expectedIsAcronym) {
        // Given

        // When
        boolean isAcronym = isAcronym(words, s);

        // Then
        System.out.println("isAcronym(" + words + ", " + s + ") = " + isAcronym);
        Assertions.assertThat(isAcronym).isEqualTo(expectedIsAcronym);
    }

    public boolean isAcronym(List<String> words, String s) {
        if (words.size() != s.length()) return false;

        // assert: words.size() == s.length()
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i))
                return false;
        }

        return true;
    }
}
