package com.example.verynb.model.Home;

import com.example.verynb.base.BaseModel;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IChannel;
import com.example.verynb.net.CommonSubscriber;
import com.example.verynb.net.HttpManager;
import com.example.verynb.utils.RxUtils;

public class ChannelModel extends BaseModel implements IChannel.Model {
    @Override
    public void getChannel(String type, Callback callback) {
        addDisposible(HttpManager.getInstance().getChannelApi().getChannel(type)
        .compose(RxUtils.rxScheduler())
        .subscribeWith(new CommonSubscriber<ChannelBean>(callback) {
            @Override
            public void onNext(ChannelBean channelBean) {
                callback.success(channelBean);
            }
        }));
    }

    @Override
    public void getChannelType(int id, Callback callback) {
        addDisposible(HttpManager.getInstance().getChannelApi().getChannelType(id)
                .compose(RxUtils.rxScheduler())
                .subscribeWith(new CommonSubscriber<ChannelTypeBean>(callback) {
                    @Override
                    public void onNext(ChannelTypeBean channelBean) {
                        callback.success(channelBean);
                    }
                }));
    }
}
