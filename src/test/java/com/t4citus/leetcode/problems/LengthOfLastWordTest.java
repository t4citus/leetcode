package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "58. Length of Last Word",
        url = "https://leetcode.com/problems/length-of-last-word/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LengthOfLastWordTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String input, int expectedOutput) {
        // Given

        // When
        int length = lengthOfLastWord(input);

        // Then
        System.out.println("The length of the last word of '" + input + "' is " + length + ".");
        Assertions.assertThat(length).isEqualTo(expectedOutput);
    }

    public int lengthOfLastWord(String s) {
        int index = s.trim().lastIndexOf(' ');
        return s.trim().substring(index + 1).length();
    }
}
