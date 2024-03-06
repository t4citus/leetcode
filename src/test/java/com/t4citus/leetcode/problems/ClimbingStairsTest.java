package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@Leetcode(
        title = "70. Climbing Stairs",
        url = "https://leetcode.com/problems/climbing-stairs/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ClimbingStairsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(35, 14930352)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(int n, int expectedResult) {
        // Given

        // When
        int result = climbStairs(n);

        // Then
        System.out.println("climbStairs(" + n + ") = " + result);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(int n, int expectedResult) {
        // Given

        // When
        int result = climbStairsIt(n);

        // Then
        System.out.println("climbStairsIt(" + n + ") = " + result);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairsIt(int n) {
        int[] cache = new int[n + 1];
        cache[0] = 1;
        cache[1] = 1;

        for (int i = 2; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }

        return cache[n];
    }
}
