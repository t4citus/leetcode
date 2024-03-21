package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "468. Validate IP Address",
        url = "https://leetcode.com/problems/validate-ip-address/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class ValidateIpAddressTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("172.16.254.1", "IPv4"),
                Arguments.of("2001:0db8:85a3:0:0:8A2E:0370:7334", "IPv6"),
                Arguments.of("256.256.256.256", "Neither"),
                Arguments.of("2001:0db8:85a3:0:0:8A2E:0370:7334:", "Neither"),
                Arguments.of("192.0.0.1", "IPv4")
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String queryIp, String expectedAddressType) {
        // Given

        // When
        String addressType = validIPAddress(queryIp);

        // Then
        System.out.println("validIPAddress(" + queryIp + ") = " + addressType);
        Assertions.assertThat(addressType).isEqualTo(expectedAddressType);
    }

    public String validIPAddress(String queryIP) {
        if (queryIP.contains(".") && checkIpv4(queryIP)) {
            return "IPv4";
        }

        if (queryIP.contains(":") && checkIpv6(queryIP)) {
            return "IPv6";
        }

        return "Neither";
    }

    public static boolean checkIpv4(String ipAddress) {
        if (ipAddress.charAt(0) == '.' || ipAddress.charAt(ipAddress.length() - 1) == '.') return false;
        String[] parts = ipAddress.split("\\.");
        if (parts.length != 4) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 3) return false;
            if (part.charAt(0) == '0' && part.length() > 1) return false;

            int val = 0, mult = 1;
            for (int i = part.length() - 1; i >= 0; i--) {
                int ch = part.charAt(i) - '0';
                if (ch < 0 || ch > 9) return false;
                val += ch * mult;
                mult *= 10;
            }

            if (val < 0 || val > 255) return false;
        }

        return true;
    }

    public static boolean checkIpv6(String ipAddress) {
        if (ipAddress.charAt(0) == ':' || ipAddress.charAt(ipAddress.length() - 1) == ':') return false;
        String[] parts = ipAddress.split(":");
        if (parts.length != 8) return false;

        for (String part : parts) {
            if (part.length() == 0 || part.length() > 4) return false;

            for (int i = 0; i < part.length(); i++) {
                char ch = part.charAt(i);
                if (!((ch >= 48 && ch <= 57) || (ch >= 65 && ch <= 70) || (ch >= 97 && ch <= 102))) return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        String s = "255";
        System.out.println(s.charAt(s.length() - 1) - '0');
    }
}
