package com.peihou.mvp;

/**
 * 定义登录Model接口
 */
public interface LoginModel {
    /**
     * Model处理数据结果的监听
     */
    interface OnLoginListener{
        void loginSuccess();
        void loginFail();
    }

    /**
     * Model处理数据及数据的处理结果监听
     * @param username
     * @param password
     * @param onLoginListener
     */
    void login(String username,String password,OnLoginListener onLoginListener);
}
