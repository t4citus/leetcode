package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "263. Ugly Number",
        url = "https://leetcode.com/problems/ugly-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class UglyNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(6, true),
                Arguments.of(1, true),
                Arguments.of(14, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, boolean expectedOutput) {
        // Given

        // When
        boolean ugly = isUgly(n);

        // Then
        System.out.println("isUgly(" + n + ") = " + ugly);
        Assertions.assertThat(ugly).isEqualTo(expectedOutput);
    }

    public boolean isUgly(int n) {
        if (n == 0) return false;

        int[] primes = { 2, 3, 5 };
        for (int p : primes) {
            // divide until it's no longer possible
            while (n % p == 0) {
                n /= p;
            }
        }

        return n == 1;
    }
}
