package com.example.verynb.model.shop;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.shop.IShop;
import com.example.verynb.model.Home.GoodDetailBean;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

import java.util.Map;

public class ShopModel extends BaseModel implements IShop.Model {
    @Override
    public void getGoodDetail(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getGoodDetail(id).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodDetailBean>(callback) {
                    @Override
                    public void onNext(GoodDetailBean goodDetailBean) {
                        callback.success(goodDetailBean);
                    }
                }));
    }

    @Override
    public void getGoodRelated(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getGoodRelated(id).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<GoodRelatedBean>(callback) {
                    @Override
                    public void onNext(GoodRelatedBean goodRelatedBean) {
                        callback.success(goodRelatedBean);
                    }
                }));
    }

    // 添加进购物车
    @Override
    public void addGoodCar(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().addCar(map).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<AddCarBean>(callback) {
                    @Override
                    public void onNext(AddCarBean addCarBean) {
                        callback.success(addCarBean);
                    }
                }));
    }
}
