package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "1507. Reformat Date",
        url = "https://leetcode.com/problems/reformat-date/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReformatDateTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("20th Oct 2052", "2052-10-20"),
                Arguments.of("6th Jun 1933", "1933-06-06"),
                Arguments.of("26th May 1960", "1960-05-26")

        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String date, String expectedReformatted) {
        // Given

        // When
        String reformatted = reformatDate(date);

        // Then
        System.out.println("reformatDate(" + date + ") = " + reformatted);
        Assertions.assertThat(reformatted).isEqualTo(expectedReformatted);
    }

    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        int n = date.length();

        String day = date.substring(0, n - 11); // len(year) + whitespace + len(month) + whitespace + 'st/nd/rd/th'
        String month = date.substring(n - 8, n - 5); // len(year) + whitespace + len(month)
        String year = date.substring(n - 4);

        sb.append(year).append("-");

        switch (month) {
            case "Jan" -> sb.append("01");
            case "Feb" -> sb.append("02");
            case "Mar" -> sb.append("03");
            case "Apr" -> sb.append("04");
            case "May" -> sb.append("05");
            case "Jun" -> sb.append("06");
            case "Jul" -> sb.append("07");
            case "Aug" -> sb.append("08");
            case "Sep" -> sb.append("09");
            case "Oct" -> sb.append("10");
            case "Nov" -> sb.append("11");
            case "Dec" -> sb.append("12");
        }

        sb.append("-").append(day.length() == 1 ? "0" + day : day);
        return sb.toString();
    }
}
