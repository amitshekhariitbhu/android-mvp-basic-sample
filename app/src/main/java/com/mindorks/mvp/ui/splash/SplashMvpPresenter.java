package com.mindorks.mvp.ui.splash;

import com.mindorks.mvp.ui.base.MvpPresenter;

/**
 * Created by gaura on 23-08-2017.
 */

public interface SplashMvpPresenter<V extends SplashMvpView> extends MvpPresenter<V> {

    void decideNextActivity();

}
