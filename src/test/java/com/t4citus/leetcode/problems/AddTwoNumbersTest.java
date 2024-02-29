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
        title = "2. Add Two Numbers",
        url = "https://leetcode.com/problems/add-two-numbers/description/",
        difficulty = Leetcode.Difficulty.MEDIUM
)
public class AddTwoNumbersTest extends AbstractTestBase {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 4, 3}, new int[]{5, 6, 4}, new int[]{7, 0, 8}),
                Arguments.of(new int[]{0}, new int[]{0}, new int[]{0}),
                Arguments.of(new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9}, new int[]{8, 9, 9, 9, 0, 0, 0, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected(int[] ints1, int[] ints2, int[] expectedSumInts) {
        // Given
        ListNode head1 = ListNode.createNodes(ints1);
        ListNode head2 = ListNode.createNodes(ints2);
        ListNode expectedSumHead = ListNode.createNodes(expectedSumInts);

        // When
        ListNode sumHead = addTwoNumbers(head1, head2);

        // Then
        System.out.println("addTwoNumbers(" + ListNode.toString(head1) + ", " + ListNode.toString(head2) + ") = " + ListNode.toString(sumHead));
        Assertions.assertThat(ListNode.equals(sumHead, expectedSumHead)).isTrue();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode currSum = null;
        ListNode sumHead = null;
        int carry = 0;

        while (curr1 != null || curr2 != null) {
            int val1 = (curr1 == null) ? 0 : curr1.val;
            int val2 = (curr2 == null) ? 0 : curr2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            if (currSum == null) {
                currSum = new ListNode(sum);
                sumHead = currSum;
            } else {
                currSum.next = new ListNode(sum);
                currSum = currSum.next;
            }
            if (curr1 != null) curr1 = curr1.next;
            if (curr2 != null) curr2 = curr2.next;
        }
        if (carry == 1) {
            currSum.next = new ListNode(1);
        }

        return sumHead;
    }
}
