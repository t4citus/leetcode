package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class NumberOfArithmeticTripletsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 4, 6, 7, 10}, 3, 2),
                Arguments.of(new int[]{4, 5, 6, 7, 8, 9}, 2, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int diff, int expectedOutput) {
        // Given

        // When
        int count = arithmeticTriplets(input, diff);

        // Then
        System.out.println("arithmeticTriplets(" + Arrays.toString(input) + ", " + diff + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedOutput);
    }

    public int arithmeticTriplets(int[] nums, int diff) {
        if (nums.length == 0 || diff == 0)
            return 0;

        Map<Integer, Integer> triplets = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[i] == diff) {
                    triplets.put(i, j);
                }
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(triplets.keySet());
        Collections.sort(sortedKeys);

        int numTriplets = 0;
        for (Integer key : sortedKeys) {
            if (triplets.containsKey(key) && triplets.containsKey(triplets.get(key))) {
                numTriplets++;
            }
        }

        return numTriplets;
    }
}
