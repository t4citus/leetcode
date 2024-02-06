package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedListsTest extends AbstractTestBase {

    @Test
    public void givenTestCase_whenMergeTwoLists_thenReturnsAsExpected() {
        // Given
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        // When
        ListNode merged = mergeTwoLists(list1, list2);

        // Then
        print(list1);
        print(list2);
        print(merged);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode node = list1;
        while (node != null) {
            int val = node.val;


            node = node.next;
        }
        return list1;
    }

    public ListNode mergeTwoListsWithRecursion(ListNode list1, ListNode list2) {
        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoListsWithRecursion(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoListsWithRecursion(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }

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

    private static void print(ListNode list) {
        if (list == null) {
            System.out.println("[]");
            return;
        }
        List<Integer> newList = new ArrayList<>();
        ListNode node = list;
        while (node != null) {
            newList.add(node.val);
            node = node.next;
        }
        System.out.println(newList);
    }
}
