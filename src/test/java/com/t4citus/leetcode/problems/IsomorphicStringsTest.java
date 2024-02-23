package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Leetcode(
        title = "205. Isomorphic Strings",
        url = "https://leetcode.com/problems/isomorphic-strings/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class IsomorphicStringsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("paper", "title", true),
                Arguments.of("badc", "baba", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, String t, boolean expectedOutput) {
        // Given

        // When
        boolean isomorphic = isIsomorphic(s, t);

        // Then
        System.out.println("isIsomorphic(" + s + ", " + t + ") = " + isomorphic);
        Assertions.assertThat(isomorphic).isEqualTo(expectedOutput);
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> charMap = new HashMap<>();
        Character key, value;

        for (int i = 0; i < s.length(); i++) {
            key = s.charAt(i);
            value = t.charAt(i);

            if (charMap.containsKey(key)) {
                if (charMap.get(key) != value) {
                    return false;
                }
            } else if (charMap.containsValue(value)) {
                return false;
            } else {
                charMap.put(key, value);
            }
        }

        return true;
    }
}
