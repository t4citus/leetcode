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
        title = "203. Remove Linked List Elements",
        url = "https://leetcode.com/problems/remove-linked-list-elements/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RemoveLinkedListElementsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 6, 3, 4, 5, 6}, 6, new int[]{1, 2, 3, 4, 5}),
                Arguments.of(null, 1, null),
                Arguments.of(new int[]{7, 7, 7, 7}, 7, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(int[] ints, int val, int[] expectedOutput) {
        // Given
        ListNode head = ListNode.createNodes(ints);
        ListNode expectedHead = ListNode.createNodes(expectedOutput);

        // When
        ListNode removedHead = removeElements(head, val);

        // Then
        System.out.println("removeElements(" + ListNode.toString(head) + ") = " + ListNode.toString(removedHead));
        Assertions.assertThat(ListNode.equals(removedHead, expectedHead)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(int[] ints, int val, int[] expectedOutput) {
        // Given
        ListNode head = ListNode.createNodes(ints);
        ListNode expectedHead = ListNode.createNodes(expectedOutput);

        // When
        ListNode removedHead = removeElementsIt(head, val);

        // Then
        System.out.println("removeElementsIt(" + ListNode.toString(head) + ") = " + ListNode.toString(removedHead));
        Assertions.assertThat(ListNode.equals(removedHead, expectedHead)).isTrue();
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;

        // If the value matches, move to the next item.
        if (head.val == val) {
            return removeElements(head.next, val);
        }

        head.next = removeElements(head.next, val);
        return head;
    }

    public ListNode removeElementsIt(ListNode head, int val) {
        if (head == null) return null;

        ListNode newHead = new ListNode(-1);
        ListNode newCurr = newHead;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val != val) {
                newCurr.next = curr;
                newCurr = newCurr.next;
            }
            curr = curr.next;
        }

        newCurr.next = null;

        return newHead.val == -1 && newHead.next == null ? null : newHead.next;
    }
}
