package com.edu.patterns.creational.prototype.abstractClassBased;

public class Main {
    public static void main(String[] args) {
        Concrete p = new Concrete();
        p.setField("Field");
        p.setConcreteField("ConcreteField");


        Prototype newC = p.clone();

        System.out.println(p.toString());
        System.out.println(newC.toString());


    }
}
