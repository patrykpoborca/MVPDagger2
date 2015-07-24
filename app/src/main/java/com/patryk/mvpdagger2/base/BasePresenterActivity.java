package com.patryk.mvpdagger2.base;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Patryk on 7/23/2015.
 */
public abstract class BasePresenterActivity<T extends BasePresenter> extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().onAttach();
    }

    @Override
    protected void onPause() {
        super.onPause();
        getPresenter().onDettach();
    }

    protected abstract T getPresenter();
}
