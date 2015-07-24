package com.patryk.mvpdagger2;

import android.app.Application;

import com.patryk.mvpdagger2.dagger.BaseComponent;
import com.patryk.mvpdagger2.dagger.AppModule;
import com.patryk.mvpdagger2.dagger.DaggerBaseComponent;
import com.patryk.mvpdagger2.network.OKClient;

import javax.inject.Inject;

/**
 * Created by Patryk on 7/23/2015.
 */
public class MVPApp extends Application {

    private static BaseComponent sBaseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppModule appModule = new AppModule(this);
        sBaseComponent = DaggerBaseComponent.builder()
                    .appModule(appModule)
                    .build();
    }

    public static BaseComponent getBaseComponent(){
        return sBaseComponent;
    }

}
