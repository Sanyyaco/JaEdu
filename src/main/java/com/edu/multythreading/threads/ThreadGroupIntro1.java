package com.edu.multythreading.threads;

public class ThreadGroupIntro1 {

    public static void main(String[] args) {
        Thread currentThread = Thread.currentThread();
        ThreadGroup threadGroup = currentThread.getThreadGroup();
        System.out.println("Thread: " + currentThread.getName());
        System.out.println("Thread Group: " + threadGroup.getName());
        System.out.println("Thread Pargent group: " + threadGroup.getParent().getName());
        threadGroup.getParent().list();
    }
}
