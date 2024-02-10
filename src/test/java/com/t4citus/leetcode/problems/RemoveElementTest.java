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
        title = "27. Remove Element",
        url = "https://leetcode.com/problems/remove-element/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RemoveElementTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3, 2, new int[]{2, 2, -1, -1}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2, 5, new int[]{0, 1, 3, 0, 4, -1, -1, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] arr, int val, int expectedLength, int[] expectedArr) {
        // Given

        // When
        int length = removeElement(arr, val);

        // Then
        System.out.println("The resulting array is " + Arrays.toString(arr) + " with the length of " + length + ".");
        Assertions.assertThat(length).isEqualTo(expectedLength);
        Assertions.assertThat(equals(arr, expectedArr)).isTrue();
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        int i = 0;
        int idx = nums.length - 1;
        while (i < nums.length) {
            if (nums[i] == val) {
                nums[i] = -1;
                len--;
                for (int j = i; j < idx; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[idx] = -1;
                idx--;
            } else {
                i++;
            }
        }
        return len;
    }
}
