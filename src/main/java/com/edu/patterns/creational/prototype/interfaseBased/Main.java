package com.edu.patterns.creational.prototype.interfaseBased;

public class Main {
    public static void main(String[] args) {
        Prototype prototype = new Concrete("ABC", "DEF");
        Prototype prototype1 = prototype.clone();
        System.out.println(((Concrete)prototype1).getField());
    }
}
