package com.mindorks.mvp.ui.main;

import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.ui.base.BasePresenter;

/**
 * Created by gaura on 23-08-2017.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V> implements MainMvpPresenter<V> {

    public MainPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void saveEmailId(String emailId) {
        getDataManager().saveEmailId(emailId);
    }

    @Override
    public String getEmailId() {
        return getDataManager().getEmailId();
    }

    @Override
    public void setUserLoggedOut() {
        getDataManager().clear();
        getDataManager().setLoggedOut();
        getMvpView().openSplashActivity();
    }

}
