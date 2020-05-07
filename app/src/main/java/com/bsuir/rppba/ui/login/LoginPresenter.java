package com.bsuir.rppba.ui.login;

import android.util.Log;

import com.bsuir.rppba.data.api.LogisticsAPIFactory;
import com.bsuir.rppba.data.api.UserData;
import com.bsuir.rppba.data.entity.LoginUserBody;
import com.bsuir.rppba.ui.base.BasePresenter;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter extends BasePresenter<LoginContract.LoginView> implements LoginContract.LoginPresenter {

    private final String TAG = this.getClass().getSimpleName();

    @Override
    public void logInUser(String login, String password) {
        Log.i(TAG, "Login " + login);
        Log.i(TAG, "Password " + password);

        mCompositeDisposable.add(LogisticsAPIFactory.getInstance().getAPIService().loginUser(new LoginUserBody(login, password))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(it -> view.onLoginFail())
                .doOnSuccess(it -> {
                    UserData.setToken(it.getToken());
                    view.onLoginSuccess();
                })
                .subscribe());

    }

}
