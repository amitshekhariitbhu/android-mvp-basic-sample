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

package com.mindorks.mvp.ui.main

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

import com.mindorks.mvp.MvpApp
import com.mindorks.mvp.R
import com.mindorks.mvp.data.DataManager
import com.mindorks.mvp.ui.splash.SplashActivity
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by gaura on 23-08-2017.
 */

class MainActivity : Activity(), MainMvpView {

    internal lateinit var mainPresenter: MainPresenter<MainMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataManager = (application as MvpApp).dataManager
        mainPresenter = MainPresenter(dataManager)
        mainPresenter.onAttach(this)

        textViewShow.text = mainPresenter.emailId

        buttonLogout.setOnClickListener { mainPresenter.setUserLoggedOut() }

    }

    override fun openSplashActivity() {
        val intent = SplashActivity.getStartIntent(this)
        startActivity(intent)
        finish()
    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}
