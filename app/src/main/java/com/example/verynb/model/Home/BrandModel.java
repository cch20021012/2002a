package com.example.verynb.model.Home;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IBrand;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.ui.home.BrandDetailBean;
import com.example.verynb.ui.home.BrandGoodListBean;
import com.example.verynb.utils.RxUtils;

public class BrandModel extends BaseModel implements IBrand.Model {
    @Override
    public void getBrand(Callback callback) {
        addDisposible(HttpManager.getInstance().getBrandApi().getBrand()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<BrandBean>(callback) {
            @Override
            public void onNext(BrandBean brandBean) {
                callback.success(brandBean);
            }
        }));
    }

    @Override
    public void getBrandGood(String id, Callback callback) {
        addDisposible(HttpManager.getInstance().getBrandApi().getGoodList(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandGoodListBean>(callback) {
                    @Override
                    public void onNext(BrandGoodListBean brandGoodListBean) {
                        callback.success(brandGoodListBean);
                    }
                }));
    }

    @Override
    public void getBrandDetail(String id, Callback callback) {
        addDisposible(HttpManager.getInstance().getBrandApi().getBrandDetail(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<BrandDetailBean>(callback) {
                    @Override
                    public void onNext(BrandDetailBean brandDetailBean) {
                        callback.success(brandDetailBean);
                    }
                }));
    }
}
