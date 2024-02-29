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
        title = "3038. Maximum Number of Operations With the Same Score I",
        url = "https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-i/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MaximumNumberOfOperationsWithTheSameScope1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 1, 4, 5}, 2),
                Arguments.of(new int[]{3, 2, 6, 1, 4}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedMaxOperations) {
        // Given

        // When
        int maxOperations = maxOperations(ints);

        // Then
        System.out.println("maxOperations(" + Arrays.toString(ints) + ") = " + maxOperations);
        Assertions.assertThat(maxOperations).isEqualTo(expectedMaxOperations);
    }

    public int maxOperations(int[] nums) {
        if (nums.length == 2) return 1;

        int count = 1, sum = nums[0] + nums[1], i = 2;

        while (i < nums.length - 1) {
            if (nums[i] + nums[i + 1] != sum) break;
            count += 1;
            i += 2;
        }

        return count;
    }
}
