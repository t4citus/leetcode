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
        title = "706. Design HashMap",
        url = "https://leetcode.com/problems/design-hashmap/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class DesignHashMapTest extends AbstractTestBase {

    @Test
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected() {
        // Given
        MyHashMap map = new MyHashMap();

        // When

        // Then
        int value;

        map.put(1, 1); // The map is now [[1,1]]
        Assertions.assertThat(map.get(1)).isEqualTo(1);

        map.put(2, 2); // The map is now [[1,1], [2,2]]
        Assertions.assertThat(map.get(2)).isEqualTo(2);

        value = map.get(1); // return 1, The map is now [[1,1], [2,2]]
        Assertions.assertThat(value).isEqualTo(1);

        value = map.get(3); // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        Assertions.assertThat(value).isEqualTo(-1);

        map.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        Assertions.assertThat(map.get(2)).isEqualTo(1);

        value = map.get(2); // return 1, The map is now [[1,1], [2,1]]
        Assertions.assertThat(value).isEqualTo(1);

        map.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        map.get(2); // return -1 (i.e., not found), The map is now [[1,1]]
        Assertions.assertThat(map.get(2)).isEqualTo(-1);
    }

    public static class MyHashMap {

        private final int[] data = new int[1000001];

        public MyHashMap() {
        }

        public void put(int key, int value) {
            // Since the values range is considered to be 0 <= value <= 10^6, the '0' (initial value of the array) is
            // read as a '-1'. So all values will be increased by one on insert and decreased on removal.
            data[key] = value + 1;
        }

        public int get(int key) {
            return data[key] - 1;
        }

        public void remove(int key) {
            data[key] = 0;
        }
    }
}
