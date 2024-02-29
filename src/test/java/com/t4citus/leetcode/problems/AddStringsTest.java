package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "415. Add Strings",
        url = "https://leetcode.com/problems/add-strings/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class AddStringsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("11", "123", "134"),
                Arguments.of("456", "77", "533"),
                Arguments.of("0", "0", "0"),
                Arguments.of("1", "9", "10")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String num1, String num2, String expectedOutput) {
        // Given

        // When
        String added = addStrings(num1, num2);

        // Then
        System.out.println("addStrings(" + num1 + ", " + num2 + ") = " + added);
        Assertions.assertThat(added).isEqualTo(expectedOutput);
    }


    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;

            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            carry = sum / 10;
            sum %= 10;
            sb.append((char) (sum + '0'));
        }

        if (carry == 1) {
            sb.append("1");
        }

        return sb.reverse().toString();
    }
}
