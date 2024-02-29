package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@Leetcode(
        title = "500. Keyboard Row",
        url = "https://leetcode.com/problems/keyboard-row/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class KeyboardRowTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new String[]{"Hello", "Alaska", "Dad", "Peace"}, new String[]{"Alaska", "Dad"}),
                Arguments.of(new String[]{"omk"}, new String[0]),
                Arguments.of(new String[]{"adsdf", "sfd"}, new String[]{"adsdf", "sfd"})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] input, String[] expectedOutput) {
        // Given

        // When
        String[] words = findWords(input);

        // Then
        System.out.println("findWords(" + Arrays.toString(input) + ") = " + Arrays.toString(words));
        Assertions.assertThat(words).isEqualTo(expectedOutput);
    }

    static final String FIRST = "qwertyuiopQWERTYUIOP";
    static final String SECOND = "asdfghjklASDFGHJKL";
    static final String THIRD = "zxcvbnmZXCVBNM";

    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) return new String[0];

        List<String> hits = new ArrayList<>();
        int[] flags = new int[3];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                if (FIRST.indexOf(ch) != -1) {
                    flags[0] = 1;
                } else if (SECOND.indexOf(ch) != -1) {
                    flags[1] = 1;
                } else if (THIRD.indexOf(ch) != -1) {
                    flags[2] = 1;
                }
            }
            if (flags[0] + flags[1] + flags[2] == 1)
                hits.add(word);

            // reset flags
            Arrays.fill(flags, 0);
        }

        return hits.toArray(String[]::new);
    }

    private static Stream<Arguments> xor() {
        return Stream.of(
                Arguments.of(false, false, false, false),
                Arguments.of(false, false, true, true),
                Arguments.of(false, true, false, true),
                Arguments.of(false, true, true, false),
                Arguments.of(true, false, false, true),
                Arguments.of(true, false, true, false),
                Arguments.of(true, true, false, false),
                Arguments.of(true, true, true, false)
        );
    }

    @ParameterizedTest
    @MethodSource("xor")
    public void test(boolean b1, boolean b2, boolean b3, boolean expected) {
        boolean xor = b1 ^ b2 ^ b3;
        Assertions.assertThat(xor).isEqualTo(expected);
    }
}
