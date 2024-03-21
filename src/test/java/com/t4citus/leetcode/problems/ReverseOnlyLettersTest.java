package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "917. Reverse Only Letters",
        url = "https://leetcode.com/problems/reverse-only-letters/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReverseOnlyLettersTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("ab-cd", "dc-ba"),
                Arguments.of("a-bC-dEf-ghIj", "j-Ih-gfE-dCba"),
                Arguments.of("Test1ng-Leet=code-Q!", "Qedo1ct-eeLg=ntse-T!")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String expectedReversed) {
        // Given

        // When
        String reversed = reverseOnlyLetters(s);

        // Then
        System.out.println("reverseOnlyLetters(" + s + ") = " + reversed);
        Assertions.assertThat(reversed).isEqualTo(expectedReversed);
    }

    public String reverseOnlyLetters(String s) {
        char[] chars = s.toCharArray();
        int hi = s.length() - 1;

        for (int lo = 0; lo < chars.length; lo++) {
            char ch = chars[lo];
            if (isLetter(ch)) {
                while (hi >= 0) {
                    if (isLetter(s.charAt(hi))) {
                        chars[lo] = s.charAt(hi--);
                        break;
                    }
                    hi--;
                }
            }
        }

        return String.valueOf(chars);
    }

    public static boolean isLetter(char ch) {
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z');
    }
}
