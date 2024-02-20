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
        title = "104. Maximum Depth of Binary Tree",
        url = "https://leetcode.com/problems/maximum-depth-of-binary-tree/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MaximumDepthOfBinaryTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))), 3),
                Arguments.of(new TreeNode(1, null, new TreeNode(2)), 2),
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5))), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, int expectedMaxDepth) {
        // Given

        // When
        int maxDepth = maxDepth(root);

        // Then
        System.out.println("maxDepth(" + TreeNode.toString(root) + ") = " + expectedMaxDepth);
        Assertions.assertThat(maxDepth).isEqualTo(expectedMaxDepth);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, int expectedMaxDepth) {
        // Given

        // When
        int maxDepth = maxDepthIt(root);

        // Then
        System.out.println("maxDepthIt(" + TreeNode.toString(root) + ") = " + expectedMaxDepth);
        Assertions.assertThat(maxDepth).isEqualTo(expectedMaxDepth);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + Math.max(leftDepth, rightDepth);
    }

    record Entry (TreeNode node, int level) {}

    public int maxDepthIt(TreeNode root) {
        if (root == null) return 0;

        int level = 1;
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root, level));

        while (!queue.isEmpty()) {
            Entry curr = queue.poll();

            if (curr.node.left != null) {
                queue.add(new Entry(curr.node.left, curr.level + 1));
                level = Math.max(level, curr.level + 1);
            }
            if (curr.node.right != null) {
                queue.add(new Entry(curr.node.right, curr.level + 1));
                level = Math.max(level, curr.level + 1);
            }
        }

        return level;
    }
}
