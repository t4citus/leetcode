package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "171. Excel Sheet Column Number",
        url = "https://leetcode.com/problems/excel-sheet-column-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ExcelSheetColumnNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("A", 1),
                Arguments.of("AB", 28),
                Arguments.of("ZY", 701),
                Arguments.of("AA", 27),
                Arguments.of("AB", 28)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String title, int expectedNumber) {
        // Given

        // When
        int number = titleToNumber(title);

        // Then
        System.out.println("titleToNumber(" + title + ") = " + expectedNumber);
        Assertions.assertThat(number).isEqualTo(expectedNumber);
    }

    public int titleToNumber(String columnTitle) {
        int num = 0;
        int mult = 1;

        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            int charVal = columnTitle.charAt(i) - 'A' + 1;
            num += charVal * mult;
            mult *= 26;
        }

        return num;
    }
}
