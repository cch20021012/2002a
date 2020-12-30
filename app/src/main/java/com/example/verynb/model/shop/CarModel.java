package com.example.verynb.model.shop;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.shop.ICar;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

import java.util.Map;

public class CarModel extends BaseModel implements ICar.Model {
    @Override
    public void getCarList(Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().getCarList()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<CarBean>(callback) {
            @Override
            public void onNext(CarBean carBean) {
                callback.success(carBean);
            }
        }));
    }

    @Override
    public void updateCar(Map<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().updateCar(map).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<UpdateCarBean>(callback) {
                    @Override
                    public void onNext(UpdateCarBean updateCarBean) {
                        callback.success(updateCarBean);
                    }
                }));
    }

    @Override
    public void deleteCar(String pIds, Callback callback) {
        addDisposible(HttpManager.getInstance().getShopApi().deleteCar(pIds).
                compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<DeleteCarBean>(callback) {
                    @Override
                    public void onNext(DeleteCarBean deleteCarBean) {
                        callback.success(deleteCarBean);
                    }
                }));
    }
}
