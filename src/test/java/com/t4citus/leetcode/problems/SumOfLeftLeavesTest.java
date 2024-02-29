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
        title = "404. Sum of Left Leaves",
        url = "https://leetcode.com/problems/sum-of-left-leaves/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SumOfLeftLeavesTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))), 24),
                Arguments.of(new TreeNode(1), 0),
                Arguments.of(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3)), 4)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode root, int expectedSum) {
        // Given

        // When
        int sum = sumOfLeftLeaves(root);

        // Then
        System.out.println("sumOfLeftLeaves(" + TreeNode.toString(root) + ") = " + sum);
        Assertions.assertThat(sum).isEqualTo(expectedSum);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, int expectedSum) {
        // Given

        // When
        int sum = sumOfLeftLeavesIt(root);

        // Then
        System.out.println("sumOfLeftLeaves(" + TreeNode.toString(root) + ") = " + sum);
        Assertions.assertThat(sum).isEqualTo(expectedSum);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public int sumOfLeftLeavesIt(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr.left != null) {
                if (curr.left.left == null && curr.left.right == null) sum += curr.left.val;
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return sum;
    }
}
