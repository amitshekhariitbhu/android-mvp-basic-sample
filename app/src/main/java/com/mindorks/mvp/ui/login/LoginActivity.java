package com.mindorks.mvp.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mindorks.mvp.MvpApp;
import com.mindorks.mvp.R;
import com.mindorks.mvp.data.DataManager;
import com.mindorks.mvp.ui.base.BaseActivity;
import com.mindorks.mvp.ui.main.MainActivity;


public class LoginActivity extends BaseActivity implements LoginMvpView {

    LoginPresenter loginPresenter;

    EditText editTextEmail,editTextPassword;

    Button button;

    public static Intent getStartIntent(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        DataManager dataManager = ((MvpApp)getApplication()).getDataManager();
        loginPresenter = new LoginPresenter(dataManager);

        loginPresenter.onAttach(this);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onLoginButtonClick();
            }
        });

        editTextEmail.setText(loginPresenter.showSavedEmail());
    }

    @Override
    public void openMainActivity() {
        Intent intent = MainActivity.getStartIntent(this);
        //intent.putExtra("EMAIL",emailId);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginButtonClick() {
        String emailId = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        if (password == null || password.isEmpty()){
            Toast.makeText(this,"Check Password",Toast.LENGTH_LONG).show();
            return;
        }
        if (emailId == null || emailId.isEmpty()){
            Toast.makeText(this,"Check Email",Toast.LENGTH_LONG).show();
            return;
        }

        loginPresenter.startLogin(emailId);
    }
}
