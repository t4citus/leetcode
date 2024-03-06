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
        title = "1609. Even Odd Tree",
        url = "https://leetcode.com/problems/even-odd-tree/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class EvenOddTreeTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(
                        new TreeNode(1,
                                new TreeNode(10,
                                        new TreeNode(3,
                                                new TreeNode(12),
                                                new TreeNode(8)), null),
                                new TreeNode(4,
                                        new TreeNode(7,
                                                new TreeNode(6),
                                                null),
                                        new TreeNode(9,
                                                null,
                                                new TreeNode(2))))
                        , true),
                Arguments.of(
                        new TreeNode(5,
                                new TreeNode(4,
                                        new TreeNode(3),
                                        new TreeNode(3)),
                                new TreeNode(2,
                                        new TreeNode(7),
                                        null))
                        , false),
                Arguments.of(new TreeNode(5,
                                new TreeNode(9,
                                        new TreeNode(3),
                                        new TreeNode(5)),
                                new TreeNode(1,
                                        new TreeNode(7),
                                        null))
                        , false)
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolutionIterative_thenReturnsAsExpected(TreeNode root, boolean expectedEvenOddTree) {
        // Given

        // When
        boolean evenOddTree = isEvenOddTree(root);

        // Then
        System.out.println("isEvenOddTree(" + TreeNode.toString(root) + ") = " + evenOddTree);
        Assertions.assertThat(evenOddTree).isEqualTo(expectedEvenOddTree);
    }

    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int count = queue.size();
            int prev = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            while (count > 0) {
                TreeNode curr = queue.poll();
                if (curr == null) return false;

                // even level
                if (level % 2 == 0 && (curr.val % 2 == 0 || prev >= curr.val)) return false;

                // odd level
                if (level % 2 == 1 && (curr.val % 2 == 1 || prev <= curr.val)) return false;

                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);

                prev = curr.val;
                count--;
            }

            level++;
        }

        return true;
    }
}
