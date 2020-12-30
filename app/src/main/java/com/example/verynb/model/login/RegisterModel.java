package com.example.verynb.model.login;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.login.IRegister;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

public class RegisterModel extends BaseModel implements IRegister.Model {
    @Override
    public void getRegister(String username, String pw, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getRegister(username,pw)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<RegisterBean>(callback) {
            @Override
            public void onNext(RegisterBean registerBean) {
                callback.success(registerBean);
            }
        }));
    }
}
