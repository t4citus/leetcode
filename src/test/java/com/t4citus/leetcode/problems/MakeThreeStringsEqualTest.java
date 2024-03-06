package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "2937. Make Three Strings Equal",
        url = "https://leetcode.com/problems/make-three-strings-equal/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MakeThreeStringsEqualTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("abc", "abb", "ab", 2),
                Arguments.of("dac", "bac", "cac", -1),
                Arguments.of("a", "a", "a", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s1, String s2, String s3, int expectedMinimumOperations) {
        // Given

        // When
        int minimumOperations = findMinimumOperations(s1, s2, s3);

        // Then
        System.out.println("findMinimumOperations(" + s1 + ", " + s2 + ", " + s3 + ") = " + minimumOperations);
        Assertions.assertThat(minimumOperations).isEqualTo(expectedMinimumOperations);
    }

    public int findMinimumOperations(String s1, String s2, String s3) {
        int i = 0;

        while (i < s1.length() && i < s2.length() && i < s3.length()) {
            if (s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i))
                i += 1;
            else
                break;
        }

        int min = (s1.length() - i) + (s2.length() - i) + (s3.length() - i);
        return i == 0 ? -1 : min;
    }
}
