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
        title = "506. Relative Ranks",
        url = "https://leetcode.com/problems/relative-ranks/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RelativeRanksTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{5, 4, 3, 2, 1}, new String[]{"Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"}),
                Arguments.of(new int[]{10, 3, 8, 9, 4}, new String[]{"Gold Medal", "5", "Bronze Medal", "Silver Medal", "4"})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] scores, String[] expectedRanks) {
        // Given

        // When
        String[] ranks = findRelativeRanks(scores);

        // Then
        System.out.println("findRelativeRanks(" + Arrays.toString(scores) + ") = " + Arrays.toString(ranks));
        Assertions.assertThat(ranks).isEqualTo(expectedRanks);
    }

    public String[] findRelativeRanks(int[] score) {
        int[] sorted = Arrays.copyOf(score, score.length);
        Arrays.sort(sorted);

        Map<Integer, String> scoreToRank = new HashMap<>();
        int rank = 1;
        for (int i = sorted.length - 1; i >= 0; i--) {
            scoreToRank.put(sorted[i], getRankName(rank++));
        }

        System.out.println(scoreToRank);

        String[] ranks = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            ranks[i] = scoreToRank.get(score[i]);
        }

        return ranks;
    }

    public String getRankName(int rank) {
        if (rank == 1) return "Gold Medal";
        if (rank == 2) return "Silver Medal";
        if (rank == 3) return "Bronze Medal";
        return String.valueOf(rank);
    }
}
