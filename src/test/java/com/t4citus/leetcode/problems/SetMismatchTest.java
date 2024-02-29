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
        title = "645. Set Mismatch",
        url = "https://leetcode.com/problems/set-mismatch/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SetMismatchTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 2, 4}, new int[]{2, 3}),
                Arguments.of(new int[]{1, 1}, new int[]{1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int[] expectedErrorNums) {
        // Given

        // When
        int[] errorNums = findErrorNums(ints);

        // Then
        System.out.println("findErrorNums(" + Arrays.toString(ints) + ") = " + Arrays.toString(errorNums));
        Assertions.assertThat(errorNums).isEqualTo(expectedErrorNums);
    }

    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int gauss = n * (n + 1) / 2;
        int sum = 0;
        int[] res = new int[2];
        boolean found = false;

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            sum += num;
            if (!found) {
                if (!seen.contains(num)) {
                    seen.add(num);
                } else {
                    res[0] = num;
                    found = true;
                }
            }
        }

        res[1] = res[0] + gauss - sum;
        return res;
    }
}
