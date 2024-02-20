package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

@Leetcode(
        title = "100. Same Tree",
        url = "https://leetcode.com/problems/same-tree/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class SameTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3)), true),
                Arguments.of(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null, new TreeNode(2)), false),
                Arguments.of(new TreeNode(1, new TreeNode(2), new TreeNode(1)), new TreeNode(1, new TreeNode(1), new TreeNode(2)), false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionRecursive_thenReturnsAsExpected(TreeNode p, TreeNode q, boolean expectedOutput) {
        // Given

        // When
        boolean isSame = isSameTree(p, q);

        // Then
        System.out.println("isSameTree(" + TreeNode.toString(p) + ", " + TreeNode.toString(q) + ") = " + isSame);
        Assertions.assertThat(isSame).isEqualTo(expectedOutput);
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode p, TreeNode q, boolean expectedOutput) {
        // Given

        // When
        boolean isSame = isSameTreeIt(p, q);

        // Then
        System.out.println("isSameTreeIt(" + TreeNode.toString(p) + ", " + TreeNode.toString(q) + ") = " + isSame);
        Assertions.assertThat(isSame).isEqualTo(expectedOutput);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeIt(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        // Use BFS traversal
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pCurr = pQueue.poll();
            TreeNode qCurr = qQueue.poll();

            if (pCurr.val != qCurr.val) {
                return false;
            }

            if (pCurr.left != null && qCurr.left != null) {
                pQueue.add(pCurr.left);
                qQueue.add(qCurr.left);
            } else if (!(pCurr.left == null && qCurr.left == null)) {
                return false;
            }

            if (pCurr.right != null && qCurr.right != null) {
                pQueue.add(pCurr.right);
                qQueue.add(qCurr.right);
            } else if (!(pCurr.right == null && qCurr.right == null)) {
                return false;
            }
        }

        return pQueue.isEmpty() && qQueue.isEmpty();
    }
}
