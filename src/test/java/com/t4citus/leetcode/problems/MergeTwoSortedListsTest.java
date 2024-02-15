package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "21. Merge Two Sorted Lists",
        url = "https://leetcode.com/problems/merge-two-sorted-lists/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MergeTwoSortedListsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenMergeTwoLists_thenReturnsAsExpected(int[] ints1, int[] ints2, int[] expectedOutput) {
        // Given
        ListNode list1 = nodes(ints1);
        ListNode list2 = nodes(ints2);
        ListNode expected = nodes(expectedOutput);

        // When
        ListNode merged = mergeTwoLists(list1, list2);

        // Then
        System.out.println("mergeTwoLists(" + toString(list1) + ", " + toString(list2) + ") = " + toString(merged));
        Assertions.assertThat(equals(merged, expected)).isTrue();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ListNode nodes(int[] ints) {
        if (ints == null || ints.length == 0)
            return null;

        ListNode[] nodes = Arrays.stream(ints).mapToObj(ListNode::new).toArray(ListNode[]::new);

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        return nodes[0];
    }

    static String toString(ListNode head) {
        if (head == null)
            return Collections.emptyList().toString();

        List<Integer> values = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        return values.toString();
    }

    static boolean equals(ListNode left, ListNode right) {
        if (left == null && right == null)
            return true;

        if (left == null || right == null)
            return false;

        while (left != null && right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return left == null && right == null;
    }
}
