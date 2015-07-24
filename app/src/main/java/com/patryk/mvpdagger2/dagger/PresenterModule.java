package com.patryk.mvpdagger2.dagger;

import com.patryk.mvpdagger2.MVPApp;
import com.patryk.mvpdagger2.network.OKClient;
import com.patryk.mvpdagger2.network.TwitterAPI;
import com.patryk.mvpdagger2.ui.MainActivityPresenterImpl;
import com.patryk.mvpdagger2.ui.presenterinterfaces.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Patryk on 7/23/2015.
 */
@Module
public class PresenterModule {

    @Provides
    MainActivityPresenter providesMainActivePresenter(TwitterAPI api){
        return new MainActivityPresenterImpl(api);
    }
}
