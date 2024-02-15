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
        title = "344. Reverse String",
        url = "https://leetcode.com/problems/reverse-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReverseStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr('h', 'e', 'l', 'l', 'o'), arr('o', 'l', 'l', 'e', 'h')),
                Arguments.of(arr('H', 'a', 'n', 'n', 'a', 'h'), arr('h', 'a', 'n', 'n', 'a', 'H'))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(char[] input, char[] expectedOutput) {
        // Given
        // Store copy for assertion as the reverse function changes the input array.
        char[] inputCopy = Arrays.copyOf(input, input.length);

        // When
        reverseString(input);

        // Then
        System.out.println("reverseString(" + Arrays.toString(inputCopy) + ") = " + Arrays.toString(input));
        Assertions.assertThat(equals(input, expectedOutput)).isTrue();
    }

    public void reverseString(char[] s) {
        int length = s.length;
        if (length == 1) {
            return;
        }
        int mid = length % 2 == 0 ? length / 2 : (length - 1) / 2;
        for (int i = 0; i < mid; i++) {
            char temp = s[i];
            s[i] = s[length - 1 - i];
            s[length - 1 - i] = temp;
        }
    }

    public static char[] arr(char... values) {
        return values == null ? new char[]{} : values;
    }

    public static boolean equals(char[] left, char[] right) {
        if (left.length != right.length) {
            return false;
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }
}
