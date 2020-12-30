package com.example.verynb.presenter.login;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.login.IRegister;
import com.example.verynb.model.login.RegisterBean;
import com.example.verynb.model.login.RegisterModel;

public class RegisterPresenter extends BasePresenter<IRegister.View> implements IRegister.Presenter {
    IRegister.Model model;
    public RegisterPresenter() {
        model=new RegisterModel();
    }

    @Override
    public void getRegister(String username, String pw) {
        model.getRegister(username, pw, new Callback<RegisterBean>() {
            @Override
            public void success(RegisterBean data) {
                if (mView!=null){
                    mView.getRegister(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
