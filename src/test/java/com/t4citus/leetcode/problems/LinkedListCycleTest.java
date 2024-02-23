package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "141. Linked List Cycle",
        url = "https://leetcode.com/problems/linked-list-cycle/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class LinkedListCycleTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 0, -4}, 1, true),
                Arguments.of(new int[]{1, 2}, 0, true),
                Arguments.of(new int[]{1}, -1, false),
                Arguments.of(new int[]{1, 1, 1, 1}, -1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int pos, boolean expectedOutput) {
        // Given
        ListNode head = createNodes(input, pos);
        // String headString = toString(head);

        // When
        boolean hasCycle = hasCycle(head);

        // Then
        System.out.println("hasCycle(" + Arrays.toString(input) + ") = " + hasCycle);
        Assertions.assertThat(hasCycle).isEqualTo(expectedOutput);
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow != null && fast != null && slow == fast)
                return true;
        }

        return false;
    }

    /**
     * The ints array contains all the elements to be converted into ListNodes. In case pos >= 0 the last element
     * is referencing back the element at index 'pos'. Note that 'pos' is 0-indexed.
     */
    static ListNode createNodes(int[] ints, int pos) {
        ListNode[] nodes = Arrays.stream(ints).mapToObj(ListNode::new).toArray(ListNode[]::new);

        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Create the loop
        if (pos >= 0) {
            nodes[nodes.length - 1].next = nodes[pos];
        }

        return nodes[0];
    }
}
