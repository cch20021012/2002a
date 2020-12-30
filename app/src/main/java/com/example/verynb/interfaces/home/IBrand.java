package com.example.verynb.interfaces.home;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.Home.BrandBean;
import com.example.verynb.model.Home.ChannelBean;
import com.example.verynb.model.Home.ChannelTypeBean;
import com.example.verynb.ui.home.BrandDetailBean;
import com.example.verynb.ui.home.BrandGoodListBean;

public interface IBrand {
    interface View extends IBaseView {
        void getBrand(BrandBean brandBean);
        void getBrandGood(BrandGoodListBean brandGoodListBean);
        void getBrandDetail(BrandDetailBean brandDetailBean);
    }
    interface Presenter extends IBasePresenter<View> {
        void getBrand();
        void getBrandGood(String id);
        void getBrandDetail(String id);

    }
    interface Model extends IBaseModel {
        void getBrand( Callback callback);
        void getBrandGood(String id, Callback callback);
        void getBrandDetail(String id, Callback callback);
    }
}
