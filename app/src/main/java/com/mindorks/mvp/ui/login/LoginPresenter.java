package com.mindorks.mvp.ui.login;

import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.ui.base.BasePresenter;

/**
 * Created by gaura on 22-08-2017.
 */

public class LoginPresenter<V extends LoginMvpView> extends BasePresenter<V> implements LoginMvpPresenter<V> {

    public LoginPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void startLogin(String emailId) {
        getDataManager().saveEmailId(emailId);
        getDataManager().setLoggedIn();
        getMvpView().openMainActivity();
    }

    @Override
    public String showSavedEmail() {
        return getDataManager().getEmailId();
    }

    @Override
    public void saveEmailId(String emailId) {
        getDataManager().saveEmailId(emailId);
    }
}
