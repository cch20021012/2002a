package com.example.verynb.model.login;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.login.ILogin;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

public class LoginModel extends BaseModel implements ILogin.Model {
    @Override
    public void getLogin(String username, String pw, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().login(username,pw)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<LoginBean>(callback) {
            @Override
            public void onNext(LoginBean loginBean) {
                callback.success(loginBean);
            }
        }));
    }
}
