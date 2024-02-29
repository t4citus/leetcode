package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "3005. Count Elements With Maximum Frequency",
        url = "https://leetcode.com/problems/count-elements-with-maximum-frequency/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class CountElementsWithMaximumFrequencyTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,2,3,1,4}, 4),
                Arguments.of(new int[]{1,2,3,4,5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, int expectedMaxFrequency) {
        // Given

        // When
        int maxFrequency = maxFrequencyElements(ints);

        // Then
        System.out.println("maxFrequencyElements(" + Arrays.toString(ints) + ") = " + maxFrequency);
        Assertions.assertThat(maxFrequency).isEqualTo(expectedMaxFrequency);
    }

    public int maxFrequencyElements(int[] nums) {
        int[] counts = new int[101];
        int max = 0;

        for (int num : nums) {
            counts[num]++;
            max = Math.max(max, counts[num]);
        }

        int maxFreq = 0;
        for (int count : counts) {
            if (count == max) {
                maxFreq += count;
            }
        }

        return maxFreq;
    }
}
