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
        title = "145. Binary Tree Postorder Traversal",
        url = "https://leetcode.com/problems/binary-tree-postorder-traversal/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BinaryTreePostorderTraversalTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null)), List.of(3, 2, 1)),
                Arguments.of(null, Collections.emptyList()),
                Arguments.of(new TreeNode(1), List.of(1)),
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7))), List.of(4, 5, 2, 6, 7, 3, 1))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> postOrder = postorderTraversal(root);

        // Then
        System.out.println("postorderTraversal(" + TreeNode.toString(root) + ") = " + postOrder);
        Assertions.assertThat(postOrder).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, List<Integer> expectedOutput) {
        // Given

        // When
        List<Integer> postOrder = postorderTraversalIt(root);

        // Then
        System.out.println("postorderTraversalIt(" + TreeNode.toString(root) + ") = " + postOrder);
        Assertions.assertThat(postOrder).isEqualTo(expectedOutput);
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> l = new ArrayList<>();
        postorderTraversal(root, l);
        return l;
    }

    /**
     * Recursive postorder traversal of a binary tree.
     */
    public void postorderTraversal(TreeNode root, List<Integer> l) {
        if (root == null) return;
        postorderTraversal(root.left, l);
        postorderTraversal(root.right, l);
        l.add(root.val);
    }

    /**
     * Iterative postorder traversal of a binary tree.
     */
    public List<Integer> postorderTraversalIt(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> postOrder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode curr;

        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (curr.left == null && curr.right == null) { // node is leaf
                postOrder.add(curr.val);
                stack.pop();
            } else {
                if (curr.right != null) {
                    stack.push(curr.right);
                    curr.right = null;
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                    curr.left = null;
                }
            }
        }

        return postOrder;
    }
}
