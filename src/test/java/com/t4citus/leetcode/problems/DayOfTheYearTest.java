package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Calendar;
import java.util.stream.Stream;

@Leetcode(
        title = "",
        url = "",
        difficulty = Leetcode.Difficulty.EASY
)
public class DayOfTheYearTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("2019-01-09", 9),
                Arguments.of("2019-02-10", 41)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String date, int expectedDayOfYear) {
        // Given

        // When
        int dayOfYear = dayOfYear(date);

        // Then
        System.out.println("dayOfYear(" + date + ") = " + dayOfYear);
        Assertions.assertThat(dayOfYear).isEqualTo(expectedDayOfYear);
    }

    public static int[] MONTHS = new int[] { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        char[] chars = date.toCharArray();
        int year = (chars[0] - '0') * 1000 + (chars[1] - '0') * 100 + (chars[2] - '0') * 10 + (chars[3] - '0');
        int month = (chars[5] - '0') * 10 + (chars[6] - '0');
        int day = (chars[8] - '0') * 10 + (chars[9] - '0');

        int count = 0;
        for (int i = 0; i < month; i++) {
            count += MONTHS[i];
        }
        count += day;

        if (month > 2 && isLeapYear(year)) {
            count += 1;
        }

        return count;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }
}
