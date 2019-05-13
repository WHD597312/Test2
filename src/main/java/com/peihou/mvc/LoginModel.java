package com.peihou.mvc;

public interface LoginModel {
    interface OnLoginListener{
        void loginSuccess();
        void loginFail();
    }
    void login(String username,String password,OnLoginListener onLoginListener);
}
