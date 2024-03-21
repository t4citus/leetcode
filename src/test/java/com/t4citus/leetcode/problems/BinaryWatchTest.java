package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "401. Binary Watch",
        url = "https://leetcode.com/problems/binary-watch/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BinaryWatchTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(1, List.of("0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00")),
                Arguments.of(9, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int turnedOn, List<String> expectedTimes) {
        // Given

        // When
        List<String> times = readBinaryWatch(turnedOn);

        // Then
        System.out.println("readBinaryWatch(" + turnedOn + ") = " + times);
        Assertions.assertThat(times).containsExactlyInAnyOrder(expectedTimes.toArray(String[]::new));
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> times = new ArrayList<>();

        for (int h = 0; h <= 11; h++) {
            int hBits = Integer.bitCount(h);
            if (hBits > turnedOn) continue;
            int remain = turnedOn - hBits;

            for (int m = 0; m <= 59; m++) {
                if (remain == Integer.bitCount(m)) {
                    times.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }

        return times;
    }
}
