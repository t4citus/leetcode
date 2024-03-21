package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "551. Student Attendance Record I",
        url = "https://leetcode.com/problems/student-attendance-record-i/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class StudentAttendanceReport1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("PPALLP", true),
                Arguments.of("PPALLL", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, boolean expectedEligible) {
        // Given

        // When
        boolean eligible = checkRecord(s);

        // Then
        System.out.println("checkRecord(" + s + ") = " + eligible);
        Assertions.assertThat(eligible).isEqualTo(expectedEligible);
    }

    public boolean checkRecord(String s) {
        if (s.contains("LLL")) return false;

        boolean absent = false;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                if (!absent) absent = true;
                else return false;
            }
        }

        return true;
    }
}
