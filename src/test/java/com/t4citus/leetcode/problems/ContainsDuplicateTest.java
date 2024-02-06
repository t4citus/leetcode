package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class ContainsDuplicateTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,1}, true),
                Arguments.of(new int[]{1,2,3,4}, false),
                Arguments.of(new int[]{1,1,1,3,3,4,3,2,4,2}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, boolean expectedOutput) {
        // Given

        // When
        boolean contains = containsDuplicate(input);

        // Then
        System.out.println("containsDuplicate(" + Arrays.toString(input) + ") = " + contains);
        Assertions.assertThat(contains).isEqualTo(expectedOutput);
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0)
            return false;

        Set<Integer> visited = new HashSet<>();
        for (int num : nums) {
            if (!visited.add(num)) {
                return true;
            }
        }
        return false;
    }
}
