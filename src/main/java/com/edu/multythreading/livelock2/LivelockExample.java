package com.edu.multythreading.livelock2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {
    private Lock lock1 = new ReentrantLock();
    private Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {

        LivelockExample livelockExample = new LivelockExample();
        new Thread(livelockExample::operation1, "T1").start();
        new Thread(livelockExample::operation2, "T2").start();

    }

    public void operation1(){
        while(true){
            tryLock(lock1, 50);
            print(Thread.currentThread().getName() + " acquired lock1, trying to acquire lock 2");
            sleep(50);

            if(tryLock(lock2)) {
                print("lock2 acquired");
            }
            else {
                print("cannot acquire lock2, releasing lock1.");
                lock1.unlock();
                continue;
            }
            print("executing first operation");
            break;
        }
        lock2.unlock();
        lock1.unlock();

    }

    public void operation2(){
        while(true){
            tryLock(lock2, 50);
            print(Thread.currentThread().getName() + " acquired lock2, trying to acquire lock 2");
            sleep(50);

            if(tryLock(lock1)) {
                print("lock1 acquired");
            }
            else {
                print("cannot acquire lock1, releasing lock2.");
                lock2.unlock();
                continue;
            }
            print("executing first operation");
            break;
        }
        lock1.unlock();
        lock2.unlock();

    }


    public void print (String msg){
        System.out.println(Thread.currentThread().getName()+ ": " + msg);
    }

    public void sleep(long mls){
        try {
            Thread.sleep(mls);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tryLock(Lock lock, long mls){
        try {
            lock.tryLock(mls, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean tryLock(Lock lock){
        return lock.tryLock();
    }
}
