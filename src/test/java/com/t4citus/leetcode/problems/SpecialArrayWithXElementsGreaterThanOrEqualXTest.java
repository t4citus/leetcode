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
        title = "1608. Special Array With X Elements Greater Than or Equal X",
        url = "https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SpecialArrayWithXElementsGreaterThanOrEqualXTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 5}, 2),
                Arguments.of(new int[]{0, 0}, -1),
                Arguments.of(new int[]{0, 4, 3, 0, 4}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedSpecialArray) {
        // Given

        // When
        int specialArray = specialArray(ints);

        // Then
        System.out.println("specialArray(" + Arrays.toString(ints) + ") = " + specialArray);
        Assertions.assertThat(specialArray).isEqualTo(expectedSpecialArray);
    }

    public int specialArray(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n + 1];

        // scan array (count all elements e <= n)
        for (int num : nums) {
            counts[Math.min(num, n)]++;
        }

        // check counts (scan from the left and sum counts to avoid multiple loops)
        int total = 0;
        for (int i = counts.length - 1; i >= 0; i--) {
            total += counts[i];
            if (total == i) return i;
        }

        return -1;
    }
}
