package com.edu.patterns.creational.prototype.abstractClassBased;

import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
public class Concrete extends Prototype {

    private String concreteField;

    public Concrete(){}


    private Concrete(Prototype target) {
        super(target);
    }

    @Override
    public Prototype clone() {
        Concrete c = new Concrete(this);
        c.setConcreteField(this.concreteField);
        return c;
    }

    @Override
    public String toString() {
        return "Concrete{" +
                "concreteField='" + concreteField + '\'' +
                "superField='" + super.getField() + '\'' +
                '}';
    }
}
