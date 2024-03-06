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
        title = "46. Permutations",
        url = "https://leetcode.com/problems/permutations/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class PermutationsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, List.of(List.of(1, 2, 3), List.of(1, 3, 2), List.of(2, 1, 3), List.of(2, 3, 1), List.of(3, 1, 2), List.of(3, 2, 1))),
                Arguments.of(new int[]{0, 1}, List.of(List.of(0, 1), List.of(1, 0))),
                Arguments.of(new int[]{1}, List.of(List.of(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints, List<List<Integer>> expectedPermutations) {
        // Given

        // When
        List<List<Integer>> permutations = permute(ints);

        // Then
        System.out.println("permute(" + Arrays.toString(ints) + ") = " + permutations);
        Assertions.assertThat(flatten(permutations)).containsExactlyInAnyOrder(flatten(expectedPermutations).toArray(String[]::new));
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        List<List<Integer>> paths = new ArrayList<>();
        permute(nums, new ArrayList<>(), paths);
        return paths;
    }

    public void permute(int[] nums, List<Integer> path, List<List<Integer>> paths) {
        if (nums.length == 1) {
            path.add(nums[0]);
            paths.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            swap(nums,0, i);
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[0]);
            permute(Arrays.copyOfRange(nums, 1, nums.length), newPath, paths);
            swap(nums,0, i);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Helper function for test assertion.
     */
    private static List<String> flatten(List<List<Integer>> list) {
        return list.stream()
                .map(Object::toString)
                .toList();
    }

}
