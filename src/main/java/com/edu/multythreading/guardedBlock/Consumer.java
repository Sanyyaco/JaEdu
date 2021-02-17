package com.edu.multythreading.guardedBlock;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Consumer implements Runnable {


    private Drop drop;

    @Override
    public void run() {
        Random random = new Random();
        for(String msg = drop.take(); !msg.equals("DONE"); drop.take()){
            System.out.println("Message received: " + msg);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
