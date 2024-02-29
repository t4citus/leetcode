package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "383. Ransom Note",
        url = "https://leetcode.com/problems/ransom-note/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RansomNoteTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String ransomNote, String magazine, boolean expectedCanConstruct) {
        // Given

        // When
        boolean canConstruct = canConstruct(ransomNote, magazine);

        // Then
        System.out.println("canConstruct(" + ransomNote + ", " + magazine + ") = " + canConstruct);
        Assertions.assertThat(canConstruct).isEqualTo(expectedCanConstruct);
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];

        for (char ch : magazine.toCharArray()) {
            chars[ch - 'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            int pos = ch - 'a';
            if (chars[pos] <= 0) {
                return false;
            }
            chars[pos]--;
        }

        return true;
    }
}
