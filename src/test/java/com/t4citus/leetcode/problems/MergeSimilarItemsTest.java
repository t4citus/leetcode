package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@Leetcode(
        title = "2363. Merge Similar Items",
        url = "https://leetcode.com/problems/merge-similar-items/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MergeSimilarItemsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][]{new int[]{1, 1}, new int[]{4, 5}, new int[]{3, 8}}, new int[][]{new int[]{3, 1}, new int[]{1, 5}}, Arrays.asList(Arrays.asList(1, 6), Arrays.asList(3, 9), Arrays.asList(4, 5))),
                Arguments.of(new int[][]{new int[]{1, 1}, new int[]{3, 2}, new int[]{2, 3}}, new int[][]{new int[]{2, 1}, new int[]{3, 2}, new int[]{1, 3}}, Arrays.asList(Arrays.asList(1, 4), Arrays.asList(2, 4), Arrays.asList(3, 4))),
                Arguments.of(new int[][]{new int[]{1, 3}, new int[]{2, 2}}, new int[][]{new int[]{7, 1}, new int[]{2, 2}, new int[]{1, 4}}, Arrays.asList(Arrays.asList(1, 7), Arrays.asList(2, 4), Arrays.asList(7, 1)))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[][] items1, int[][] items2, List<List<Integer>> expectedOutput) {
        // Given

        // When
        List<List<Integer>> results = mergeSimilarItems(items1, items2);

        // Then
        System.out.println("mergeSimilarItems(" + toString(items1) + ", " + toString(items2) + ") = " + toString(results));
        Assertions.assertThat(areListsEqual(results, expectedOutput)).isTrue();
    }

    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> map = new HashMap<>();

        // Add items1
        for (int[] item : items1) {
            map.put(item[0], item[1]);
        }

        // Add items2
        for (int[] item : items2) {
            if (!map.containsKey(item[0])) {
                map.put(item[0], item[1]);
            } else {
                map.put(item[0], map.get(item[0]) + item[1]);
            }
        }

        return map.entrySet().stream()
                .map(entry -> Arrays.asList(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(l -> l.get(0)))
                .toList();
    }

    private static String toString(int[][] items) {
        return Arrays.toString(Arrays.stream(items)
                .map(Arrays::toString)
                .toArray(String[]::new));
    }

    private static String toString(List<List<Integer>> list) {
        return list.toString();
    }

    private static boolean isListEqual(List<Integer> left, List<Integer> right) {
        if (left.size() != right.size()) {
            return false;
        }
        for (int i = 0; i < left.size(); i++) {
            if (!Objects.equals(left.get(i), right.get(i))) {
                return false;
            }
        }
        return true;
    }

    private boolean areListsEqual(List<List<Integer>> left, List<List<Integer>> right) {
        if (left.size() != right.size()) {
            return false;
        }
        for (int i = 0; i < left.size(); i++) {
            if (!isListEqual(left.get(i), right.get(i))) {
                return false;
            }
        }
        return true;
    }
}
