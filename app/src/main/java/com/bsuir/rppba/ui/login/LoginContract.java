package com.bsuir.rppba.ui.login;

import com.bsuir.rppba.ui.base.MvpPresenter;
import com.bsuir.rppba.ui.base.MvpView;

public interface LoginContract {

    interface LoginView extends MvpView {

        void onLoginSuccess();

        void onLoginFail();

    }

    interface LoginPresenter extends MvpPresenter<LoginView> {

        void logInUser(String login, String password);

    }

}
