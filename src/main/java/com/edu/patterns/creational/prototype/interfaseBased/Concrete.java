package com.edu.patterns.creational.prototype.interfaseBased;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@AllArgsConstructor
public class Concrete implements Prototype {

    String field;
    String anotherField;

    @Override
    public Prototype clone() {
        return new Concrete(this.field, this.anotherField);
    }

    @Override
    public String toString() {
        return "Concrete{" +
                "field='" + field + '\'' +
                ", anotherField='" + anotherField + '\'' +
                '}';
    }
}
