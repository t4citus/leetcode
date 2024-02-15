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
        title = "88. Merge Sorted Array",
        url = "https://leetcode.com/problems/merge-sorted-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MergeSortedArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr(1, 2, 3, 0, 0, 0), 3, arr(2, 5, 6), 3, arr(1, 2, 2, 3, 5, 6)),
                Arguments.of(arr(1), 1, arr(), 0, arr(1)),
                Arguments.of(arr(0), 0, arr(1), 1, arr(1)),
                Arguments.of(arr(4, 5, 6, 0, 0, 0), 3, arr(1, 2, 3), 3, arr(1, 2, 3, 4, 5, 6))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] nums1, int m, int[] nums2, int n, int[] expectedOutput) {
        // Given
        String nums1String = Arrays.toString(nums1);
        String nums2String = Arrays.toString(nums2);

        // When
        merge(nums1, m, nums2, n);

        // Then
        System.out.println("merge(" + nums1String + ", " + m + ", " + nums2String + ", " + n + ") = " + Arrays.toString(nums1));
        Assertions.assertThat(nums1.length).isEqualTo(m + n);
        Assertions.assertThat(IntUtil.equals(nums1, expectedOutput)).isTrue();
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length == m || n == 0)
            return;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static int[] arr(int... values) {
        return values == null ? new int[]{} : values;
    }
}
