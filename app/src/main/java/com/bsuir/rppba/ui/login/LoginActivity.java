package com.bsuir.rppba.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.bsuir.rppba.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.LoginView {

    private LoginPresenter presenter = new LoginPresenter();
    private EditText loginEditText;
    private EditText passwordEditText;
    private Button singInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter.attachView(this);

        loginEditText = findViewById(R.id.login_edit_text);
        passwordEditText = findViewById(R.id.password_edit_text);
        singInButton = findViewById(R.id.sign_in_button);

        buttonOnClick();
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

    private void buttonOnClick (){
        singInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO authorization
            }
        });
    }

}
