package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "1374. Generate a String With Characters That Have Odd Counts",
        url = "https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class GenerateStringWithCharactersThatHaveOddCountsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(4, "aaab"),
                Arguments.of(2, "ab")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, String expectedGenerated) {
        // Given

        // When
        String generated = generateTheString(n);

        // Then
        System.out.println("generateTheString(" + n + ") = " + generated);
        Assertions.assertThat(generated).isEqualTo(expectedGenerated);
    }

    public String generateTheString(int n) {
        if (n % 2 == 1) {
            return "a".repeat(n);
        }
        return "a".repeat(n - 1) + "b";
    }
}
