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
        title = "222. Count Complete Tree Nodes",
        url = "https://leetcode.com/problems/count-complete-tree-nodes/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class CountCompleteTreeNodesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null)), 6),
                Arguments.of(null, 0),
                Arguments.of(new TreeNode(1), 1)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, int expectedOutput) {
        // Given

        // When
        int count = countNodes(root);

        // Then
        System.out.println("countNodes(" + TreeNode.toString(root) + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, int expectedOutput) {
        // Given

        // When
        int count = countNodesIt(root);

        // Then
        System.out.println("countNodesIt(" + TreeNode.toString(root) + ") = " + count);
        Assertions.assertThat(count).isEqualTo(expectedOutput);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodesIt(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            count += 1;

            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return count;
    }
}
