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
        title = "2678. Number of Senior Citizens",
        url = "https://leetcode.com/problems/number-of-senior-citizens/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class NumberOfSeniorCitizensTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[]{"7868190130M7522","5303914400F9211","9273338290F4010"}, 2),
                Arguments.of(new String[]{"1313579440F2036","2921522980M5644"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] details, int expectedSeniorCount) {
        // Given

        // When
        int seniorCount = countSeniors(details);

        // Then
        System.out.println("countSeniors(" + Arrays.toString(details) + ") = " + expectedSeniorCount);
        Assertions.assertThat(seniorCount).isEqualTo(expectedSeniorCount);
    }

    public int countSeniors(String[] details) {
        int count = 0;

        for (String det : details) {
            int age = (det.charAt(11) - '0') * 10 + (det.charAt(12) - '0');
            if (age > 60) count += 1;
        }

        return count;
    }
}
