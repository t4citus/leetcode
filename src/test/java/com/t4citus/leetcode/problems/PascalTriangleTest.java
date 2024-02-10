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
import java.util.Objects;
import java.util.stream.Stream;

@Leetcode(
        title = "118. Pascal's Triangle",
        url = "https://leetcode.com/problems/pascals-triangle/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PascalTriangleTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(5, Arrays.asList(Arrays.asList(1), Arrays.asList(1, 1), Arrays.asList(1, 2, 1), Arrays.asList(1, 3, 3, 1), Arrays.asList(1, 4, 6, 4, 1))),
                Arguments.of(1, Arrays.asList(Arrays.asList(1)))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int input, List<List<Integer>> expectedOutput) {
        // Given

        // When
        List<List<Integer>> pascalTriangle = generate(input);

        // Then
        System.out.println("pascalTriangle(" + input + ") = " + printInline(pascalTriangle));
        Assertions.assertThat(areListsEqual(pascalTriangle, expectedOutput)).isTrue();
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(List.of(1));

        if (numRows == 1)
            return pascalTriangle;

        // Create lines
        for (int i = 1; i < numRows; i++) {
            List<Integer> line = new ArrayList<>();
            line.add(1);

            List<Integer> last = pascalTriangle.get(i - 1);
            for (int j = 1; j < last.size(); j++) {
                line.add(last.get(j - 1) + last.get(j));
            }

            line.add(1);
            pascalTriangle.add(line);
        }

        return pascalTriangle;
    }

    private static String printInline(List<List<Integer>> l) {
        return l.toString();
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
