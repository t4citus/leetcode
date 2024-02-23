package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "231. Power of Two",
        url = "https://leetcode.com/problems/power-of-two/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PowerOfTwoTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, true),
                Arguments.of(16, true),
                Arguments.of(3, false),
                Arguments.of(536870912, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, boolean expectedOutput) {
        // Given

        // When
        boolean powerOfTwo = isPowerOfTwo(n);

        // Then
        System.out.println("isPowerOfTwo(" + n + ") = " + powerOfTwo);
        Assertions.assertThat(powerOfTwo).isEqualTo(expectedOutput);
    }

    public boolean isPowerOfTwo(int n) {
        double d = Math.log10(n) / Math.log10(2);
        return d % 1 == 0;
    }
}
