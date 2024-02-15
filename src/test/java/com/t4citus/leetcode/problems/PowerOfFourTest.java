package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "342. Power of Four",
        url = "https://leetcode.com/problems/power-of-four/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PowerOfFourTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(16, true),
                Arguments.of(5, false),
                Arguments.of(1, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, boolean expectedOutput) {
        // Given

        // When
        boolean powerOfFour = isPowerOfFour(input);

        // Then
        System.out.println("isPowerOfFour(" + input + ") = " + powerOfFour);
        Assertions.assertThat(powerOfFour).isEqualTo(expectedOutput);
    }

    public boolean isPowerOfFour(int n) {
        double d = Math.log(n) / Math.log(4);
        return d % 1 == 0;
    }
}
