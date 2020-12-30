package com.example.verynb.presenter.login;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.login.ILogin;
import com.example.verynb.model.login.LoginBean;
import com.example.verynb.model.login.LoginModel;

public class LoginPresenter extends BasePresenter<ILogin.View> implements ILogin.Presenter {
    ILogin.Model model;

    public LoginPresenter() {
        model=new LoginModel();
    }

    @Override
    public void getLogin(String username, String pw) {
        model.getLogin(username, pw, new Callback() {
            @Override
            public void success(Object data) {
                if (mView!=null){
                    mView.getLogin((LoginBean) data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
