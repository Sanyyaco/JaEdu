package com.edu.multythreading.guardedBlock;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Producer implements Runnable {
    private Drop drop;


    @Override
    public void run() {
        String msgs [] = {"Msg1", "Msg2", "Msg3"};
        Random random = new Random();
        for (int i = 0; i < msgs.length; i++) {
            drop.put(msgs[i]);
            try {
                Thread.sleep(random.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
drop.put("Done");
        }

    }
}
