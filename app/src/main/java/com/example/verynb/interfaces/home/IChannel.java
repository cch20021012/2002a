package com.example.verynb.interfaces.home;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.Home.ChannelBean;
import com.example.verynb.model.Home.ChannelTypeBean;

public interface IChannel {
    interface View extends IBaseView{
        void getChannel(ChannelBean channelBean);
        void getChannelType(ChannelTypeBean channelTypeBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void getChannel(String type);
        void getChannelType(int id);
    }
    interface Model extends IBaseModel{
        void getChannel(String type, Callback callback);
        void getChannelType(int id,Callback callback);
    }
}
