package com.edu.patterns.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.IOException;
import java.util.TreeSet;


@Data
@AllArgsConstructor
public class PineTree extends Tree{


    private String position;

    public PineTree(String height, String mass, String position) {
        super(height, mass);
        this.position = position;
    }

    @Override
    public Tree copy() {
        return new PineTree(this.getHeight(), this.getMass(), this.getPosition());
    }
}
