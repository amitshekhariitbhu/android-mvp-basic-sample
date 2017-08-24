package com.mindorks.mvp.ui.base;

/**
 * Created by gaura on 22-08-2017.
 */

public interface MvpPresenter<V extends MvpView> {

    void onAttach(V mvpView);

}
