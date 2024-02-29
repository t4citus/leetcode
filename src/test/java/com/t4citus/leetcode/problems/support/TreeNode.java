package com.t4citus.leetcode.problems.support;

import com.t4citus.leetcode.problems.BinaryTreeInorderTraversalTest;
import com.t4citus.leetcode.problems.MinimumDepthOfBinaryTreeTest;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

@NoArgsConstructor
@ToString
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Prints the binary tree with preorder traversal.
     */
    public static String toString(TreeNode root) {
        List<Integer> values = new ArrayList<>();

        if (root != null) {
            // Print in BFS order
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode curr = queue.poll();
                values.add(curr.val);
                if (curr.left != null || curr.right != null) {
                    queue.add(curr.left != null ? curr.left : new TreeNode(0));
                    queue.add(curr.right != null ? curr.right : new TreeNode(0));
                }

//                if (curr.left != null) queue.add(curr.left);
//                if (curr.right != null) queue.add(curr.right);
            }
        }
        return values.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
    }

    public static boolean equals(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;

        if(left != null && right != null) {
            return left.val == right.val
                    && equals(left.left, right.left)
                    && equals(left.right, right.right);
        }

        return false;
    }
}
