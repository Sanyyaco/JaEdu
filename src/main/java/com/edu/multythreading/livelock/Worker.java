package com.edu.multythreading.livelock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Worker {
    private String name;
    private boolean active;

    public synchronized void work (CommonResource commonResource, Worker otherWorker){
        while(active){
            if(commonResource.getOwner()!= this){
                try{
                    wait(10);
                } catch (InterruptedException e){}
                continue;
            }

            if(otherWorker.isActive()){
                System.out.println(getName() + " passes resources to " + otherWorker.getName());
                commonResource.setOwner(otherWorker);
                continue;
            }

            System.out.println(getName() + " works on common resource");
            active = false;
            commonResource.setOwner(otherWorker);
        }
    }


}
