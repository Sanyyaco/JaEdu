package com.edu.multythreading.livelock;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommonResource {
    private Worker owner;

    public synchronized void setOwner(Worker owner) {
        this.owner = owner;
    }
}
