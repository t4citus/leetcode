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
        title = "561. Array Partition",
        url = "https://leetcode.com/problems/array-partition/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ArrayPartitionTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 4, 3, 2}, 4),
                Arguments.of(new int[]{6, 2, 6, 5, 1, 2}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] numbers, int expectedSum) {
        // Given
        String numbersString = Arrays.toString(numbers);

        // When
        int sum = arrayPairSum(numbers);

        // Then
        System.out.println("arrayPairSum(" + numbersString + ") = " + sum);
        Assertions.assertThat(sum).isEqualTo(expectedSum);
    }

    /**
     * The goal of the solution is to constantly find the highest minimum of pairs. By sorting the numbers the highest
     * numbers is always put next to the highest minimum.
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0, i = nums.length - 2;

        while (i >= 0) {
            sum += nums[i];
            i -= 2;
        }

        return sum;
    }
}
