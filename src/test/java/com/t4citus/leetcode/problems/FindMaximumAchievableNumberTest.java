package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "2769. Find the Maximum Achievable Number",
        url = "https://leetcode.com/problems/find-the-maximum-achievable-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FindMaximumAchievableNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(4, 1, 6),
                Arguments.of(3, 2, 7)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int num, int times, int expectedOutput) {
        // Given

        // When
        int max = theMaximumAchievableX(num, times);

        // Then
        System.out.println("theMaximumAchievableX(" + num + ", " + times + ") = " + expectedOutput);
        Assertions.assertThat(max).isEqualTo(expectedOutput);
    }

    public int theMaximumAchievableX(int num, int t) {
        return Math.max(num - 2 * t, num + 2 * t);
    }
}
