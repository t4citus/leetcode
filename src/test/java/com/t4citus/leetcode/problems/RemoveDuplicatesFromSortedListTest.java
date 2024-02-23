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
        title = "83. Remove Duplicates from Sorted List",
        url = "https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class RemoveDuplicatesFromSortedListTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1,1,2}, new int[]{1,2}),
                Arguments.of(new int[]{1,1,2}, new int[]{1,2})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] input, int[] expectedOutput) {
        // Given
        ListNode head = ListNode.createNodes(input);
        String headString = ListNode.toString(head);
        ListNode expectedHead = ListNode.createNodes(expectedOutput);

        // When
        ListNode deleted = deleteDuplicates(head);

        // Then
        System.out.println("deleteDuplicates(" + headString + ") = " + ListNode.toString(deleted));
        Assertions.assertThat(ListNode.equals(deleted, expectedHead)).isTrue();
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode curr = head;

        while (curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
}
