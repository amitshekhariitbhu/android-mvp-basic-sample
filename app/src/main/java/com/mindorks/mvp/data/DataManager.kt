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

/**
 * Created by gaura on 22-08-2017.
 */

class DataManager(private var mSharedPrefsHelper: SharedPrefsHelper) {

    val emailId: String
        get() = mSharedPrefsHelper.email

    val loggedInMode: Boolean?
        get() = mSharedPrefsHelper.loggedInMode

    fun clear() {
        mSharedPrefsHelper.clear()
    }

    fun saveEmailId(email: String) {
        mSharedPrefsHelper.putEmail(email)
    }

    fun setLoggedIn() {
        mSharedPrefsHelper.loggedInMode = true
    }
}
