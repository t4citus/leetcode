package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "412. Fizz Buzz",
        url = "https://leetcode.com/problems/fizz-buzz/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FizzBuzzTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(3, List.of("1","2","Fizz")),
                Arguments.of(5, List.of("1","2","Fizz","4","Buzz")),
                Arguments.of(15, List.of("1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, List<String> expectedOutput) {
        // Given

        // When
        List<String> answer = fizzBuzz(n);

        // Then
        System.out.println("fizzBuzz(" + n + ") = " + answer);
        Assertions.assertThat(answer).isEqualTo(expectedOutput);
    }

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            boolean divBy3 = i % 3 == 0;
            boolean divBy5 = i % 5 == 0;
            if (divBy3 && divBy5) {
                answer.add(i - 1, "FizzBuzz");
            } else if (divBy3) {
                answer.add(i - 1, "Fizz");
            } else if (divBy5) {
                answer.add(i - 1, "Buzz");
            } else {
                answer.add(i - 1, String.valueOf(i));
            }
        }
        return answer;
    }
}
