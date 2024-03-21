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
        title = "599. Minimum Index Sum of Two Lists",
        url = "https://leetcode.com/problems/minimum-index-sum-of-two-lists/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MinimumIndexSumOfTwoListsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"},
                        new String[]{"Shogun"}
                ),
                Arguments.of(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"},
                        new String[]{"Shogun"}
                ),
                Arguments.of(
                        new String[]{"happy", "sad", "good"},
                        new String[]{"sad", "happy", "good"},
                        new String[]{"sad", "happy"}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] list1, String[] list2, String[] expectedMinimumIndexSum) {
        // Given

        // When
        String[] minimumIndexSum = findRestaurant(list1, list2);

        // Then
        System.out.println("findRestaurant(" + Arrays.toString(list1) + ", " + Arrays.toString(list2) + ") = " + Arrays.toString(minimumIndexSum));
        Assertions.assertThat(minimumIndexSum).containsExactlyInAnyOrder(expectedMinimumIndexSum);
    }

    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }

        Map<String, Integer> indexMap = new HashMap<>();
        List<String> results = new ArrayList<>();
        int minIndexSum = Integer.MAX_VALUE;

        for (int i = 0; i < list1.length; i++) {
            indexMap.put(list1[i], i);
        }

        for (int i = 0; i < list2.length && i <= minIndexSum; i++) {
            Integer index = indexMap.get(list2[i]);
            if (index != null) {
                int sum = index + i;
                if (sum == minIndexSum) {
                    results.add(list2[i]);
                } else if (sum < minIndexSum) {
                    results.clear();
                    results.add(list2[i]);
                    minIndexSum = sum;
                }
            }
        }

        return results.toArray(String[]::new);
    }
}
