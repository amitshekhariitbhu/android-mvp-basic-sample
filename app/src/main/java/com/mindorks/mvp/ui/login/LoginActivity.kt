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

package com.mindorks.mvp.ui.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.mindorks.mvp.MvpApp
import com.mindorks.mvp.R
import com.mindorks.mvp.ui.main.MainActivity
import com.mindorks.mvp.utils.CommonUtils
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : Activity(), LoginMvpView {

    internal lateinit var loginPresenter: LoginPresenter<LoginMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val dataManager = (application as MvpApp).dataManager
        loginPresenter = LoginPresenter(dataManager)

        loginPresenter.onAttach(this)

        button.setOnClickListener { onLoginButtonClick() }

    }

    override fun openMainActivity() {
        val intent = MainActivity.getStartIntent(this)
        startActivity(intent)
        finish()
    }

    override fun onLoginButtonClick() {

        val emailId = editTextEmail.text.toString()
        val password = editTextPassword.text.toString()

        if (!CommonUtils.isEmailValid(emailId)) {
            Toast.makeText(this, "Enter correct Email", Toast.LENGTH_LONG).show()
            return
        }

        if (password.isEmpty()) {
            Toast.makeText(this, "Enter Password", Toast.LENGTH_LONG).show()
            return
        }

        loginPresenter.startLogin(emailId)

    }

    companion object {

        fun getStartIntent(context: Context): Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }
}
