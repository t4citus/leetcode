package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "28. Find the Index of the First Occurrence in a String",
        url = "https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FindTheIndexOfTheFirstOccurrenceInStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1),
                Arguments.of("a", "a", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String haystack, String needle, int expectedOutput) {
        // Given

        // When
        int index = strStr(haystack, needle);

        // Then
        System.out.println("strStr(" + haystack + ", " + needle + ") = " + "<function_result>");
        Assertions.assertThat(index).isEqualTo(expectedOutput);
    }

    public int strStr(String haystack, String needle) {
        String str = haystack;
        int index = 0;
        while (str.length() >= needle.length()) {
            if (str.startsWith(needle)) {
                return index;
            }
            str = str.substring(1);
            index++;
        }
        return -1;
    }
}
