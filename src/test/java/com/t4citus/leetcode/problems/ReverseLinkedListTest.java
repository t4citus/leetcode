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
        title = "206. Reverse Linked List",
        url = "https://leetcode.com/problems/reverse-linked-list/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ReverseLinkedListTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{5, 4, 3, 2, 1}),
                Arguments.of(new int[]{1, 2}, new int[]{2, 1}),
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given
        ListNode head = ListNode.createNodes(input);
        String headString = ListNode.toString(head);
        ListNode expectedHead = ListNode.createNodes(expectedOutput);

        // When
        ListNode reversed = reverseList(head);

        // Then
        System.out.println("reverseList(" + headString + ") = " + ListNode.toString(reversed));
        Assertions.assertThat(ListNode.equals(reversed, expectedHead)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given
        ListNode head = ListNode.createNodes(input);
        String headString = ListNode.toString(head);
        ListNode expectedHead = ListNode.createNodes(expectedOutput);

        // When
        ListNode reversed = reverseListIt(head);

        // Then
        System.out.println("reverseListIt(" + headString + ") = " + ListNode.toString(reversed));
        Assertions.assertThat(ListNode.equals(reversed, expectedHead)).isTrue();
    }

    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode curr, ListNode prev) {
        if (curr == null) return prev;
        ListNode next = curr.next;
        curr.next = prev;
        return reverseList(next, curr);
    }

    public ListNode reverseListIt(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}
