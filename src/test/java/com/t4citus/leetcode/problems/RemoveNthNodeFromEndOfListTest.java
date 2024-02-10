package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import lombok.ToString;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class RemoveNthNodeFromEndOfListTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 2, new int[]{1, 2, 3, 5}),
                Arguments.of(new int[]{1}, 1, new int[]{}),
                Arguments.of(new int[]{1, 2}, 2, new int[]{2}),
                Arguments.of(new int[]{1, 2}, 1, new int[]{1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int n, int[] expectedOutput) {
        // Given
        ListNode head = toListNodes(input);

        // When
        String headString = toString(head);
        ListNode removed = removeNthFromEnd(head, n);

        // Then
        System.out.println("removeNthFromEnd(" + headString + ") = " + toString(removed));
        Assertions.assertThat(equals(removed, toListNodes(expectedOutput))).isTrue();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    @ToString
    public static class ListNode {
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

    static String toString(ListNode head) {
        if (head == null)
            return null;

        List<Integer> values = new ArrayList<>();
        ListNode next = head;

        while (next != null) {
            values.add(next.val);
            next = next.next;
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

    static ListNode toListNodes(int[] arr) {
        if (arr.length == 0)
            return null;

        ListNode head = null;
        ListNode curr = null;

        for (int i : arr) {
            ListNode next = new ListNode(i);

            if (curr == null) {
                curr = next;
            } else {
                curr.next = next;
                curr = next;
            }

            if (head == null) {
                head = curr;
            }
        }

        return head;
    }
}
