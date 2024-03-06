package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "2710. Remove Trailing Zeros From a String",
        url = "https://leetcode.com/problems/remove-trailing-zeros-from-a-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RemoveTrailingZeroesFromStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("51230100", "512301"),
                Arguments.of("123", "123")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String num, String expectedOutput) {
        // Given

        // When
        String removed = removeTrailingZeros(num);

        // Then
        System.out.println("removeTrailingZeros(" + num + ") = " + removed);
        Assertions.assertThat(removed).isEqualTo(expectedOutput);
    }

    public String removeTrailingZeros(String num) {
        if (num.charAt(num.length() - 1) != '0') return num;
        int end = num.length() - 1;

        while (true) {
            if (num.charAt(end) == '0') end -= 1;
            else break;
        }

        return num.substring(0, end + 1);
    }
}
