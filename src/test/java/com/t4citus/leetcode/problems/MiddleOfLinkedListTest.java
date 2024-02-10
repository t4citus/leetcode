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
        title = "876. Middle of the Linked List",
        url = "https://leetcode.com/problems/middle-of-the-linked-list/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MiddleOfLinkedListTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5}),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6}, new int[]{4, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given
        ListNode head = nodes(input);
        ListNode expected = nodes(expectedOutput);

        // When
        ListNode middle = middleNode(head);

        // Then
        System.out.println("middleNode(" + toString(head) + ") = " + toString(expected));
        Assertions.assertThat(equals(middle, expected)).isTrue();
    }

    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
