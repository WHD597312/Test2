package com.peihou.mvc;

public class LoginViewImpl implements LoginView {
    @Override
    public void showProgress() {
        System.out.println("显示进度条");
    }

    @Override
    public void hideProgress() {
        System.out.println("隐藏进度条");
    }

    @Override
    public void loginSuccess() {
        System.out.println("登录成功");
    }

    @Override
    public void loginFail() {
        System.out.println("登录失败");
    }
}
