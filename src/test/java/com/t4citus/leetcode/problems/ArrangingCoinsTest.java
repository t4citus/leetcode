package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "441. Arranging Coins",
        url = "https://leetcode.com/problems/arranging-coins/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ArrangingCoinsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(8, 3),
                Arguments.of(1804289383, 60070)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, int expectedRows) {
        // Given

        // When
        int rows = arrangeCoins(n);

        // Then
        System.out.println("arrangeCoins(" + n + ") = " + rows);
        Assertions.assertThat(rows).isEqualTo(expectedRows);
    }

    public int arrangeCoins(int n) {
        // Casting to int is ceiling the number, so it returns the previous full row in case of decimal places.
        return (int) (0.5 * Math.sqrt(1 + 8L * (long) n) - 0.5);
    }
}
