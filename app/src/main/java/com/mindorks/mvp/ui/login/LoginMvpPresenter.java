package com.mindorks.mvp.ui.login;

import com.mindorks.mvp.ui.base.MvpPresenter;

/**
 * Created by gaura on 22-08-2017.
 */

public interface LoginMvpPresenter<V extends LoginMvpView> extends MvpPresenter<V> {

    void startLogin(String emailId);

    String showSavedEmail();

    void saveEmailId(String emailId);

}
