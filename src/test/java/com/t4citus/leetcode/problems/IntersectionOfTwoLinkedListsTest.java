package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

@Leetcode(
        title = "160. Intersection of Two Linked Lists",
        url = "https://leetcode.com/problems/intersection-of-two-linked-lists/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class IntersectionOfTwoLinkedListsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                testCaseOneArguments(),
                testCaseTwoArguments(),
                testCaseThreeArguments()
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(ListNode headA, ListNode headB, ListNode expectedOutput) {
        // Given
        String headAString = ListNode.toString(headA);
        String headBString = ListNode.toString(headB);

        // When
        ListNode intersectionNode = getIntersectionNode(headA, headB);

        // Then
        System.out.println("getIntersectionNode(" + headAString + ", " + headBString + ") = " + ListNode.toString(intersectionNode));
        Assertions.assertThat(ListNode.equals(intersectionNode, expectedOutput)).isTrue();
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode currA = headA;
        ListNode currB = headB;

        // The idea is to create a loop between the end of one list to be beginning of the other to be able to use
        // the tortoise and hare algorithm. This algorithm ensures that both pointers (currA and currB) are either
        // both null (no intersection) or equal.
        while (currA != currB) {
            if (currA == null) {
                currA = headB;
            } else {
                currA = currA.next;
            }
            if (currB == null) {
                currB = headA;
            } else {
                currB = currB.next;
            }
            if (currA == null && currB == null) {
                return null;
            }
        }

        return currA;
    }

    private static Arguments testCaseOneArguments() {
        // Prepare intersection
        ListNode intersection = ListNode.createNodes(new int[]{8, 4, 5});

        // Prepare listA
        ListNode[] nodesA = mapToListNodes(new int[]{4, 1});
        nodesA[nodesA.length - 1].next = intersection;

        // Prepare listB
        ListNode[] nodesB = mapToListNodes(new int[]{5, 6, 1});
        nodesB[nodesB.length - 1].next = intersection;

        return Arguments.of(nodesA[0], nodesB[0], intersection);
    }

    private static Arguments testCaseTwoArguments() {
        // Prepare intersection
        ListNode intersection = ListNode.createNodes(new int[]{2, 4});

        // Prepare listA
        ListNode[] nodesA = mapToListNodes(new int[]{1, 9, 1});
        nodesA[nodesA.length - 1].next = intersection;

        // Prepare listB
        ListNode[] nodesB = mapToListNodes(new int[]{3});
        nodesB[nodesB.length - 1].next = intersection;

        return Arguments.of(nodesA[0], nodesB[0], intersection);
    }

    private static Arguments testCaseThreeArguments() {
        // No intersection

        // Prepare listA
        ListNode[] nodesA = mapToListNodes(new int[]{2, 6, 4});

        // Prepare listB
        ListNode[] nodesB = mapToListNodes(new int[]{1, 5});

        return Arguments.of(nodesA[0], nodesB[0], null);
    }

    private static ListNode[] mapToListNodes(int[] ints) {
        ListNode[] nodes = Arrays.stream(ints).mapToObj(ListNode::new).toArray(ListNode[]::new);
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        return nodes;
    }
}
