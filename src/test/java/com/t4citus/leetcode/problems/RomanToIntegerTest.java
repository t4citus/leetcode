package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanToIntegerTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String input, int expectedOutput) {
        // Given

        // When
        int result = romanToInt(input);

        // Then
        System.out.println("The roman number '" + input + "' equals the integer '" + result + "'.");
        Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    /*
    I   1
    IV  4
    V   5
    IX  9
    X   10
    XL  40
    L   50
    XC  90
    C   100
    CD  400
    D   500
    CM  900
    M   1000
     */
    public int romanToInt(String s) {
        int number = 0;
        int beginIndex = 0;

        while (s.length() > 0) {
            if (s.startsWith("M")) {
                number += 1000;
                beginIndex = 1;
            } else if (s.startsWith("CM")) {
                number += 900;
                beginIndex = 2;
            } else if (s.startsWith("D")) {
                number += 500;
                beginIndex = 1;
            } else if (s.startsWith("CD")) {
                number += 400;
                beginIndex = 2;
            } else if (s.startsWith("C")) {
                number += 100;
                beginIndex = 1;
            } else if (s.startsWith("XC")) {
                number += 90;
                beginIndex = 2;
            } else if (s.startsWith("L")) {
                number += 50;
                beginIndex = 1;
            } else if (s.startsWith("XL")) {
                number += 40;
                beginIndex = 2;
            } else if (s.startsWith("X")) {
                number += 10;
                beginIndex = 1;
            } else if (s.startsWith("IX")) {
                number += 9;
                beginIndex = 2;
            } else if (s.startsWith("V")) {
                number += 5;
                beginIndex = 1;
            } else if (s.startsWith("IV")) {
                number += 4;
                beginIndex = 2;
            } else if (s.startsWith("I")) {
                number += 1;
                beginIndex = 1;
            }

            s = s.length() == beginIndex ? "" : s.substring(beginIndex);
        }

        return number;
    }
}
