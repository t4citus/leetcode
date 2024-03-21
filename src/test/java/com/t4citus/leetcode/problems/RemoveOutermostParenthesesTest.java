package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "1021. Remove Outermost Parentheses",
        url = "https://leetcode.com/problems/remove-outermost-parentheses/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RemoveOutermostParenthesesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("(()())(())", "()()()"),
                Arguments.of("(()())(())(()(()))", "()()()()(())"),
                Arguments.of("()()", "")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String expectedRemoved) {
        // Given

        // When
        String removed = removeOuterParentheses(s);

        // Then
        System.out.println("removeOuterParentheses(" + s + ") = " + removed);
        Assertions.assertThat(removed).isEqualTo(expectedRemoved);
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0; // count opening and closing brackets

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (openCount > 0) sb.append(ch);
                openCount++;
            }

            if (ch == ')') {
                if (openCount > 1) sb.append(ch);
                openCount--;
            }
        }

        return sb.toString();
    }
}
