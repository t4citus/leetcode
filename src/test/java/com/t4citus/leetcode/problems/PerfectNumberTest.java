package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "507. Perfect Number",
        url = "https://leetcode.com/problems/perfect-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PerfectNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(28, true),
                Arguments.of(8, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int num, boolean expectedCheck) {
        // Given

        // When
        boolean check = checkPerfectNumber(num);

        // Then
        System.out.println("checkPerfectNumber(" + num + ") = " + check);
        Assertions.assertThat(check).isEqualTo(expectedCheck);
    }

    public boolean checkPerfectNumber(int num) {
        int sum = 0, n = num / 2;

        for (int i = 1; i <= n; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        return sum == num;
    }
}
