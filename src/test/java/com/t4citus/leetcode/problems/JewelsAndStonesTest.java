package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "771. Jewels and Stones",
        url = "https://leetcode.com/problems/jewels-and-stones/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class JewelsAndStonesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("aA", "aAAbbbb", 3),
                Arguments.of("z", "ZZ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String jewels, String stones, int expectedCount) {
        // Given

        // When
        int count = numJewelsInStones(jewels, stones);

        // Then
        System.out.println("numJewelsInStones(" + jewels + ", " + stones + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }

    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (jewels.indexOf(ch) != -1)
                count += 1;
        }

        return count;
    }
}
