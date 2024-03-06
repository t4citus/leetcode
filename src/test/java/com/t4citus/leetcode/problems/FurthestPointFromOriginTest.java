package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "2833. Furthest Point From Origin",
        url = "https://leetcode.com/problems/furthest-point-from-origin/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FurthestPointFromOriginTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("L_RL__R", 3),
                Arguments.of("_R__LL_", 5),
                Arguments.of("_______", 7)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String moves, int expectedFurthestDistance) {
        // Given

        // When
        int furthestDistance = furthestDistanceFromOrigin(moves);

        // Then
        System.out.println("furthestDistanceFromOrigin(" + moves + ") = " + furthestDistance);
        Assertions.assertThat(furthestDistance).isEqualTo(expectedFurthestDistance);
    }

    public int furthestDistanceFromOrigin(String moves) {
        int[] counts = new int[3];

        for (char ch : moves.toCharArray()) {
            if (ch == '_') counts[0]++;
            if (ch == 'L') counts[1]++;
            if (ch == 'R') counts[2]++;
        }

        int leftRight = -1 * counts[1] + counts[2]++;
        return Math.abs(leftRight < 0 ? leftRight - counts[0] : leftRight + counts[0]);
    }
}
