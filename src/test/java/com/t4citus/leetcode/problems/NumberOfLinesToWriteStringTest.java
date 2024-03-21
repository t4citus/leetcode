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
        title = "806. Number of Lines To Write String",
        url = "https://leetcode.com/problems/number-of-lines-to-write-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class NumberOfLinesToWriteStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                        "abcdefghijklmnopqrstuvwxyz",
                        new int[]{3, 60}
                ),
                Arguments.of(
                        new int[]{4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10},
                        "bbbcccdddaaa",
                        new int[]{2, 4}
                ),
                Arguments.of(
                        new int[]{3, 4, 10, 4, 8, 7, 3, 3, 4, 9, 8, 2, 9, 6, 2, 8, 4, 9, 9, 10, 2, 4, 9, 10, 8, 2},
                        "mqblbtpvicqhbrejb",
                        new int[]{1, 100}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] widths, String s, int[] expectedNumberOfLines) {
        // Given

        // When
        int[] numberOfLines = numberOfLines(widths, s);

        // Then
        System.out.println("numberOfLines(" + Arrays.toString(widths) + ", " + s + ") = " + Arrays.toString(numberOfLines));
        Assertions.assertThat(numberOfLines).isEqualTo(expectedNumberOfLines);
    }

    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int pixels = 0;

        for (int i = 0; i < s.length(); i++) {
            int w = widths[s.charAt(i) - 'a'];

            if (pixels + w > 100) {
                lines += 1;
                pixels = w;
            } else {
                pixels += w;
            }
        }

        if (pixels == 0) {
            lines -= 1;
        }

        return new int[]{lines, pixels};
    }
}
