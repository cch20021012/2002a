package com.example.verynb.model.sort;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.Sort.ISort;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

public class SortModel extends BaseModel implements ISort.Model {
    @Override
    public void getSort(Callback callback) {
        addDisposible(HttpManager.getInstance().getSortApi().getSort()
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<SortBean>(callback) {
            @Override
            public void onNext(SortBean sortBean) {
                callback.success(sortBean);
            }
        }));
    }

    @Override
    public void getCurrent(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getSortApi().getCurrent(id)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<CurrentBean>(callback) {
            @Override
            public void onNext(CurrentBean currentBean) {
                callback.success(currentBean);
            }
        }));
    }
}
