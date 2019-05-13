package com.peihou.mvp;

/**
 * 定义登录View层接口
 */
public interface LoginView {
    void showProgress();//显示视图动作
    void hideProgress();//隐藏视图动作
    void loginSuccess();//执行成功后的视图动作
    void loginFail();//执行失败后视图的动作
}
