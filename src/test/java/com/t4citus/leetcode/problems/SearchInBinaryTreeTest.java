package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@Leetcode(
        title = "700. Search in a Binary Search Tree",
        url = "https://leetcode.com/problems/search-in-a-binary-search-tree/description/Lor",
        difficulty = Leetcode.Difficulty.EASY
)
public class SearchInBinaryTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 2, new TreeNode(2, new TreeNode(1), new TreeNode(3))),
                Arguments.of(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 5, null)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, int val, TreeNode expectedOutput) {
        // Given

        // When
        TreeNode treeNode = searchBST(root, val);
        System.out.println(TreeNode.toString(treeNode));

        // Then
        System.out.println("searchBST(" + TreeNode.toString(root) + ", " + val + ") = " + TreeNode.toString(expectedOutput));
        Assertions.assertThat(equals(treeNode, expectedOutput)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, int val, TreeNode expectedOutput) {
        // Given

        // When
        TreeNode treeNode = searchBSTIt(root, val);

        // Then
        System.out.println("searchBSTIt(" + TreeNode.toString(root) + ", " + val + ") = " + TreeNode.toString(expectedOutput));
        Assertions.assertThat(equals(treeNode, expectedOutput)).isTrue();
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;

        if (val < root.val && root.left != null)
            return searchBST(root.left, val);

        if (val > root.val && root.right != null)
            return searchBST(root.right, val);

        return null;
    }

    public TreeNode searchBSTIt(TreeNode root, int val) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val == val) return curr;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        return null;
    }

    public boolean equals(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) return true;
        if (leftTree != null && rightTree != null) {
            return leftTree.val == rightTree.val
                    && equals(leftTree.left, rightTree.left)
                    && equals(leftTree.right, rightTree.right);
        }
        return false;
    }
}
