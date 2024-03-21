package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "925. Long Pressed Name",
        url = "https://leetcode.com/problems/long-pressed-name/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LongPressedNameTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("alex", "aaleex", true),
                Arguments.of("saeed", "ssaaedd", false),
                Arguments.of("xnhtq", "xhhttqq", false),
                Arguments.of("rick", "kric", false),
                Arguments.of("leelee", "lleeelee", true),
                Arguments.of("laiden", "laiden", true),
                Arguments.of("vtkgn", "vttkgnn", true)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String name, String typed, boolean expectedLongPressedName) {
        // Given

        // When
        boolean longPressedName = isLongPressedName(name, typed);

        // Then
        System.out.println("isLongPressedName(" + name + ", " + typed + ") = " + longPressedName);
        Assertions.assertThat(longPressedName).isEqualTo(expectedLongPressedName);
    }

    public boolean isLongPressedName(String name, String typed) {
        if (name.equals(typed)) return true;

        StringBuilder nameBuilder = new StringBuilder(name);
        Character prev = null;
        boolean changed = false;

        for (int i = 0; i < typed.length(); i++) {
            changed = false;
            if (i >= nameBuilder.length()) {
                nameBuilder.append(prev);
                changed = true;
            }
            if (nameBuilder.charAt(i) != typed.charAt(i)) {
                nameBuilder.insert(i, prev);
                changed = true;
            }
            if (changed) {
                if (nameBuilder.charAt(i) != typed.charAt(i)) return false;
                if (typed.contentEquals(nameBuilder)) return true;
            }
            prev = nameBuilder.charAt(i);
        }

        return false;
    }
}
