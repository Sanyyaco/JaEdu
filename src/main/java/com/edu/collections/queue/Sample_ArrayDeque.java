package com.edu.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Sample_ArrayDeque {
    public static void main(String[] args) {
Thread.currentThread().getState();

        /** Use it as Stack*/
        Deque stack = new ArrayDeque();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        System.out.println(stack);
        System.out.println(stack.poll());


    }
}
