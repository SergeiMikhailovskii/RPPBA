package com.bsuir.rppba.ui.login;

import android.util.Log;

import com.bsuir.rppba.ui.base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void logInUser(String login, String password) {
        Log.i(TAG, "Login " + login);
        Log.i(TAG, "Password " + password);

        //TODO implement API call

        view.onLoginSuccess();

    }

}
