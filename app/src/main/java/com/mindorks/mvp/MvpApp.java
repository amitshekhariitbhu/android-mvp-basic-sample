package com.mindorks.mvp;

import android.app.Application;

import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.data.SharedPrefsHelper;

/**
 * Created by gaura on 23-08-2017.
 */

public class MvpApp extends Application {

    DataManager dataManager;

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPrefsHelper sharedPrefsHelper = new SharedPrefsHelper(getApplicationContext());
        dataManager = new DataManager(sharedPrefsHelper);

    }

    public DataManager getDataManager() {
        return dataManager;
    }

}
