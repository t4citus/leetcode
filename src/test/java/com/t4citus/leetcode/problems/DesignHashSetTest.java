package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

@Leetcode(
        title = "705. Design HashSet",
        url = "https://leetcode.com/problems/design-hashset/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class DesignHashSetTest extends AbstractTestBase {

    @Test
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected() {
        // Given
        MyHashSet set = new MyHashSet();

        // When

        // Then
        boolean contains;

        set.add(1); // set = [1]
        Assertions.assertThat(set.contains(1)).isTrue();

        set.add(2); // set = [1, 2]
        Assertions.assertThat(set.contains(2)).isTrue();

        contains = set.contains(1); // return True
        Assertions.assertThat(contains).isTrue();

        contains = set.contains(3); // return False, (not found)
        Assertions.assertThat(contains).isFalse();

        set.add(2); // set = [1, 2]
        Assertions.assertThat(set.contains(2)).isTrue();

        contains = set.contains(2); // return True
        Assertions.assertThat(contains).isTrue();

        set.remove(2); // set = [1]
        contains = set.contains(2); // return False, (already removed)
        Assertions.assertThat(contains).isFalse();
    }

    public static class MyHashSet {

        private final boolean[] data = new boolean[1000001];

        public MyHashSet() {
        }

        public void add(int key) {
            data[key] = true;
        }

        public void remove(int key) {
            data[key] = false;
        }

        public boolean contains(int key) {
            return data[key];
        }
    }

    public static List<Integer> keys(MyHashSet set) {
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < set.data.length; i++) {
            if (set.data[i]) {
                keys.add(i);
            }
        }
        return keys;
    }
}
