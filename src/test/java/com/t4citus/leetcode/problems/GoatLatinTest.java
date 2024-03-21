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
        title = "824. Goat Latin",
        url = "https://leetcode.com/problems/goat-latin/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class GoatLatinTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        "I speak Goat Latin",
                        "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
                ),
                Arguments.of(
                        "The quick brown fox jumped over the lazy dog",
                        "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(String sentence, String expectedGoatLatin) {
        // Given

        // When
        String goatLatin = toGoatLatin(sentence);

        // Then
        System.out.println("toGoatLatin(" + sentence + ") = " + goatLatin);
        Assertions.assertThat(goatLatin).isEqualTo(expectedGoatLatin);
    }

    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        int repeat = 1, remaining = words.length;

        for (String word : words) {
            if (isVowel(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1));
                sb.append(word.charAt(0));
            }
            sb.append("ma");
            sb.append("a".repeat(repeat++));
            if (--remaining > 0) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

    public static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
