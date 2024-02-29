package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "509. Fibonacci Number",
        url = "https://leetcode.com/problems/fibonacci-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FibonacciNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(int n, int expectedFibonacci) {
        // Given

        // When
        int fibonacci = fib(n);

        // Then
        System.out.println("fib(" + n + ") = " + fibonacci);
        Assertions.assertThat(fibonacci).isEqualTo(expectedFibonacci);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(int n, int expectedFibonacci) {
        // Given

        // When
        int fibonacci = fibIt(n);

        // Then
        System.out.println("fibIt(" + n + ") = " + fibonacci);
        Assertions.assertThat(fibonacci).isEqualTo(expectedFibonacci);
    }

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public int fibIt(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] numbers = new int[n + 1];
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers[n];
    }
}
