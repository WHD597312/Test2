package com.peihou.mvc;

import org.junit.Test;

public class LoginActivity implements LoginModel.OnLoginListener{
    LoginModel loginModel;
    LoginView loginView;
    public LoginActivity() {
        loginModel=new LoginModelImpl();
        loginView=new LoginViewImpl();
    }


    @Override
    public void loginSuccess() {
        loginView.hideProgress();
        loginView.loginSuccess();
    }
    @Override
    public void loginFail() {
        loginView.hideProgress();
        loginView.loginFail();
    }

    @Test
    public void test(){
        LoginActivity loginActivity=new LoginActivity();
        LoginModel loginModel=loginActivity.loginModel;
        loginModel.login("user","123",this);
    }
}
