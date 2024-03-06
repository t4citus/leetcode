package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "2810. Faulty Keyboard",
        url = "https://leetcode.com/problems/faulty-keyboard/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FaultyKeyboardTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("string", "rtsng"),
                Arguments.of("poiinter", "ponter")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String expectedFinalString) {
        // Given

        // When
        String finalString = finalString(s);

        // Then
        System.out.println("finalString(" + s + ") = " + finalString);
        Assertions.assertThat(finalString).isEqualTo(expectedFinalString);
    }

    public String finalString(String s) {
        if (s.indexOf('i') == -1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == 'i') {
                sb.reverse();
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
