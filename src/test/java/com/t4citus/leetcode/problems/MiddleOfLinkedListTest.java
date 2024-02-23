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
        ListNode head = ListNode.createNodes(input);
        ListNode expected = ListNode.createNodes(expectedOutput);

        // When
        ListNode middle = middleNode(head);

        // Then
        System.out.println("middleNode(" + ListNode.toString(head) + ") = " + ListNode.toString(expected));
        Assertions.assertThat(ListNode.equals(middle, expected)).isTrue();
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
}
