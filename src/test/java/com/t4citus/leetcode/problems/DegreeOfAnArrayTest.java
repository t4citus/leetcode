package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Leetcode(
        title = "697. Degree of an Array",
        url = "https://leetcode.com/problems/degree-of-an-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class DegreeOfAnArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,2,3,1}, 2),
                Arguments.of(new int[]{1,2,2,3,1,4,2}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedShortest) {
        // Given

        // When
        int shortest = findShortestSubArray(ints);

        // Then
        System.out.println("findShortestSubArray(" + Arrays.toString(ints) + ") = " + shortest);
        Assertions.assertThat(shortest).isEqualTo(expectedShortest);
    }

    record Stats(int count, int from, int to) {}

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Stats> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            Stats stats = map.get(n);
            if (stats == null) {
                map.put(n, new Stats(1, i, i));
                max = Math.max(max, 1);
            } else {
                map.put(n, new Stats(stats.count + 1, stats.from, i));
                max = Math.max(max, stats.count + 1);
            }
        }
        int minDegree = Integer.MAX_VALUE;
        for (Stats stats : map.values()) {
            if (stats.count == max) {
                minDegree = Math.min(minDegree, stats.to - stats.from + 1);
            }
        }
        return minDegree;
    }
}
