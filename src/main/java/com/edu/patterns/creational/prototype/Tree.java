package com.edu.patterns.creational.prototype;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Tree {

    String mass;
    String height;

    public abstract Tree copy();
}
