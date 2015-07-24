package com.patryk.mvpdagger2.dagger;

import android.app.Application;

import com.patryk.mvpdagger2.MVPApp;
import com.patryk.mvpdagger2.meta.constants;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Patryk on 7/23/2015.
 */
@Module
public class AppModule {

    private final MVPApp mApp;

    public AppModule(MVPApp app){
        mApp = app;
    }

    @Provides
    @Singleton
      MVPApp providesMVPApp(){
        return mApp;
    }
}
