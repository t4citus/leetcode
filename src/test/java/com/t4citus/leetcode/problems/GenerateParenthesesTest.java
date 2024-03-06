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
        title = "22. Generate Parentheses",
        url = "https://leetcode.com/problems/generate-parentheses/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class GenerateParenthesesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(3, List.of("((()))", "(()())", "(())()", "()(())", "()()()")),
                Arguments.of(1, List.of("()"))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, List<String> expectedParenthesis) {
        // Given

        // When
        List<String> parenthesis = generateParenthesis(n);

        // Then
        System.out.println("generateParenthesis(" + n + ") = " + parenthesis);
        Assertions.assertThat(parenthesis).containsExactlyInAnyOrder(expectedParenthesis.toArray(String[]::new));
    }

    public List<String> generateParenthesis(int n) {
        List<String> total = new ArrayList<>();
        addParenthesis(total, "", 0, 0, n);
        return total;
    }

    /**
     * The recursive function creates a binary decision tree. Every node evaluates if an opening and/or closing
     * bracket can be added (see conditions explained below).
     */
    private void addParenthesis(List<String> total, String curr, int opened, int closed, final int n) {
        if (curr.length() == 2 * n) {
            total.add(curr);
            return;
        }

        // Add open bracket (if the maximum of n is not exceeded yet).
        if (opened < n) {
            addParenthesis(total, curr + "(", opened + 1, closed, n);
        }

        // Add close bracket (if enough brackets have been opened)
        if (closed < opened) {
            addParenthesis(total, curr + ")", opened, closed + 1, n);
        }
    }
}
