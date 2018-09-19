/*
 *    Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.mindorks.mvp.data

import android.content.Context
import android.content.SharedPreferences

import android.content.Context.MODE_PRIVATE

/**
 * Created by gaura on 22-08-2017.
 */

class SharedPrefsHelper(context: Context) {

    private var mSharedPreferences: SharedPreferences

    val email: String
        get() = mSharedPreferences.getString(EMAIL, null)

    var loggedInMode: Boolean
        get() = mSharedPreferences.getBoolean("IS_LOGGED_IN", false)
        set(loggedIn) = mSharedPreferences.edit().putBoolean("IS_LOGGED_IN", loggedIn).apply()

    init {
        mSharedPreferences = context.getSharedPreferences(MY_PREFS, MODE_PRIVATE)
    }

    fun clear() {
        mSharedPreferences.edit().clear().apply()
    }

    fun putEmail(email: String) {
        mSharedPreferences.edit().putString(EMAIL, email).apply()
    }

    companion object {

        val MY_PREFS = "MY_PREFS"

        val EMAIL = "EMAIL"
    }

}
