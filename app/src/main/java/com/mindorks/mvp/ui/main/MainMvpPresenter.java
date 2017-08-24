package com.mindorks.mvp.ui.main;

import com.mindorks.mvp.ui.base.MvpPresenter;

/**
 * Created by gaura on 23-08-2017.
 */

public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void saveEmailId(String email);

    String getEmailId();

    void setUserLoggedOut();

}
