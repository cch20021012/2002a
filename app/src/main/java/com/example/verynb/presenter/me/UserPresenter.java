package com.example.verynb.presenter.me;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.me.IUser;
import com.example.verynb.model.me.UserInfoBean;
import com.example.verynb.model.me.UserModel;

import java.util.Map;

public class UserPresenter extends BasePresenter<IUser.View> implements IUser.Presenter {
    IUser.Model model;

    public UserPresenter() {
        model=new UserModel();
    }

    @Override
    public void updateUserInfo(Map<String, String> map) {
        model.updateUserInfo(map, new Callback() {
            @Override
            public void success(Object data) {
                mView.updateUserInfoReturn((UserInfoBean) data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
