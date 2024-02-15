package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Leetcode(
        title = "349. Intersection of Two Arrays",
        url = "https://leetcode.com/problems/intersection-of-two-arrays/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class IntersectionOfTwoArraysTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr(1, 2, 2, 1), arr(2, 2), arr(2)),
                Arguments.of(arr(4, 9, 5), arr(9, 4, 9, 8, 4), arr(9, 4))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input1, int[] input2, int[] expectedOutput) {
        // Given

        // When
        int[] intersection = intersection(input1, input2);

        // Then
        System.out.println("intersection(" + Arrays.toString(input1) + ", " + Arrays.toString(input2) + ") = " + Arrays.toString(intersection));
        Assertions.assertThat(set(intersection)).isEqualTo(set(expectedOutput));
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Set<Integer> set = new HashSet<>();
        for (int n : nums1) {
            set.add(n);
        }
        Set<Integer> intersect = new HashSet<>();
        for (int n : nums2) {
            if (set.contains(n)) {
                intersect.add(n);
            }
        }
        int[] arr = new int[intersect.size()];
        int i = 0;
        for (Integer n : intersect) {
            arr[i++] = n;
        }
        return arr;
    }

    public static Set<Integer> set(int[] ints) {
        Set<Integer> set = new HashSet<>();
        for (int i : ints) {
            set.add(i);
        }
        return set;
    }

    public static int[] arr(int... values) {
        return values == null ? new int[]{} : values;
    }
}
