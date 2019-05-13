package com.peihou.mvp;

public class LoginPresentImpl implements LoginPresent,LoginModel.OnLoginListener {
    private LoginView loginView;
    private LoginModel loginModel;

    public LoginPresentImpl(LoginView loginView, LoginModel loginModel) {
        this.loginView = loginView;
        this.loginModel = loginModel;
    }

    /**
     * 持有者通知视图作出的动作
     */
    @Override
    public void loginSuccess() {
        loginView.hideProgress();
        loginView.loginSuccess();
    }

    /**
     * 持有者通知视图作出的动作
     */
    @Override
    public void loginFail() {
        loginView.hideProgress();
        loginView.loginFail();
    }

    /**
     * 持有者通知Model作出的动作
     * @param username
     * @param password
     */
    @Override
    public void doLogin(String username, String password) {
        loginModel.login(username,password,this);
    }
}
