package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "709. To Lower Case",
        url = "https://leetcode.com/problems/to-lower-case/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ToLowerCaseTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Hello", "hello"),
                Arguments.of("here", "here"),
                Arguments.of("LOVELY", "lovely")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String expectedLowerCase) {
        // Given

        // When
        String lowerCase = toLowerCase(s);

        // Then
        System.out.println("toLowerCase(" + s + ") = " + lowerCase);
        Assertions.assertThat(lowerCase).isEqualTo(expectedLowerCase);
    }

    public String toLowerCase(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }

        return String.valueOf(chars);
    }
}
