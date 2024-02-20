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
        title = "965. Univalued Binary Tree",
        url = "https://leetcode.com/problems/univalued-binary-tree/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class UnivaluedBinaryTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1))), true),
                Arguments.of(new TreeNode(2, new TreeNode(2, new TreeNode(5), new TreeNode(2)), new TreeNode(2)), false),
                Arguments.of(new TreeNode(9, new TreeNode(9, new TreeNode(9), new TreeNode(9)), new TreeNode(6)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, boolean expectedOutput) {
        // Given

        // When
        boolean isUnivalued = isUnivalTree(root);

        // Then
        System.out.println("isUnivalTree(" + TreeNode.toString(root) + ") = " + isUnivalued);
        Assertions.assertThat(isUnivalued).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, boolean expectedOutput) {
        // Given

        // When
        boolean isUnivalued = isUnivalTreeIt(root);

        // Then
        System.out.println("isUnivalTreeIt(" + TreeNode.toString(root) + ") = " + isUnivalued);
        Assertions.assertThat(isUnivalued).isEqualTo(expectedOutput);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        return isUnivalTree(root, root.val);
    }

    public boolean isUnivalTree(TreeNode root, int val) {
        if (root == null) return true;
        if (root.val != val) return false;
        return isUnivalTree(root.left, val) && isUnivalTree(root.right, val);
    }

    public boolean isUnivalTreeIt(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = root.val;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.val != val) return false;
            if (curr.left != null) queue.add(curr.left);
            if (curr.right != null) queue.add(curr.right);
        }

        return true;
    }
}
