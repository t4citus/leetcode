package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "258. Add Digits",
        url = "https://leetcode.com/problems/add-digits/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class AddDigitsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(38, 2),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(int number, int expectedOutput) {
        // Given

        // When
        int result = addDigits(number);

        // Then
        System.out.println("addDigits(" + number + ") = " + result);
        Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(int number, int expectedOutput) {
        // Given

        // When
        int result = addDigitsIt(number);

        // Then
        System.out.println("addDigits(" + number + ") = " + result);
        Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num < 10) return num;

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }

        return addDigits(sum);
    }

    public int addDigitsIt(int num) {
        if (num == 0) return 0;
        if (num < 10) return num;

        int n = num;
        int sum = 0;
        while (n >= 10) {
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            n = sum;
            sum = 0;
        }
        return n;
    }
}
