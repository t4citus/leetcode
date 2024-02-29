package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import com.t4citus.leetcode.annotations.Leetcode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

@Leetcode(
        title = "225. Implement Stack using Queues",
        url = "https://leetcode.com/problems/implement-stack-using-queues/description/",
        difficulty = Leetcode.Difficulty.EASY
)
public class ImplementStackUsingQueuesTest extends AbstractTestBase {

    @Test
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected() {
        // Given

        // When

        // Then
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);

        int top = stack.top();
        Assertions.assertThat(top).isEqualTo(2);

        int pop = stack.pop();
        Assertions.assertThat(pop).isEqualTo(2);

        boolean empty = stack.empty();
        Assertions.assertThat(empty).isFalse();
    }

    public static class MyStack {

        private Queue<Integer> queue = new LinkedList<>();

        public MyStack() {
        }

        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            Queue<Integer> temp = new LinkedList<>();
            Integer curr = null;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                if (!queue.isEmpty())
                    temp.add(curr);
            }
            queue = temp;
            return curr != null ? curr : 0;
        }

        public int top() {
            Queue<Integer> temp = new LinkedList<>();
            Integer curr = null;
            while (!queue.isEmpty()) {
                curr = queue.poll();
                temp.add(curr);
            }
            queue = temp;
            return curr != null ? curr : 0;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
