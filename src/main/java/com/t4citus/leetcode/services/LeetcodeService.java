package com.t4citus.leetcode.services;

import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.dto.LeetcodeInfoDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class LeetcodeService {

    private static final String packageName = "com.t4citus.leetcode.problems";

    public LeetcodeService() {
    }

    public List<LeetcodeInfoDto> getInfoList(Integer numberFilter, String titleFilter, Leetcode.Difficulty difficultyFilter) throws IOException {
        ImmutableSet<ClassPath.ClassInfo> topLevelClasses = ClassPath.from(ClassLoader.getSystemClassLoader())
                .getTopLevelClasses(packageName);

        List<LeetcodeInfoDto> infoList = new ArrayList<>();

        for (ClassPath.ClassInfo topLevelClass : topLevelClasses) {
            Class<?> clazz = topLevelClass.load();
            Leetcode leetcode = clazz.getAnnotation(Leetcode.class);
            if (leetcode != null) {
                Integer number = null;
                if (leetcode.title() != null) {
                    try {
                        number = Integer.parseInt(leetcode.title().split("[.]")[0]);
                    } catch (Exception e) {
                        // Unable to parse number (not worth to log).
                    }
                }
                if (numberFilter != null && !numberFilter.equals(number)) {
                    continue;
                }
                if (titleFilter != null && leetcode.title() != null && !leetcode.title().contains(titleFilter)) {
                    continue;
                }
                if (difficultyFilter != null && difficultyFilter != leetcode.difficulty()) {
                    continue;
                }
                infoList.add(LeetcodeInfoDto.builder()
                        .number(number)
                        .title(leetcode.title())
                        .url(leetcode.url())
                        .difficulty(leetcode.difficulty())
                        .build());
            }
        }

        sortByTitle(infoList);
        return infoList;
    }

    public List<LeetcodeInfoDto> getInfoList() throws IOException {
        return getInfoList(null, null, null);
    }

    private void sortByTitle(List<LeetcodeInfoDto> infoList) {
        if (infoList != null && !infoList.isEmpty()) {
            infoList.sort(Comparator.comparing(LeetcodeInfoDto::getTitle));
        }
    }
}
