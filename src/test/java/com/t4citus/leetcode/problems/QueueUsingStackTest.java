package com.t4citus.leetcode.problems;

import com.t4citus.leetcode.AbstractTestBase;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

public class QueueUsingStackTest extends AbstractTestBase {

    @Test
    public void givenTestCase_whenRunSolution_thenReturnsAsExpected() {
        // Given

        // When
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        int peek = myQueue.peek(); // return 1
        int pop = myQueue.pop(); // return 1, queue is [2]
        boolean isEmpty = myQueue.empty(); // return false

        // Then
        Assertions.assertThat(peek).isEqualTo(1);
        Assertions.assertThat(pop).isEqualTo(1);
        Assertions.assertThat(isEmpty).isFalse();
    }

    private static class MyQueue {

        private final List<Integer> list;

        public MyQueue() {
            list = new ArrayList<>();
        }

        public void push(int x) {
            list.add(x);
        }

        public int pop() {
            int val = list.get(0);
            list.remove(0);
            return val;
        }

        public int peek() {
            return list.get(0);
        }

        public boolean empty() {
            return list.isEmpty();
        }
    }
}
