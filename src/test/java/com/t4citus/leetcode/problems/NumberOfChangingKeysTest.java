package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "3019. Number of Changing Keys",
        url = "https://leetcode.com/problems/number-of-changing-keys/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class NumberOfChangingKeysTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aAbBcC", 2),
                Arguments.of("AaAaAaaA", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int expectedKeyChanges) {
        // Given

        // When
        int keyChanges = countKeyChanges(s);

        // Then
        System.out.println("countKeyChanges(" + s + ") = " + keyChanges);
        Assertions.assertThat(keyChanges).isEqualTo(expectedKeyChanges);
    }

    public int countKeyChanges(String s) {
        int changes = 0;
        char[] chars = s.toLowerCase().toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i - 1] != chars[i]) {
                changes += 1;
            }
        }
        return changes;
    }
}
