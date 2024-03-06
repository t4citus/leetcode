package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Leetcode(
        title = "17. Letter Combinations of a Phone Number",
        url = "https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class LetterCombinationsOfPhoneNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("23", List.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                Arguments.of("", List.of()),
                Arguments.of("2", List.of("a", "b", "c"))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String digits, List<String> expectedCombinations) {
        // Given

        // When
        List<String> combinations = letterCombinations(digits);

        // Then
        System.out.println("letterCombinations(" + digits + ") = " + combinations);
        Assertions.assertThat(combinations).containsExactlyInAnyOrder(expectedCombinations.toArray(String[]::new));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return List.of();

        List<String> total = null;
        char[] chars = digits.toCharArray();

        for (char ch : chars) {
            total = addLetters(total, letterMap.get(ch));
        }

        return total;
    }

    public List<String> addLetters(List<String> initial, List<Character> additional) {
        List<String> newList = new ArrayList<>();

        if (initial == null || initial.isEmpty()) {
            for (Character ch : additional) {
                newList.add(String.valueOf(ch));
            }
        } else {
            for (String i : initial) {
                for (Character a : additional) {
                    newList.add(i + a);
                }
            }
        }

        return newList;
    }

    public static final Map<Character, List<Character>> letterMap = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
    );
}
