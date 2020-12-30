package com.example.verynb.interfaces.home;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.Home.HomeBean;


public interface IHome {
    interface View extends IBaseView {
        void getHomeReturn(HomeBean homeBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getHome();
    }


    interface Model extends IBaseModel {
        void getHome(Callback callback);
    }
}
