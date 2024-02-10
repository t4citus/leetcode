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
        title = "141. Linked List Cycle",
        url = "https://leetcode.com/problems/linked-list-cycle/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LongestCommonPrefixTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[]{"flower","flow","flight"}, "fl"),
                Arguments.of(new String[]{"dog","racecar","car"}, ""),
                Arguments.of(new String[]{"ab", "a"}, "a")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] input, String expectedOutput) {
        // Given

        // When
        String result = longestCommonPrefix(input);

        // Then
        System.out.println("The longest common prefix for " + Arrays.toString(input) + " is '" + result + ".");
        Assertions.assertThat(result).isEqualTo(expectedOutput);
    }

    public String longestCommonPrefix(String[] strings) {
        if (strings.length == 0) {
            return "";
        }
        StringBuilder longest = new StringBuilder();
        String first = strings[0];
        boolean allMatch;

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            allMatch = true;

            for (int j = 1; j < strings.length; j++) {
                if (i >= strings[j].length() || strings[j].charAt(i) != c) {
                    allMatch = false;
                    break;
                }
            }

            if (!allMatch) {
                break;
            }

            longest.append(c);
        }

        return longest.toString();
    }
}
