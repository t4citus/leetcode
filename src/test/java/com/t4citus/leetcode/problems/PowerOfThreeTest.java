package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "326. Power of Three",
        url = "https://leetcode.com/problems/power-of-three/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PowerOfThreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(27, true),
                Arguments.of(0, false),
                Arguments.of(-1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, boolean expectedOutput) {
        // Given

        // When
        boolean powerOfThree = isPowerOfThree(n);

        // Then
        System.out.println("isPowerOfThree(" + n + ") = " + powerOfThree);
        Assertions.assertThat(powerOfThree).isEqualTo(expectedOutput);
    }

    public boolean isPowerOfThree(int n) {
        double d = Math.log10(n) / Math.log10(3);
        return d % 1 == 0;
    }
}
