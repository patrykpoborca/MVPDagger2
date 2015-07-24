package com.patryk.mvpdagger2.dagger;

import com.patryk.mvpdagger2.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;

/**
 * Created by Patryk on 7/23/2015.
 */
@Component(modules = {PresenterModule.class}, dependencies = BaseComponent.class)
@ActivityScope
public interface PresenterComponent {

    void inject(MainActivity activity);

}
