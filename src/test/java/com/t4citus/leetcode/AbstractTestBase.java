package com.t4citus.leetcode;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public abstract class AbstractTestBase {

    public static boolean equals(int[] left, int[] right) {
        if (left.length != right.length) {
            return false;
        }
        for (int i = 0; i < left.length; i++) {
            if (left[i] != right[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(int[][] left, int[][] right) {
        if (left.length != right.length) {
            return false;
        }
        for (int i = 0; i < left.length; i++) {
            if (!equals(left[i], right[i])) {
                return false;
            }
        }
        return true;
    }
}
