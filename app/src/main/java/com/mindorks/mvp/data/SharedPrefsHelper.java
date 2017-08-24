package com.mindorks.mvp.data;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by gaura on 22-08-2017.
 */

public class SharedPrefsHelper {

    SharedPreferences mSharedPreferences;

    public SharedPrefsHelper(Context context){
        mSharedPreferences = context.getSharedPreferences("MYPREFS",MODE_PRIVATE);
    }

    public void clear(){
        mSharedPreferences.edit().clear().apply();
    }

    public void put(String key, String value){
        mSharedPreferences.edit().putString(key,value).apply();
    }

    public String get(String key, String defaultValue){
        return mSharedPreferences.getString(key, defaultValue);
    }

    public void setLoggedInMode(boolean loggedIn){
        mSharedPreferences.edit().putBoolean("IS_LOGGED_IN",loggedIn).apply();
    }

    public boolean getLoggedInMode(){
        return mSharedPreferences.getBoolean("IS_LOGGED_IN",false);
    }

}
