package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "696. Count Binary Substrings",
        url = "https://leetcode.com/problems/count-binary-substrings/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class CountBinarySubstringsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("00110011", 6),
                Arguments.of("10101", 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int expectedCount) {
        // Given

        // When
        int count = countBinarySubstrings(s);

        // Then
        System.out.println("countBinarySubstrings(" + s + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }

    public int countBinarySubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int currGrp = 1; // set to '1' as the first position of chars is expected in the current group
        int prevGrp = 0; // set to '0' as the prev group size is assumed to be 0
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (i == n || chars[i - 1] != chars[i]) {
                count += Math.min(prevGrp, currGrp);
                prevGrp = currGrp;
                currGrp = 1;
            } else {
                currGrp += 1;
            }
        }

        return count;
    }
}
