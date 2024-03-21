package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "438. Find All Anagrams in a String",
        url = "https://leetcode.com/problems/find-all-anagrams-in-a-string/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class FindAllAnagramsInStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("cbaebabacd", "abc", List.of(0, 6)),
                Arguments.of("abab", "ab", List.of(0, 1, 2)),
                Arguments.of("aa", "bb", List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String p, List<Integer> expectedStartIndices) {
        // Given

        // When
        List<Integer> startIndices = findAnagrams(s, p);

        // Then
        System.out.println("findAnagrams(" + s + ", " + p + ") = " + startIndices);
        Assertions.assertThat(startIndices).containsExactlyInAnyOrder(expectedStartIndices.toArray(Integer[]::new));
    }

    /**
     * The idea is a moving window with the length of len(p). Since the characters are counted within an array,
     * it's easy to un-track the last char and to track the new char.
     */
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) return List.of();

        List<Integer> startIndices = new ArrayList<>();
        int sLen = s.length();
        int pLen = p.length();
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) {
            startIndices.add(0);
        }

        for (int i = pLen; i < sLen; i++) {
            sCount[s.charAt(i - pLen) - 'a']--;
            sCount[s.charAt(i) - 'a']++;

            if (Arrays.equals(pCount, sCount)) {
                startIndices.add(i - pLen + 1);
            }
        }

        return startIndices;
    }
}
