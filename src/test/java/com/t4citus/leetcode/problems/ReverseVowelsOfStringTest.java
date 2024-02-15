package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Leetcode(
        title = "345. Reverse Vowels of a String",
        url = "https://leetcode.com/problems/reverse-vowels-of-a-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReverseVowelsOfStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("hello", "holle"),
                Arguments.of("leetcode", "leotcede")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String input, String expectedOutput) {
        // Given

        // When
        String reversed = reverseVowels(input);

        // Then
        System.out.println("reverseVowels(" + input + ") = " + reversed);
        Assertions.assertThat(reversed).isEqualTo(expectedOutput);
    }

    public static final Set<Character> VOWELS = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;

        while (l < r) {
            boolean lf = false, rf = false;
            while (l < r) {
                if (VOWELS.contains(chars[l])) {
                    lf = true;
                    break;
                } else {
                    l++;
                }
            }
            while (l < r) {
                if (VOWELS.contains(chars[r])) {
                    rf = true;
                    break;
                } else {
                    r--;
                }
            }
            if (lf && rf) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                l++;
                r--;
            }
        }
        return String.valueOf(chars);
    }
}
