package com.patryk.mvpdagger2.demo.models.dagger;


import com.patryk.mvpdagger2.SomeActivity;

import dagger.Component;

@Component(modules = {SomeModule.class})
public interface SomeComponent {
    void inject(SomeActivity someActivity);
}
