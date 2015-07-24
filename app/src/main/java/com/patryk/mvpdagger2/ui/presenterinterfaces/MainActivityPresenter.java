package com.patryk.mvpdagger2.ui.presenterinterfaces;

import com.patryk.mvpdagger2.base.BasePresenter;
import com.patryk.mvpdagger2.ui.viewinterfaces.MainActivityView;

/**
 * Created by Patryk on 7/23/2015.
 */
public interface MainActivityPresenter extends BasePresenter<MainActivityView>{
    public void getRandomTweet();
}
