package com.patryk.mvpdagger2.base;

/**
 * Created by Patryk on 7/23/2015.
 */
public interface BasePresenter<T extends BaseView> {

    public void onAttach();

    public void onDettach();

    public void registerView(T param);
}
