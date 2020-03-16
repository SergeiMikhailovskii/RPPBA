package com.bsuir.rppba.ui.login;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.bsuir.rppba.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private LoginPresenter presenter = new LoginPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.attachView(this);
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginFail() {

    }

    @Override
    public void showEmptyState(boolean value) {

    }

    @Override
    public void showLoadingIndicator(boolean value) {

    }

}
