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
        title = "226. Invert Binary Tree",
        url = "https://leetcode.com/problems/invert-binary-tree/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class InvertBinaryTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9))),
                        new TreeNode(4, new TreeNode(7, new TreeNode(9), new TreeNode(6)), new TreeNode(2, new TreeNode(3), new TreeNode(1)))
                ),
                Arguments.of(
                        new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                        new TreeNode(2, new TreeNode(3), new TreeNode(1))
                ),
                Arguments.of(
                        new TreeNode(1),
                        new TreeNode(1)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, TreeNode expectedInvertedRoot) {
        // Given

        // When
        TreeNode invertedTree = invertTree(root);

        // Then
        System.out.println("invertTree(" + TreeNode.toString(root) + ") = " + TreeNode.toString(invertedTree));
        Assertions.assertThat(new SameTreeTest().isSameTree(invertedTree, expectedInvertedRoot)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, TreeNode expectedInvertedRoot) {
        // Given
        String rootString = TreeNode.toString(root);

        // When
        TreeNode invertedTree = invertTreeIt(root);

        // Then
        System.out.println("invertTreeIt(" + rootString + ") = " + TreeNode.toString(invertedTree));
        Assertions.assertThat(new SameTreeTest().isSameTree(invertedTree, expectedInvertedRoot)).isTrue();
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode inverted = new TreeNode(root.val);
        inverted.left = invertTree(root.right);
        inverted.right = invertTree(root.left);
        return inverted;
    }

    public TreeNode invertTreeIt(TreeNode root) {
        if (root == null) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            // do not break the loop as up to two nodes are added each loop
            if (curr == null) continue;

            // swap left and right node
            TreeNode leftTmp = curr.left;
            curr.left = curr.right;
            curr.right = leftTmp;

            queue.add(curr.left);
            queue.add(curr.right);
        }

        return root;
    }
}
