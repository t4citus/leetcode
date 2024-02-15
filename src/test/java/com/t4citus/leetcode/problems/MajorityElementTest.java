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
        title = "169. Majority Element",
        url = "https://leetcode.com/problems/majority-element/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MajorityElementTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr(3,2,3), 3),
                Arguments.of(arr(2,2,1,1,1,2,2), 2),
                Arguments.of(arr(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int expectedOutput) {
        // Given

        // When
        int majority = majorityElement(input);

        // Then
        System.out.println("majorityElement(" + Arrays.toString(input) + ") = " + majority);
        Assertions.assertThat(majority).isEqualTo(expectedOutput);
    }

    public int majorityElement(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int n = nums.length/2;
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : nums) {
            if (counts.containsKey(num)) {
                int newValue = counts.get(num) + 1;
                if (newValue > n)
                    return num;
                counts.put(num, newValue);
            } else {
                counts.put(num, 1);
            }
        }

        return -1;
    }

    public static int[] arr(int... values) {
        return values == null ? new int[]{} : values;
    }
}
