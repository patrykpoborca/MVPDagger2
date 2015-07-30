package com.patryk.mvpdagger2.demo.models.dagger;


import com.patryk.mvpdagger2.demo.models.SomeClass;
import com.patryk.mvpdagger2.demo.models.SomeDependency;
import com.patryk.mvpdagger2.demo.models.interfaces.ISomeClass;
import com.patryk.mvpdagger2.demo.models.interfaces.ISomeDependency;

import dagger.Module;
import dagger.Provides;

@Module
public class SomeModule {


    @Provides
    public ISomeDependency providesSomeDependency(){
        return new SomeDependency();
    }

    @Provides
    public ISomeClass providesSomeClass(ISomeDependency someDependency){
        return new SomeClass(someDependency);
    }
}
