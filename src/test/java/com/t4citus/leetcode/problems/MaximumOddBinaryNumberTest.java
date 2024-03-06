package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "2864. Maximum Odd Binary Number",
        url = "https://leetcode.com/problems/maximum-odd-binary-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MaximumOddBinaryNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("010", "001"),
                Arguments.of("0101", "1001")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String expectedMaximum) {
        // Given

        // When
        String maximum = maximumOddBinaryNumber(s);

        // Then
        System.out.println("maximumOddBinaryNumber(" + s + ") = " + maximum);
        Assertions.assertThat(maximum).isEqualTo(expectedMaximum);
    }

    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int ones = 0;

        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == '1') ones++;
        }

        Arrays.fill(chars, '0');
        if (ones > 1) {
            for (int i = 0; i < ones - 1; i++) {
                chars[i] = '1';
            }
        }
        chars[n - 1] = '1';

        return String.valueOf(chars);
    }
}
