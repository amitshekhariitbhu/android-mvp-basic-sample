package com.mindorks.mvp.ui.splash;

import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.ui.base.BasePresenter;

/**
 * Created by gaura on 23-08-2017.
 */

public class SplashPresenter<V extends SplashMvpView> extends BasePresenter<V> implements SplashMvpPresenter<V> {

    public SplashPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void decideNextActivity() {
        if (getDataManager().getLoggedInMode()){
            getMvpView().openMainActivity();
        }
        else {
            getMvpView().openLoginActivity();
        }
    }
}
