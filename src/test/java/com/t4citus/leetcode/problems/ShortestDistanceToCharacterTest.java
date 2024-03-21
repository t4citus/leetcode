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
        title = "821. Shortest Distance to a Character",
        url = "https://leetcode.com/problems/shortest-distance-to-a-character/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ShortestDistanceToCharacterTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("loveleetcode", 'e', new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0}),
                Arguments.of("aaab", 'b', new int[]{3, 2, 1, 0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, char c, int[] expectedDistances) {
        // Given

        // When
        int[] distances = shortestToChar(s, c);

        // Then
        System.out.println("shortestToChar(" + s + ", " + c + ") = " + Arrays.toString(distances));
        Assertions.assertThat(distances).isEqualTo(expectedDistances);
    }

    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] distances = new int[n];
        int pos = n;

        // evaluate from left
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            distances[i] = Math.abs(pos - i);
        }

        // evaluate from right
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            distances[i] = Math.min(Math.abs(pos - i), distances[i]);
        }

        return distances;
    }
}
