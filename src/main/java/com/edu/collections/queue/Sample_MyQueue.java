package com.edu.collections.queue;

import java.util.*;
import org.junit.Assert;

public class Sample_MyQueue {
    public static void main(String[] args) {
        /** SIMPLE QUEUE*/
        Queue<Integer> simpleQueue = new MyQueue<>();
        simpleQueue.offer(1);
        simpleQueue.offer(2);
        simpleQueue.offer(3);
        simpleQueue.offer(4);

        System.out.println(simpleQueue);
        Assert.assertTrue(simpleQueue.poll()==1);
        Assert.assertTrue(simpleQueue.peek()==2);
        Assert.assertTrue(simpleQueue.contains(4));

        simpleQueue.offer(null);
        Assert.assertTrue(!simpleQueue.contains(null));
    }

    static class MyQueue<T> extends AbstractQueue<T> {
        LinkedList<T> elements;

        public MyQueue() {
            this.elements = new LinkedList<>();
        }

        @Override
        public Iterator<T> iterator() {
            return elements.iterator();
        }

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        public boolean offer(T t) {
            if(t == null) return false;
            elements.add(t);
            return true;
        }

        @Override
        public T poll() {
            Iterator<T> iter = elements.iterator();
            T t = iter.next();
            if(t != null){
                iter.remove();
                return t;
            }
            return null;
        }

        @Override
        public T peek() {
            return elements.getFirst();
        }

    }
}
