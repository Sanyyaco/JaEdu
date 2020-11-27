package com.edu.patterns.factoryMethod;

public class CreatorProductB implements Creator{
    public Product createProduct() {
        return new ProductB();
    }
}
