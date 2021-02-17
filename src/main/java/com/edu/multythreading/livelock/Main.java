package com.edu.multythreading.livelock;

public class Main {

    public static void main(String[] args) {
        final Worker worker1= new Worker("Peter", true);
        final Worker worker2= new Worker("Sam", true);

        final CommonResource s = new CommonResource(worker1);

        new Thread(() -> worker1.work(s, worker2)).start();
        new Thread(() -> worker2.work(s, worker1)).start();
    }
}
