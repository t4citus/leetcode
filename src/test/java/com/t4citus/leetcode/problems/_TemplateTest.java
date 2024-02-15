package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "",
        url = "",
        difficulty = Leetcode.Difficulty.EASY
)
public class _TemplateTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(),
                Arguments.of()
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected() {
        // Given

        // When

        // Then
        System.out.println("<function_name>(" + "<function_params>" + ") = " + "<function_result>");
        // Assertions go here
    }
}
