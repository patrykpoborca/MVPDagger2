package com.patryk.mvpdagger2.dagger;

import android.app.Application;

import com.patryk.mvpdagger2.MVPApp;
import com.patryk.mvpdagger2.meta.constants;
import com.patryk.mvpdagger2.network.OKClient;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Patryk on 7/23/2015.
 */
@Component(modules = {AppModule.class, OKModule.class})
@Singleton
public interface BaseComponent {
    // (private) Module -> component -> public      modules -/-> public
    MVPApp getMVPApp();

    OKClient getOKClient();
}


// || (AppModule) <- BaseComponent || => Provides us: MVPApp, OKClient  || ? || => Activity Level...??
// || (OKModule) /


// MVPApp + OKClient -> ?? [PresenterComponent] -> Presenter -> constructor?



// MVPApp component <- OKComponent [Depends] <- ...