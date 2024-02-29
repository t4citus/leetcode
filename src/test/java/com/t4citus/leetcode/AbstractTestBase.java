package com.t4citus.leetcode;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.Objects;

@SpringBootTest
public abstract class AbstractTestBase {

    public static class IntUtil {
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

    public static class StringUtil {
        public static boolean equals(String[] left, String[] right) {
            if (left.length != right.length) {
                return false;
            }
            for (int i = 0; i < left.length; i++) {
                if (!Objects.equals(left[i], right[i])) {
                    return false;
                }
            }
            return true;
        }
    }
}
