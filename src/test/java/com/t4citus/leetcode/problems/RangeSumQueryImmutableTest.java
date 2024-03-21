package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@Leetcode(
        title = "303. Range Sum Query - Immutable",
        url = "https://leetcode.com/problems/range-sum-query-immutable/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RangeSumQueryImmutableTest extends AbstractTestBase {

    @Test
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected() {
        // Given

        // When
        NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});

        // Then
        Assertions.assertThat(numArray.sumRange(0, 2)).isEqualTo(1);
        Assertions.assertThat(numArray.sumRange(2, 5)).isEqualTo(-1);
        Assertions.assertThat(numArray.sumRange(0, 5)).isEqualTo(-3);
    }

    /**
     * Since the NumArray is am immutable class, it can pre-calculate all its internal values to support better
     * performance.
     * <p>
     * Example:
     * nums = [ -2, 0, 3, -5, 2, -1 ]       // input
     * sums = [ -2, -2, 1, -4, -2, -3 ]     // each position sums up all preceding numbers
     * <p>
     * case 1: sum(0, 2) = 1 = sums[2] means sum(0, right) = sums[right]
     * case 2: sum(1, 3) = -2 = sums[3] - sums[0] means sum(left, right) = sums[right] - sums[left - 1]
     * case 3: sum(1, 1) = 0 means sum(left, right) = sums[right] - sums[left] (equals case 2)
     */
    static class NumArray {
        private final int[] sums;

        public NumArray(int[] nums) {
            sums = nums;
            for (int i = 1; i < sums.length; i++) {
                sums[i] += sums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return sums[right];
            }
            return sums[right] - sums[left - 1];
        }
    }
}
