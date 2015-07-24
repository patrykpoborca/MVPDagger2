package com.patryk.mvpdagger2.dagger;

import com.patryk.mvpdagger2.network.OKClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Patryk on 7/23/2015.
 */
@Module
public class OKModule {

    @Provides
    @Singleton
    public OKClient providesOKClient(){
        return new OKClient();
    }
}
