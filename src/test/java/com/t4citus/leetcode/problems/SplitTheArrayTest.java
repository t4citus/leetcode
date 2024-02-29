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
        title = "3046. Split the Array",
        url = "https://leetcode.com/problems/split-the-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SplitTheArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2, 2, 3, 4}, true),
                Arguments.of(new int[]{1, 1, 1, 1}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, boolean expectedPossibleToSplit) {
        // Given

        // When
        boolean possibleToSplit = isPossibleToSplit(ints);

        // Then
        System.out.println("isPossibleToSplit(" + Arrays.toString(ints) + ") = " + possibleToSplit);
        Assertions.assertThat(possibleToSplit).isEqualTo(expectedPossibleToSplit);
    }

    /**
     * The array cannot be split with distinct values if a number appears more than once.
     */
    public boolean isPossibleToSplit(int[] nums) {
        int[] counts = new int[101];
        for (int n : nums) {
            counts[n]++;
            if (counts[n] > 2) return false;
        }
        return true;
    }
}
