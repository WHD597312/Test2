package com.peihou.mvp;

/**
 * 实现登录Model接口,模拟登陆请求
 */
public class LoginModelImpl implements LoginModel {
    /**
     * 实现登录接口的具体操作
     * @param username
     * @param password
     * @param onLoginListener
     */
    @Override
    public void login(String username, String password, OnLoginListener onLoginListener) {
        if ("123".equals(username) && "123".equals(password)){
            onLoginListener.loginSuccess();
        }else {
            onLoginListener.loginFail();
        }
    }
}
