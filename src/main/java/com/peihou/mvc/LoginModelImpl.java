package com.peihou.mvc;

public class LoginModelImpl implements LoginModel{

    @Override
    public void login(String username, String password, OnLoginListener onLoginListener) {
        if ("user".equals(username) && "123".equals(password)){
            onLoginListener.loginSuccess();
        }else {
            onLoginListener.loginFail();
        }

    }
}
