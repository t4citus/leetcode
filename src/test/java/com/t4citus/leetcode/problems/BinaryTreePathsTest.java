package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.TreeNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Leetcode(
        title = "257. Binary Tree Paths",
        url = "https://leetcode.com/problems/binary-tree-paths/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class BinaryTreePathsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3)), List.of("1->2->5", "1->3")),
                Arguments.of(new TreeNode(1), List.of("1"))
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(TreeNode root, List<String> expectedOutput) {
        // Given

        // When
        List<String> allPaths = binaryTreePaths(root);

        // Then
        System.out.println("binaryTreePaths(" + TreeNode.toString(root) + ") = " + allPaths);
        Assertions.assertThat(allPaths).isEqualTo(expectedOutput);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return List.of();
        if (root.left == null && root.right == null) return List.of(String.valueOf(root.val));
        List<String> allPaths = new ArrayList<>();
        String rootPath = String.valueOf(root.val);
        writePath(root.left, rootPath, allPaths);
        writePath(root.right, rootPath, allPaths);
        return allPaths;
    }

    public void writePath(TreeNode root, String path, List<String> allPaths) {
        if (root == null) return;
        String newPath = path + "->" + root.val;
        if (root.left == null && root.right == null) allPaths.add(newPath);
        writePath(root.left, newPath, allPaths);
        writePath(root.right, newPath, allPaths);
    }
}
