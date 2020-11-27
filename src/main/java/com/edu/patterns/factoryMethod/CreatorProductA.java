package com.edu.patterns.factoryMethod;

public class CreatorProductA implements Creator{
    public Product createProduct() {
        return new ProductA();
    }
}
