package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "443. String Compression",
        url = "https://leetcode.com/problems/string-compression/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class StringCompressionTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}, 6),
                Arguments.of(new char[]{'a'}, 1),
                Arguments.of(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}, 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(char[] chars, int expectedCompressedLength) {
        // Given
        String charsString = Arrays.toString(chars);

        // When
        int compressedLength = compress(chars);

        // Then
        System.out.println("compress(" + charsString + ") = " + compressedLength);
        Assertions.assertThat(compressedLength).isEqualTo(expectedCompressedLength);
    }

    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int size = 1;
        char curr = chars[0];

        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1) {
                sb.append(curr);
                if (size > 1) sb.append(size);
            } else if (chars[i + 1] != curr) {
                sb.append(curr);
                if (size > 1) sb.append(size);
                curr = chars[i + 1];
                size = 1;
            } else {
                size++;
            }
        }

        char[] newChars = sb.toString().toCharArray();
        for (int i = 0; i < newChars.length; i++) {
            chars[i] = newChars[i];
        }

        return newChars.length;
    }
}
