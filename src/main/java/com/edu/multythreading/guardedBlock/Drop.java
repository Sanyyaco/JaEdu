package com.edu.multythreading.guardedBlock;

public class Drop {
    private String msg;
    private boolean empty = true;

    public synchronized String take(){
        while(empty){
            try{
                wait();
            }catch (InterruptedException e){

            }
        }
        empty = true;
        notifyAll();
        return msg;
    }

    public synchronized void put(String msg){
        while(!empty){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = false;
        this.msg = msg;
        notifyAll();
    }
}
