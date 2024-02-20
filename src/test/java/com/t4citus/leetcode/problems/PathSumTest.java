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
        title = "112. Path Sum",
        url = "https://leetcode.com/problems/path-sum/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class PathSumTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22, true),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3)),5, false),
                Arguments.of(null, 0, false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, int targetSum, boolean expectedOutput) {
        // Given

        // When
        boolean hasPathSum = hasPathSum(root, targetSum);

        // Then
        System.out.println("hasPathSum(" + TreeNode.toString(root) + ", " + targetSum + ") = " + hasPathSum);
        Assertions.assertThat(hasPathSum).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, int targetSum, boolean expectedOutput) {
        // Given

        // When
        boolean hasPathSum = hasPathSumIt(root, targetSum);

        // Then
        System.out.println("hasPathSumIt(" + TreeNode.toString(root) + ", " + targetSum + ") = " + hasPathSum);
        Assertions.assertThat(hasPathSum).isEqualTo(expectedOutput);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathSum(root, targetSum, 0);
    }

    public boolean hasPathSum(TreeNode root, int targetSum, int sum) {
        if (root.left == null && root.right == null) return sum + root.val == targetSum;
        boolean isLeft = root.left != null && hasPathSum(root.left, targetSum, sum + root.val);
        boolean isRight = root.right != null && hasPathSum(root.right, targetSum, sum + root.val);
        return isLeft || isRight;
    }

    public boolean hasPathSumIt(TreeNode root, int targetSum) {
        if (root == null) return false;

        // The solution works with two queues that need to be handled
        record Entry (TreeNode node, int sum) {}
        Queue<Entry> queue = new LinkedList<>();
        queue.add(new Entry(root, root.val));

        while (!queue.isEmpty()) {
            Entry curr = queue.poll();
            if (curr.node.left == null && curr.node.right == null && curr.sum == targetSum) {
                return true;
            }
            if (curr.node.left != null) {
                queue.add(new Entry(curr.node.left, curr.sum + curr.node.left.val));
            }
            if (curr.node.right != null) {
                queue.add(new Entry(curr.node.right, curr.sum + curr.node.right.val));
            }
        }

        return false;
    }

    // record Entry (TreeNode node, int sum) {}
}
