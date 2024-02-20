package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "111. Minimum Depth of Binary Tree",
        url = "https://leetcode.com/problems/minimum-depth-of-binary-tree/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MinimumDepthOfBinaryTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))), 2),
                Arguments.of(new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6))))), 5)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(TreeNode root, int expectedOutput) {
        //
        // When
        int minDepth = minDepth(root);

        // Then
        System.out.println("minDepth(" + TreeNode.toString(root) + ") = " + minDepth);
        Assertions.assertThat(minDepth).isEqualTo(expectedOutput);
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0) return rightDepth + 1;
        if (rightDepth == 0) return leftDepth + 1;
        return 1 + Math.min(leftDepth, rightDepth);
    }
}
