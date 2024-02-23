package com.t4citus.leetcode.problems.support;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@ToString
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static String toString(ListNode head) {
        if (head == null) {
            return Collections.emptyList().toString();
        }

        List<Integer> values = new ArrayList<>();
        ListNode curr = head;

        while (curr != null) {
            values.add(curr.val);
            curr = curr.next;
        }

        return values.toString();
    }

    public static boolean equals(ListNode left, ListNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }

        while (left != null && right != null) {
            if (left.val != right.val)
                return false;
            left = left.next;
            right = right.next;
        }

        return left == null && right == null;
    }

    public static ListNode createNodes(int[] ints) {
        if (ints == null || ints.length == 0) return null;

        ListNode[] nodes = Arrays.stream(ints).mapToObj(ListNode::new).toArray(ListNode[]::new);
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        return nodes[0];
    }
}
