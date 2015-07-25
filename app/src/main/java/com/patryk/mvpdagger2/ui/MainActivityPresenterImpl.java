package com.patryk.mvpdagger2.ui;

import android.os.Handler;

import com.patryk.mvpdagger2.base.BaseView;
import com.patryk.mvpdagger2.network.TwitterAPI;
import com.patryk.mvpdagger2.ui.presenterinterfaces.MainActivityPresenter;
        import com.patryk.mvpdagger2.ui.viewinterfaces.MainActivityView;

        import javax.inject.Inject;

/**
 * Created by Patryk on 7/23/2015.
 */
public class MainActivityPresenterImpl implements MainActivityPresenter {
    private MainActivityView mView;

    private final TwitterAPI mTwitterAPI;

    @Inject
    public MainActivityPresenterImpl(TwitterAPI twitterAPI){
        mTwitterAPI = twitterAPI;
    }



    @Override
    public void getRandomTweet() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mView.postTweet(mTwitterAPI.fetchTweetFromServer());
            }
        }, 5000);
    }

    @Override
    public void onAttach() {
    }

    @Override
    public void onDettach() {
    }

    @Override
    public void registerView(MainActivityView param) {
        mView = param;
    }
}
