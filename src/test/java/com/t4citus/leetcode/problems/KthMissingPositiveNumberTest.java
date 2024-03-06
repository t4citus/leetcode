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
        title = "1539. Kth Missing Positive Number",
        url = "https://leetcode.com/problems/kth-missing-positive-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class KthMissingPositiveNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 3, 4, 7, 11}, 5, 9),
                Arguments.of(new int[]{1, 2, 3, 4}, 2, 6),
                Arguments.of(new int[]{5, 6, 7, 8, 9}, 9, 14)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] arr, int k, int expectedKthPositive) {
        // Given

        // When
        int kthPositive = findKthPositive(arr, k);

        // Then
        System.out.println("findKthPositive(" + Arrays.toString(arr) + ", " + k + ") = " + kthPositive);
        Assertions.assertThat(kthPositive).isEqualTo(expectedKthPositive);
    }

    public int findKthPositive(int[] arr, int k) {
        for (int a : arr) {
            if (a <= k) k += 1;
            else break;
        }
        return k;
    }
}
