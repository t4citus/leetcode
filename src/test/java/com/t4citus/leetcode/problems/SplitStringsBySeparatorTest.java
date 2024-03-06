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
        title = "2788. Split Strings by Separator",
        url = "https://leetcode.com/problems/split-strings-by-separator/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SplitStringsBySeparatorTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(List.of("one.two.three","four.five","six"), '.', List.of("one","two","three","four","five","six")),
                Arguments.of(List.of("$easy$","$problem$"), '$', List.of("easy","problem")),
                Arguments.of(List.of("|||"), '|', List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(List<String> words, char separator, List<String> expectedSplits) {
        // Given

        // When
        List<String> splits = splitWordsBySeparator(words, separator);

        // Then
        System.out.println("splitWordsBySeparator(" + words + ", " + separator + ") = " + splits);
        Assertions.assertThat(splits).isEqualTo(expectedSplits);
    }

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> splits = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            if (word.indexOf(separator) == -1) {
                splits.add(word);
                continue;
            }
            for (char ch : word.toCharArray()) {
                if (ch == separator) {
                    if (sb.length() > 0) {
                        splits.add(sb.toString());
                        sb = new StringBuilder();
                    }
                } else {
                    sb.append(ch);
                }
            }
            if (sb.length() > 0) {
                splits.add(sb.toString());
                sb = new StringBuilder();
            }
        }

        return splits;
    }
}
