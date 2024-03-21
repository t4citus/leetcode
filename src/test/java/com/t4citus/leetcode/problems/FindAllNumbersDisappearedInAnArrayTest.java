package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "448. Find All Numbers Disappeared in an Array",
        url = "https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FindAllNumbersDisappearedInAnArrayTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{4, 3, 2, 7, 8, 2, 3, 1}, List.of(5, 6)),
                Arguments.of(new int[]{1, 1}, List.of(2))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] nums, List<Integer> expectedDisappearedNumbers) {
        // Given
        String numsString = Arrays.toString(nums);

        // When
        List<Integer> disappearedNumbers = findDisappearedNumbers(nums);

        // Then
        System.out.println("findDisappearedNumbers(" + numsString + ") = " + disappearedNumbers);
        Assertions.assertThat(disappearedNumbers).isEqualTo(expectedDisappearedNumbers);
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            nums[index] = -1 * Math.abs(nums[index]);
        }

        List<Integer> missing = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                missing.add(i + 1);
        }

        return missing;
    }
}
