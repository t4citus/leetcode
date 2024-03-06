package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "43. Multiply Strings",
        url = "https://leetcode.com/problems/multiply-strings/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class MultiplyStringsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("2", "3", "6"),
                Arguments.of("123", "456", "56088"),
                Arguments.of("0", "0", "0"),
                Arguments.of("12", "34", "408"),
                Arguments.of("9", "9", "81")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String num1, String num2, String expectedProduct) {
        // Given

        // When
        String product = multiply(num1, num2);

        // Then
        System.out.println("multiply(" + num1 + ", " + num2 + ") = " + product);
        Assertions.assertThat(product).isEqualTo(expectedProduct);
    }

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";

        int m = num1.length(), n = num2.length();
        int[] products = new int[m + n];

        // Multiply each position of both numbers and insert it in reversed order into an array.
        for (int i = 0; i < m; i++) {
            int a = num1.charAt(m - i - 1) - '0';
            for (int j = 0; j < n; j++) {
                products[i + j] += a * (num2.charAt(n - j - 1) - '0');
            }
        }

        // Since the multiplication ended up with numbers greater than '9', the carry needs
        // to get evaluated and shifted to the right of the array if needed.
        int carry = 0;
        for (int i = 0; i < products.length; i++) {
            int tmp = (products[i] + carry) % 10;
            carry = (products[i] + carry) / 10;
            products[i] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int p : products) {
            sb.append(p);
        }

        // Remove all leading zeroes from the end of the string.
        while (sb.length() != 0 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.length() == 0 ? "0" : sb.reverse().toString();
    }
}
