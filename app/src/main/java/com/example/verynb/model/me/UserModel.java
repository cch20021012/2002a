package com.example.verynb.model.me;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.me.IUser;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

import java.util.Map;

public class UserModel extends BaseModel implements IUser.Model {
    @Override
    public void updateUserInfo(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().updateUserInfo(map)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<UserInfoBean>(callback) {
            @Override
            public void onNext(UserInfoBean userInfoBean) {
                callback.success(userInfoBean);
            }
        }));
    }
}
