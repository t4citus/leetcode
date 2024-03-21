package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Leetcode(
        title = "598. Range Addition II",
        url = "https://leetcode.com/problems/range-addition-ii/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RangeAddition1Test extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(3, 3, ops(op(2, 2), op(3, 3)), 4),
                Arguments.of(3, 3, ops(op(2, 2), op(3, 3), op(3, 3), op(3, 3), op(2, 2), op(3, 3), op(3, 3), op(3, 3), op(2, 2), op(3, 3), op(3, 3), op(3, 3)), 4),
                Arguments.of(3, 3, new int[0][0], 9)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int m, int n, int[][] ops, int expectedMaxCount) {
        // Given

        // When
        int maxCount = maxCount(m, n, ops);

        // Then
        System.out.println("maxCount(" + m + ", " + n + ", " + opsToString(ops) + ") = " + maxCount);
        Assertions.assertThat(maxCount).isEqualTo(expectedMaxCount);
    }

    public int maxCount(int m, int n, int[][] ops) {
        int minM = m;
        int minN = n;

        for (int[] op : ops) {
            if (op[0] < minM) minM = op[0];
            if (op[1] < minN) minN = op[1];
        }

        return minM * minN;
    }

    private static int[] op(int... values) {
        return values;
    }

    private static int[][] ops(int[]... values) {
        return values;
    }

    private static String opsToString(int[][] ops) {
        return Arrays.stream(ops)
                .map(Arrays::toString)
                .collect(Collectors.joining(",", "[", "]"));
    }
}
