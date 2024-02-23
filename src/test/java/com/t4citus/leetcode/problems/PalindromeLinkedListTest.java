package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Leetcode(
        title = "234. Palindrome Linked List",
        url = "https://leetcode.com/problems/palindrome-linked-list/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PalindromeLinkedListTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1)))), true),
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4)))), false),
                Arguments.of(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(2, new ListNode(1))))), true),
                Arguments.of(new ListNode(1, new ListNode(2)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(ListNode head, boolean expectedOutput) {
        // Given

        // When
        String headPrintable = ListNode.toString(head);
        boolean isPalindrome = isPalindrome(head);

        // Then
        System.out.println("isPalindrome(" + headPrintable + ") = " + isPalindrome);
        Assertions.assertThat(isPalindrome).isEqualTo(expectedOutput);
    }

    public boolean isPalindromeWithArrayList(ListNode head) {
        if (head.next == null)
            return true;

        List<Integer> list = new ArrayList<>();
        ListNode node = head;

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int size = list.size();
        for (int i = 0; i < (size - 1 - i); i++) {
            if (!Objects.equals(list.get(i), list.get(size - 1 - i)))
                return false;
        }

        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;

            // reverse while moving slow pointer
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // move slow pointer in case the length of the list is uneven
        if (fast != null) {
            slow = slow.next;
        }

        while (prev != null && slow != null) {
            if (prev.val != slow.val)
                return false;
            prev = prev.next;
            slow = slow.next;
        }

        return true;
    }
}
