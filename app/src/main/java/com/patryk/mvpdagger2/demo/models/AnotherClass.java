package com.patryk.mvpdagger2.demo.models;

import com.patryk.mvpdagger2.demo.models.interfaces.ISomeClass;

import javax.inject.Inject;

public class AnotherClass {

    private final ISomeClass someClass;

    @Inject
    public AnotherClass(ISomeClass someClass){
        this.someClass = someClass;
    }

    public String getSomeText() {
        return null;
    }
}
