package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "69. Sqrt(x)",
        url = "https://leetcode.com/problems/sqrtx/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SqrtxTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(4, 2),
                Arguments.of(8, 2),
                Arguments.of(2147395599, 46339)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, int expectedOutput) {
        // Given

        // When
        int sqrt = mySqrt(input);

        // Then
        System.out.println("The nearest sqrt integer of " + input + " is " + sqrt + ".");
        Assertions.assertThat(sqrt).isEqualTo(expectedOutput);
    }

    public int mySqrt(int x) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;

        int left = 0;
        int right = x;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            long pow = (long) middle * (long) middle;
            if (pow == x) {
                return middle;
            }
            if (pow > x) {
                right = middle;
            }
            if (pow < x) {
                left = middle;
            }
        }
        return left;
    }
}
