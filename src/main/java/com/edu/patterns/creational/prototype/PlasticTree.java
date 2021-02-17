package com.edu.patterns.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class PlasticTree extends Tree {

    private String position;

    public PlasticTree(String height, String mass, String position) {
        super(height, mass);
        this.position = position;
    }

    @Override
    public Tree copy() {
        return new PlasticTree(this.getHeight(), this.getMass(), this.getPosition());
    }
}
