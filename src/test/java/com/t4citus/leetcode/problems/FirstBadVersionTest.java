package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import lombok.AllArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "278. First Bad Version",
        url = "https://leetcode.com/problems/first-bad-version/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class FirstBadVersionTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(5, 4, 4),
                Arguments.of(1, 1, 1),
                Arguments.of(2, 1, 1),
                Arguments.of(2126753390, 1702766719, 1702766719)
        );
    }

    private Api api;

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int n, int bad, int expectedOutput) {
        // Given
        api = new Api(bad);

        // When
        int firstBadVersion = firstBadVersion(n);

        // Then
        System.out.println("firstBadVersion(" + n + ") = " + firstBadVersion);
        Assertions.assertThat(firstBadVersion).isEqualTo(expectedOutput);
    }

    /**
     * The problem assumes that there is an array of n versions [1, 2, ..., n] containing 'good' versions until
     * the first 'bad' version. All subsequent versions will also be 'bad'. So we can assume a sorted list of
     * 'good' and 'bad' versions.
     */
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;

        while (low <= high) {
            // Normally it would be '(low + high) / 2', but '(low + high)' exceeds the int range.
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return high + 1;
    }

    /**
     * The support class simulates an api to support the given method <code>bool isBadVersion(version)</code> with
     * a variable bad version.
     */
    @AllArgsConstructor
    public static class Api {
        private final int badVersion;
    }

    public boolean isBadVersion(int version) {
        return version >= api.badVersion;
    }
}
