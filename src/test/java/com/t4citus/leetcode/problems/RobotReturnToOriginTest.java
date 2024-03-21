package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "657. Robot Return to Origin",
        url = "https://leetcode.com/problems/robot-return-to-origin/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RobotReturnToOriginTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("UD", true),
                Arguments.of("LL", false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String moves, boolean expectedCircle) {
        // Given

        // When
        boolean circle = judgeCircle(moves);

        // Then
        System.out.println("judgeCircle(" + moves + ") = " + circle);
        Assertions.assertThat(circle).isEqualTo(expectedCircle);
    }

    public boolean judgeCircle(String moves) {
        int[] counts = new int[4]; // U, D, L, R

        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U' -> counts[0]++;
                case 'D' -> counts[1]++;
                case 'L' -> counts[2]++;
                case 'R' -> counts[3]++;
            }
        }

        return counts[0] == counts[1] && counts[2] == counts[3];
    }
}
