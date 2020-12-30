package com.example.verynb.model.Home;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IHome;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

public class HomeModel extends BaseModel implements IHome.Model {
    @Override
    public void getHome(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getHome()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<HomeBean>(callback) {
            @Override
            public void onNext(HomeBean homeBean) {
                callback.success(homeBean);
            }
        }));
    }
}
