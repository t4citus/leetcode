package com.t4citus.leetcode.dto;

import com.t4citus.leetcode.annotations.Leetcode;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class LeetcodeInfoDto {
    private Integer number;
    private String title;
    private String url;
    private Leetcode.Difficulty difficulty;
}
