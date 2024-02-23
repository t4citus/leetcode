package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "19. Remove Nth Node From End of List",
        url = "https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/",
        difficulty = Leetcode.Difficulty.EASY
)
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
        String headString = ListNode.toString(head);
        ListNode removed = removeNthFromEnd(head, n);

        // Then
        System.out.println("removeNthFromEnd(" + headString + ") = " + ListNode.toString(removed));
        Assertions.assertThat(ListNode.equals(removed, toListNodes(expectedOutput))).isTrue();
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
