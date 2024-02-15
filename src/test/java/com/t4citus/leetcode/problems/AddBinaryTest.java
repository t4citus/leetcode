package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "67. Add Binary",
        url = "https://leetcode.com/problems/add-binary/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class AddBinaryTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("11", "1", "100"),
                Arguments.of("1010", "1011", "10101"),
                Arguments.of("0", "111", "111"),
                Arguments.of("111", "0", "111")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String a, String b, String expectedOutput) {
        // Given

        // When
        String sum = addBinary(a, b);

        // Then
        System.out.println("addBinary(" + a + ", " + b + ") = " + sum);
        Assertions.assertThat(sum).isEqualTo(expectedOutput);
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        final int zero = '0'; // ASCII-code for '0'

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i) - zero;
            if (j >= 0)
                sum += b.charAt(j) - zero;
            sb.insert(0, sum % 2);
            carry = sum / 2;
            i -= 1;
            j -= 1;
        }
        if (carry == 1)
            sb.insert(0, carry);

        return sb.toString();
    }
}
