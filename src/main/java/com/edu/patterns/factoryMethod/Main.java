package com.edu.patterns.factoryMethod;

public class Main {
    public static void main(String[] args) {
        Creator creator = new CreatorProductA();
        Product product = creator.createProduct();
        product.print();
    }
}
