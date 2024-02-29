package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "520. Detect Capital",
        url = "https://leetcode.com/problems/detect-capital/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class DetectCapitalTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("USA", true),
                Arguments.of("FlaG", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String word, boolean expectedCapitalUse) {
        // Given

        // When
        boolean capitalUse = detectCapitalUse(word);

        // Then
        System.out.println("detectCapitalUse(" + word + ") = " + capitalUse);
        Assertions.assertThat(capitalUse).isEqualTo(expectedCapitalUse);
    }

    public boolean detectCapitalUse(String word) {
        int len = word.length();
        if (len == 0 || len == 1) return true;

        if (Character.isUpperCase(word.charAt(0))) {
            boolean lower = Character.isLowerCase(word.charAt(1));
            for (int i = 2; i < len; i++)
                if (lower != Character.isLowerCase(word.charAt(i))) return false;
        } else {
            for (int i = 1; i < len; i++) {
                if (Character.isUpperCase(word.charAt(i))) return false;
            }
        }

        return true;
    }
}
