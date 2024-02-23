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
        title = "228. Summary Ranges",
        url = "https://leetcode.com/problems/summary-ranges/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SummaryRangesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 2, 4, 5, 7}, List.of("0->2", "4->5", "7")),
                Arguments.of(new int[]{0, 2, 3, 4, 6, 8, 9}, List.of("0", "2->4", "6", "8->9"))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, List<String> expectedOutput) {
        // Given

        // When
        List<String> ranges = summaryRanges(input);

        // Then
        System.out.println("summaryRanges(" + Arrays.toString(input) + ") = " + ranges);
        Assertions.assertThat(ranges).isEqualTo(expectedOutput);
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return List.of();

        List<String> ranges = new ArrayList<>();
        int left = nums[0];
        int right = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == right + 1) {
                right = nums[i];
                continue;
            }

            StringBuilder sb = new StringBuilder();
            ranges.add(left == right ? sb.append(left).toString() : sb.append(left).append("->").append(right).toString());
            left = nums[i];
            right = nums[i];
        }

        StringBuilder sb = new StringBuilder();
        ranges.add(left == right ? sb.append(left).toString() : sb.append(left).append("->").append(right).toString());
        return ranges;
    }
}
