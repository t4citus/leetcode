package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "367. Valid Perfect Square",
        url = "https://leetcode.com/problems/valid-perfect-square/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ValidPerfectSquareTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(16, true),
                Arguments.of(14, false),
                Arguments.of(1, true),
                Arguments.of(9, true),
                Arguments.of(2147483647, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int num, boolean expectedOutput) {
        // Given

        // When
        boolean perfectSquare = isPerfectSquare(num);

        // Then
        System.out.println("isPerfectSquare(" + num + ") = " + perfectSquare);
        Assertions.assertThat(perfectSquare).isEqualTo(expectedOutput);
    }

    public boolean isPerfectSquare(int num) {
        long low = 0;
        long high = num;

        while (low <= high) {
            long mid = (low + high) / 2;
            long sq = mid * mid;
            if (sq == num) {
                return true;
            }
            if (sq < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
