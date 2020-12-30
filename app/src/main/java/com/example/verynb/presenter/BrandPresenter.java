package com.example.verynb.presenter;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IBrand;
import com.example.verynb.model.Home.BrandBean;
import com.example.verynb.model.Home.BrandModel;
import com.example.verynb.ui.home.BrandDetailBean;
import com.example.verynb.ui.home.BrandGoodListBean;

public class BrandPresenter extends BasePresenter<IBrand.View> implements IBrand.Presenter {
    IBrand.Model model;

    public BrandPresenter() {
        model=new BrandModel();
    }

    @Override
    public void getBrand() {
        model.getBrand(new Callback<BrandBean>() {
            @Override
            public void success(BrandBean data) {
                if (mView!=null){
                    mView.getBrand(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getBrandGood(String id) {
        model.getBrandGood(id,new Callback<BrandGoodListBean>() {
            @Override
            public void success(BrandGoodListBean data) {
                if (mView!=null){
                    mView.getBrandGood(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getBrandDetail(String id) {
        model.getBrandDetail(id, new Callback<BrandDetailBean>() {
            @Override
            public void success(BrandDetailBean data) {
                if (mView!=null){
                    mView.getBrandDetail(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
