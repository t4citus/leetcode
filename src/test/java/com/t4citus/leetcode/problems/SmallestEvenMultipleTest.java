package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SmallestEvenMultipleTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(5, 10),
                Arguments.of(6, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, int expectedOutput) {
        // Given

        // When
        int multiple = smallestEvenMultiple(input);

        // Then
        System.out.println("smallestEvenMultiple(" + input + ") = " + multiple);
        Assertions.assertThat(multiple).isEqualTo(expectedOutput);
    }

    /**
     * Note that this solution only works due to the problem constraints for n: 1 <= n <= 150
     */
    public int smallestEvenMultiple(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 2;

        int lcm = n;
        while (lcm % 2 != 0) {
            lcm += n;
        }

        return lcm;
    }
}
