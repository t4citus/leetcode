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
        title = "136. Single Number",
        url = "https://leetcode.com/problems/single-number/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SingleNumberTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(arr(2, 2, 1), 1),
                Arguments.of(arr(4, 1, 2, 1, 2), 4),
                Arguments.of(arr(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int expectedOutput) {
        // Given

        // When
        int singleNumber = singleNumber(input);

        // Then
        System.out.println("singleNumber(" + Arrays.toString(input) + ") = " + expectedOutput);
        Assertions.assertThat(singleNumber).isEqualTo(expectedOutput);
    }

    public int singleNumber(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Map<Integer, Integer> counts = new HashMap<>();
        for (int num : nums) {
            Integer val = counts.getOrDefault(num, 0);
            counts.put(num, val + 1);
        }

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue().equals(1)) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int[] arr(int... values) {
        return values == null ? new int[]{} : values;
    }
}
