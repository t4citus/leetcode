package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

@Leetcode(
        title = "929. Unique Email Addresses",
        url = "https://leetcode.com/problems/unique-email-addresses/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class UniqueEmailAddressesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"},
                        2
                ),
                Arguments.of(
                        new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"},
                        3
                ),
                Arguments.of(
                        new String[]{"a@e+c.com", "a@e+c+f.com"},
                        2
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String[] emails, int expectedCount) {
        // Given

        // When
        int count = numUniqueEmails(emails);

        // Then
        System.out.println("numUniqueEmails(" + Arrays.toString(emails) + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedCount);
    }

    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();

        for (String email : emails) {
            int sign = email.indexOf('@');
            int plus = email.indexOf('+');

            String localName = (plus != -1 && plus < sign) ? email.substring(0, plus) : email.substring(0, sign);
            String domainName = email.substring(sign + 1);

            if (localName.indexOf('.') != -1) {
                localName = localName.replace(".", "");
            }

            unique.add(localName + "@" + domainName);
        }

        return unique.size();
    }
}
