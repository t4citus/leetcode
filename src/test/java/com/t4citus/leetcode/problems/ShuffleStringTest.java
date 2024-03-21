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
        title = "1528. Shuffle String",
        url = "https://leetcode.com/problems/shuffle-string/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ShuffleStringTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}, "leetcode"),
                Arguments.of("abc", new int[]{0, 1, 2}, "abc")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int[] indices, String expectedRestored) {
        // Given

        // When
        String restored = restoreString(s, indices);

        // Then
        System.out.println("restoreString(" + s + ", " + Arrays.toString(indices) + ") = " + restored);
        Assertions.assertThat(restored).isEqualTo(expectedRestored);
    }

    public String restoreString(String s, int[] indices) {
        char[] chars = new char[s.length()];

        for (int i = 0; i < indices.length; i++) {
            chars[indices[i]] = s.charAt(i);
        }

        return String.valueOf(chars);
    }
}
