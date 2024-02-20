package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

@Leetcode(
        title = "144. Binary Tree Preorder Traversal",
        url = "https://leetcode.com/problems/binary-tree-preorder-traversal/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BinaryTreePreorderTraversalTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)), List.of(1, 2, 3)),
                Arguments.of(null, Collections.emptyList()),
                Arguments.of(new TreeNode(1), List.of(1)),
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), List.of(1, 2, 4, 5, 3, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> preOrder = preorderTraversal(root);

        // Then
        System.out.println("preorderTraversal(" + TreeNode.toString(root) + ") = " + preOrder);
        Assertions.assertThat(preOrder).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> preOrder = preorderTraversalIt(root);

        // Then
        System.out.println("preorderTraversalIt(" + TreeNode.toString(root) + ") = " + preOrder);
        Assertions.assertThat(preOrder).isEqualTo(expectedOutput);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        preorderTraversal(root, l);
        return l;
    }

    /**
     * Recursive preorder traversal of a binary tree.
     */
    public void preorderTraversal(TreeNode root, List<Integer> l) {
        if (root == null) return;
        l.add(root.val);
        preorderTraversal(root.left, l);
        preorderTraversal(root.right, l);
    }

    /**
     * Iterative preorder traversal of a binary tree.
     */
    public List<Integer> preorderTraversalIt(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> preOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;

        while (!stack.isEmpty()) {
            curr = stack.pop();
            preOrder.add(curr.val);
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }

        return preOrder;
    }
}
