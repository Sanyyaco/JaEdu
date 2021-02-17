package com.edu.patterns.creational.prototype.abstractClassBased;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
public abstract class Prototype {

    private String field;

    public Prototype(){}

    protected Prototype(Prototype target){
        if(target != null){
            this.field = target.field;
        }
    }

    public abstract Prototype clone();

}
