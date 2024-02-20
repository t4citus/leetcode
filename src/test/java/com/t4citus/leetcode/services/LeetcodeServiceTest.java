package com.t4citus.leetcode.services;

import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.dto.LeetcodeInfoDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

@SpringBootTest
public class LeetcodeServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LeetcodeServiceTest.class);

    @Autowired
    public LeetcodeService leetcodeService;

    @Test
    public void givenNoParameter_whenGetInfoList_thenReturnsNonEmptyList() throws IOException {
        // Given

        // When
        List<LeetcodeInfoDto> infoList = leetcodeService.getInfoList();

        // Then
        Assertions.assertThat(infoList).isNotNull();
        Assertions.assertThat(infoList.isEmpty()).isFalse();

        infoList.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(ints = {704, 226, 21, 1929})
    public void givenNumber_whenGetInfoList_thenReturnsNonEmptyList(Integer number) throws IOException {
        // Given

        // When
        List<LeetcodeInfoDto> infoList = leetcodeService.getInfoList(number, null, null);

        // Then
        Assertions.assertThat(infoList).isNotNull();
        infoList.forEach(info -> Assertions.assertThat(info.getNumber()).isEqualTo(number));

        infoList.forEach(System.out::println);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Tree", "Remove", "List"})
    public void givenTitle_whenGetInfoList_thenReturnsNonEmptyList(String title) throws IOException {
        // Given

        // When
        List<LeetcodeInfoDto> infoList = leetcodeService.getInfoList(null, title, null);

        // Then
        Assertions.assertThat(infoList).isNotNull();
        infoList.forEach(info -> Assertions.assertThat(info.getTitle()).contains(title));

        infoList.forEach(System.out::println);
    }

    private static Stream<Arguments> difficultyTestCases() {
        return Stream.of(
                Arguments.of(Leetcode.Difficulty.EASY)
        );
    }

    @ParameterizedTest
    @MethodSource("difficultyTestCases")
    public void givenDifficultyTestCase_whenGetInfoList_thenReturnsNonEmptyList(Leetcode.Difficulty difficulty) throws IOException {
        // Given

        // When
        List<LeetcodeInfoDto> infoList = leetcodeService.getInfoList(null, null, difficulty);

        // Then
        Assertions.assertThat(infoList).isNotNull();
        infoList.forEach(info -> Assertions.assertThat(info.getDifficulty()).isEqualTo(difficulty));

        infoList.forEach(System.out::println);
    }
}