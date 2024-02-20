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
        title = "101. Symmetric Tree",
        url = "https://leetcode.com/problems/symmetric-tree/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SymmetricTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3))), true),
                Arguments.of(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3))), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, boolean expectedOutput) {
        // Given

        // When
        boolean isSymmetric = isSymmetric(root);

        // Then
        System.out.println("isSymmetric(" + TreeNode.toString(root) + ") = " + isSymmetric);
        Assertions.assertThat(isSymmetric).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, boolean expectedOutput) {
        // Given

        // When
        boolean isSymmetric = isSymmetricIt(root);

        // Then
        System.out.println("isSymmetricIt(" + TreeNode.toString(root) + ") = " + isSymmetric);
        Assertions.assertThat(isSymmetric).isEqualTo(expectedOutput);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) return true;
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
//        if (leftNode.val != rightNode.val) return false;
        return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
    }

    public boolean isSymmetricIt(TreeNode root) {
        if (root == null) return false;

        // The queue will hold the node in a non-linear order.
        // Order: leftNode.left, rightNode.right, leftNode.right, rightNode.left
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();

            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            queue.add(leftNode.left);
            queue.add(rightNode.right);
            queue.add(leftNode.right);
            queue.add(rightNode.left);
        }

        return true;
    }
}
