package com.example.verynb.model.Home;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IHotGood;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

import java.util.HashMap;

public class HotGoodModel extends BaseModel implements IHotGood.Model {
    @Override
    public void getHot(Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getHotGood()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<HotGoodBean>(callback) {
            @Override
            public void onNext(HotGoodBean hotGoodBean) {
                callback.success(hotGoodBean);
            }
        }));
    }

    @Override
    public void getGoodlist(HashMap<String, String> map, Callback callback) {
        addDisposible(HttpManager.getInstance().getService().getHotGoodList(map)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<GoodListBean>(callback) {
            @Override
            public void onNext(GoodListBean goodListBean) {
                callback.success(goodListBean);
            }
        }));
    }

//    @Override
//    public void getGoodFl(String id, Callback callback) {
//        addDisposible(HttpManager.getInstance().getService().getHotGoodFL(id)
//                .compose(RxUtils.rxScheduler())
//                .subscribeWith(new CommonSubscriber<GoodListBean>(callback) {
//                    @Override
//                    public void onNext(GoodListBean goodListBean) {
//                        callback.success(goodListBean);
//                    }
//                }));
//    }
}
