package com.example.verynb.presenter;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IChannel;
import com.example.verynb.model.Home.ChannelBean;
import com.example.verynb.model.Home.ChannelModel;
import com.example.verynb.model.Home.ChannelTypeBean;

public class ChannelPresenter extends BasePresenter<IChannel.View> implements IChannel.Presenter {
    IChannel.Model model;

    public ChannelPresenter() {
        model=new ChannelModel();
    }

    @Override
    public void getChannel(String type) {
        model.getChannel(type, new Callback<ChannelBean>() {
            @Override
            public void success(ChannelBean data) {
                if (mView!=null){
                    mView.getChannel(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getChannelType(int id) {
        model.getChannelType(id, new Callback<ChannelTypeBean>() {
            @Override
            public void success(ChannelTypeBean data) {
                if (mView!=null){
                    mView.getChannelType(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
