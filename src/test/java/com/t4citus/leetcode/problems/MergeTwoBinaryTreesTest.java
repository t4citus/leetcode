package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Stream;

@Leetcode(
        title = "617. Merge Two Binary Trees",
        url = "https://leetcode.com/problems/merge-two-binary-trees/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MergeTwoBinaryTreesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2)),
                        new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(7))),
                        new TreeNode(3, new TreeNode(4, new TreeNode(5), new TreeNode(4)), new TreeNode(5, null, new TreeNode(7)))
                ),
                Arguments.of(
                        new TreeNode(1),
                        new TreeNode(1, new TreeNode(2), null),
                        new TreeNode(2, new TreeNode(2), null)
                )
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root1, TreeNode root2, TreeNode expectedMergedRoot) {
        // Given

        // When
        TreeNode mergedRoot = mergeTrees(root1, root2);

        // Then
        System.out.println("mergeTrees(" + TreeNode.toString(root1) + ", " + TreeNode.toString(root2) + ") = " + TreeNode.toString(mergedRoot));
        Assertions.assertThat(TreeNode.equals(mergedRoot, expectedMergedRoot)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root1, TreeNode root2, TreeNode expectedMergedRoot) {
        // Given
        String tree1String = TreeNode.toString(root1);
        String tree2String = TreeNode.toString(root2);

        // When
        TreeNode mergedRoot = mergeTreesIt(root1, root2);

        // Then
        System.out.println("mergeTreesIt(" + tree1String + ", " + tree2String + ") = " + TreeNode.toString(mergedRoot));
        Assertions.assertThat(TreeNode.equals(mergedRoot, expectedMergedRoot)).isTrue();
    }

    /**
     * The function merges the two given trees by creating a new tree. Both given trees remain unchanged.
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        TreeNode sumNode = new TreeNode(root1.val + root2.val);
        sumNode.left = mergeTrees(root1.left, root2.left);
        sumNode.right = mergeTrees(root1.right, root2.right);
        return sumNode;
    }

    public TreeNode mergeTreesIt(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root1);
        stack.push(root2);

        while (!stack.isEmpty()) {
            TreeNode curr2 = stack.pop();
            TreeNode curr1 = stack.pop();

            if (curr1 != null && curr2 != null) {
                curr1.val += curr2.val;
                if (curr1.left == null) {
                    curr1.left = curr2.left;
                } else {
                    stack.push(curr1.left);
                    stack.push(curr2.left);
                }
                if (curr1.right == null) {
                    curr1.right = curr2.right;
                } else {
                    stack.push(curr1.right);
                    stack.push(curr2.right);
                }
            }
        }

        return root1;
    }
}
