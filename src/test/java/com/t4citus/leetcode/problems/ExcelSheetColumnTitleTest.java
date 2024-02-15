package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "168. Excel Sheet Column Title",
        url = "https://leetcode.com/problems/excel-sheet-column-title/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ExcelSheetColumnTitleTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, "A"),
                Arguments.of(26, "Z"),
                Arguments.of(28, "AB"),
                Arguments.of(701, "ZY")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, String expectedOutput) {
        // Given

        // When
        String title = convertToTitle(input);

        // Then
        System.out.println("convertToTitle(" + input + ") = " + title);
        Assertions.assertThat(title).isEqualTo(expectedOutput);
    }

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 26) {
            return String.valueOf(ALPHABET.charAt(columnNumber - 1));
        }

        StringBuilder title = new StringBuilder();
        int i = columnNumber, rest;

        while (i > 0) {
            rest = i % 26;
            if (rest > 0) {
                title.insert(0, ALPHABET.charAt(rest - 1));
                i /= 26;
            } else {
                title.insert(0, 'Z');
                i /= 26;
                i -= 1;
            }
        }

        return title.toString();
    }
}
