package com.mindorks.mvp.data;

/**
 * Created by gaura on 22-08-2017.
 */

public class DataManager {

    SharedPrefsHelper mSharedPrefsHelper;

    public DataManager(SharedPrefsHelper sharedPrefsHelper){
        mSharedPrefsHelper = sharedPrefsHelper;
    }

    public void clear(){
        mSharedPrefsHelper.clear();
    }

    public void saveEmailId(String email){
        mSharedPrefsHelper.put("EMAIL", email);
    }

    public String getEmailId(){
        return mSharedPrefsHelper.get("EMAIL",null);
    }

    public void setLoggedIn(){
        mSharedPrefsHelper.setLoggedInMode(true);
    }

    public void setLoggedOut(){
        mSharedPrefsHelper.setLoggedInMode(false);
    }

    public Boolean getLoggedInMode(){
       return mSharedPrefsHelper.getLoggedInMode();
    }
}
