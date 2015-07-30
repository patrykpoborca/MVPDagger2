package com.patryk.mvpdagger2.demo.models;

import com.patryk.mvpdagger2.demo.models.interfaces.ISomeClass;
import com.patryk.mvpdagger2.demo.models.interfaces.ISomeDependency;

import javax.inject.Inject;

public class SomeClass implements ISomeClass {

    private final ISomeDependency someDependency;

    @Inject
    public SomeClass(ISomeDependency someDependency){
        this.someDependency = someDependency;
    }
}
