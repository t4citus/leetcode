package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "387. First Unique Character in a String",
        url = "https://leetcode.com/problems/first-unique-character-in-a-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FirstUniqueCharacterInStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("leetcode", 0),
                Arguments.of("loveleetcode", 2),
                Arguments.of("aabb", -1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int expectedIndex) {
        // Given

        // When
        int index = firstUniqChar(s);

        // Then
        System.out.println("firstUniqChar(" + s + ") = " + index);
        Assertions.assertThat(index).isEqualTo(expectedIndex);
    }

    public int firstUniqChar(String s) {
        // count the character occurrences
        int[] counts = new int[26];
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            counts[chars[i] - 'a']++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (counts[chars[i] - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
