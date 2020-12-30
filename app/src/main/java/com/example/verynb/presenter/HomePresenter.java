package com.example.verynb.presenter;

import android.view.View;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IHome;
import com.example.verynb.model.Home.HomeBean;
import com.example.verynb.model.Home.HomeModel;

public class HomePresenter extends BasePresenter<IHome.View> implements IHome.Presenter {
    IHome.Model model;

    public HomePresenter() {
        model=new HomeModel();
    }

    @Override
    public void getHome() {
        mView.showLoading(View.VISIBLE);
        model.getHome(new Callback<HomeBean>() {
            @Override
            public void success(HomeBean data) {
                if (mView!=null){
                    mView.showLoading(View.GONE);
                    mView.getHomeReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

}
