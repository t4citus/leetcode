package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "482. License Key Formatting",
        url = "https://leetcode.com/problems/license-key-formatting/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LicenseKeyFormattingTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("5F3Z-2e-9-w", 4, "5F3Z-2E9W"),
                Arguments.of("2-5g-3-J", 2, "2-5G-3J"),
                Arguments.of("2-4A0r7-4k", 4, "24A0-R74K"),
                Arguments.of("a-a-a-a-", 1, "A-A-A-A")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String s, int k, String expectedLicenseKey) {
        // Given

        // When
        String licenceKey = licenseKeyFormatting(s, k);

        // Then
        System.out.println("licenseKeyFormatting(" + s + ", " + k + ") = " + licenceKey);
        Assertions.assertThat(licenceKey).isEqualTo(expectedLicenseKey);
    }

    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != '-') {
                if (len == 0 && sb.length() > 0) {
                    sb.append('-');
                }
                sb.append(Character.isLowerCase(ch) ? Character.toUpperCase(ch) : ch);
                len++;
                if (len == k) {
                    len = 0;
                }
            }
        }

        return sb.reverse().toString();
    }
}
