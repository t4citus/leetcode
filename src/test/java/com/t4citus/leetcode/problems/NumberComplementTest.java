package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "476. Number Complement",
        url = "https://leetcode.com/problems/number-complement/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class NumberComplementTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(5, 2),
                Arguments.of(1, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int num, int expectedOutput) {
        // Given

        // When
        int complement = findComplement(num);

        // Then
        System.out.println("findComplement(" + num + ") = " + complement);
        Assertions.assertThat(complement).isEqualTo(expectedOutput);
    }

    public int findComplement(int num) {
        int complement = 0;
        int mult = 1;

        while (num > 0) {
            int bit = num % 2;
            if (bit == 0) {
                complement += mult;
            }
            num /= 2;
            mult *= 2;
        }

        return complement;
    }
}
