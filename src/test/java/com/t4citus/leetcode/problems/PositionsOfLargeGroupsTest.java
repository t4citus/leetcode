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
        title = "830. Positions of Large Groups",
        url = "https://leetcode.com/problems/positions-of-large-groups/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PositionsOfLargeGroupsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abbxxxxzzy", List.of(List.of(3, 6))),
                Arguments.of("abc", List.of()),
                Arguments.of("abcdddeeeeaabbbcd", List.of(List.of(3, 5), List.of(6, 9), List.of(12, 14))),
                Arguments.of("aaa", List.of(List.of(0, 2)))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, List<List<Integer>> expectedLargeGroupPositions) {
        // Given

        // When
        List<List<Integer>> largeGroupPositions = largeGroupPositions(s);

        // Then
        System.out.println("largeGroupPositions(" + s + ") = " + largeGroupPositions);
        Assertions.assertThat(largeGroupPositions).isEqualTo(expectedLargeGroupPositions);
    }

    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() < 3) return List.of();

        List<List<Integer>> positions = new ArrayList<>();
        int pos = 0;
        int n = s.length();

        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                if (i - pos >= 3) {
                    positions.add(List.of(pos, i - 1));
                }
                pos = i;
            }
        }

        if (n - pos >= 3) {
            positions.add(List.of(pos, n - 1));
        }

        return positions;
    }
}
