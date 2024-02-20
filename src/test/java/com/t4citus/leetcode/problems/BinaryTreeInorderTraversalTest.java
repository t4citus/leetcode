package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

@Leetcode(
        title = "94. Binary Tree Inorder Traversal",
        url = "https://leetcode.com/problems/binary-tree-inorder-traversal/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BinaryTreeInorderTraversalTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)), List.of(1, 3, 2)),
                Arguments.of(null, Collections.emptyList()),
                Arguments.of(new TreeNode(1), List.of(1)),
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), List.of(4, 2, 5, 1, 6, 3, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> inOrder = inorderTraversal(root);

        // Then
        System.out.println("inorderTraversal(" + TreeNode.toString(root) + ") = " + inOrder);
        Assertions.assertThat(inOrder).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> inOrder = inorderTraversalIt(root);

        // Then
        System.out.println("inorderTraversalIt(" + TreeNode.toString(root) + ") = " + inOrder);
        Assertions.assertThat(inOrder).isEqualTo(expectedOutput);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        inorderTraversal(root, l);
        return l;
    }

    /**
     * Recursive inorder traversal of a binary tree.
     */
    public void inorderTraversal(TreeNode root, List<Integer> l) {
        if (root == null) return;
        inorderTraversal(root.left, l);
        l.add(root.val);
        inorderTraversal(root.right, l);
    }

    /**
     * Iterative inorder traversal of a binary tree.
     */
    public List<Integer> inorderTraversalIt(TreeNode root) {
        List<Integer> inOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while (true) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                if (stack.isEmpty()) break;
                curr = stack.pop();
                inOrder.add(curr.val);
                curr = curr.right;
            }
        }

        return inOrder;
    }
}
