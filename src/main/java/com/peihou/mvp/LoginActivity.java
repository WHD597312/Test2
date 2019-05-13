package com.peihou.mvp;

public class LoginActivity implements LoginView {
    private LoginPresent loginPresent;
    public LoginActivity(){
        loginPresent=new LoginPresentImpl(this,new LoginModelImpl());
    }
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
        System.out.println("登录成功,跳转页面");
    }

    @Override
    public void loginFail() {
        System.out.println("登录失败,停留在登录页面");
    }

    public static void main(String[]args){
        LoginActivity loginActivity=new LoginActivity();
        String username="123";
        String password="123";
        LoginPresent loginPresent=loginActivity.loginPresent;
        loginPresent.doLogin(username,password);
    }
}
