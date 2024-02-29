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
        title = "350. Intersection of Two Arrays II",
        url = "https://leetcode.com/problems/intersection-of-two-arrays-ii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class IntersectionOfTwoArrays2Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 1}, new int[]{2, 2}, new int[]{2, 2}),
                Arguments.of(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}, new int[]{4, 9}),
                Arguments.of(new int[]{1,2,2,1}, new int[]{2}, new int[]{2})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints1, int[] ints2, int[] expectedIntersect) {
        // Given
        String ints1AsString = Arrays.toString(ints1);
        String ints2AsString = Arrays.toString(ints2);

        // When
        int[] intersect = intersect(ints1, ints2);

        // Then
        System.out.println("intersect(" + ints1AsString + ", " + ints2AsString + ") = " + Arrays.toString(intersect));
        Assertions.assertThat(intersect).containsExactlyInAnyOrder(expectedIntersect);
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        int[] smaller, greater;

        if (nums1.length < nums2.length) {
            smaller = nums1;
            greater = nums2;
        } else {
            smaller = nums2;
            greater = nums1;
        }

        int[] counts = new int[1001];
        for (int sm : smaller) {
            counts[sm]++;
        }

        int pos = 0;
        for (int i = 0; i < greater.length; i++) {
            if (counts[greater[i]] > 0) {
                int tmp = greater[i];
                greater[i] = greater[pos];
                greater[pos] = tmp;
                pos += 1;
                counts[tmp]--;
            }
        }

        return pos > 0 ? Arrays.copyOfRange(greater, 0, pos) : new int[0];
    }
}
