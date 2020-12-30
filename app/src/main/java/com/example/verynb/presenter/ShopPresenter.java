package com.example.verynb.presenter;

import android.view.View;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.shop.IShop;
import com.example.verynb.model.Home.GoodDetailBean;
import com.example.verynb.model.shop.AddCarBean;
import com.example.verynb.model.shop.GoodRelatedBean;
import com.example.verynb.model.shop.ShopModel;

import java.util.Map;

public class ShopPresenter extends BasePresenter<IShop.View> implements IShop.Presenter {
    IShop.Model model;

    public ShopPresenter() {
        model=new ShopModel();
    }

    @Override
    public void getGoodDetail(int id) {
        mView.showLoading(View.VISIBLE);
        model.getGoodDetail(id, new Callback<GoodDetailBean>() {
            @Override
            public void success(GoodDetailBean data) {
                if (mView!=null){
                    mView.showLoading(View.GONE);
                    mView.getGoodDetail(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getGoodRelated(int id) {
        model.getGoodRelated(id, new Callback<GoodRelatedBean>() {
            @Override
            public void success(GoodRelatedBean data) {
                if (mView!=null){
                    mView.getGoodRelated(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void addGoodCar(Map<String, String> map) {
        model.addGoodCar(map, new Callback<AddCarBean>() {
            @Override
            public void success(AddCarBean data) {
                if(mView != null){
                    mView.addGoodCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
