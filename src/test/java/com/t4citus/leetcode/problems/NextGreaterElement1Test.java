package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@Leetcode(
        title = "496. Next Greater Element I",
        url = "https://leetcode.com/problems/next-greater-element-i/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class NextGreaterElement1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                Arguments.of(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] nums1, int[] nums2, int[] expectedGreaterElements) {
        // Given

        // When
        int[] greaterElements = nextGreaterElement(nums1, nums2);

        // Then
        System.out.println("nextGreaterElement(" + Arrays.toString(nums1) + ", " + Arrays.toString(nums2) + ") = " + Arrays.toString(greaterElements));
        Assertions.assertThat(greaterElements).isEqualTo(expectedGreaterElements);
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Set<Integer> elements = new HashSet<>();
        for (int n : nums1) {
            elements.add(n);
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (elements.contains(nums2[i]))
                indexMap.put(nums2[i], i);
        }

        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int start = indexMap.get(nums1[i]);
            for (int j = start; j < nums2.length; j++) {
                if (nums2[j] > nums1[i]) {
                    res[i] = nums2[j];
                    break;
                }
                if (j == nums2.length - 1) {
                    res[i] = -1;
                }
            }
        }

        return res;
    }
}
