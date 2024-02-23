package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import com.t4citus.leetcode.problems.support.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Leetcode(
        title = "21. Merge Two Sorted Lists",
        url = "https://leetcode.com/problems/merge-two-sorted-lists/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class MergeTwoSortedListsTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4}),
                Arguments.of(new int[]{}, new int[]{}, new int[]{}),
                Arguments.of(new int[]{}, new int[]{0}, new int[]{0})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenMergeTwoLists_thenReturnsAsExpected(int[] ints1, int[] ints2, int[] expectedOutput) {
        // Given
        ListNode list1 = ListNode.createNodes(ints1);
        ListNode list2 = ListNode.createNodes(ints2);
        ListNode expected = ListNode.createNodes(expectedOutput);

        // When
        ListNode merged = mergeTwoLists(list1, list2);

        // Then
        System.out.println("mergeTwoLists(" + ListNode.toString(list1) + ", " + ListNode.toString(list2) + ") = " + ListNode.toString(merged));
        Assertions.assertThat(ListNode.equals(merged, expected)).isTrue();
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;

        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
