package com.example.verynb.presenter;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.home.IHotGood;
import com.example.verynb.model.Home.GoodListBean;
import com.example.verynb.model.Home.HotGoodBean;
import com.example.verynb.model.Home.HotGoodModel;

import java.util.HashMap;

public class HotGoodPresenter extends BasePresenter<IHotGood.View> implements IHotGood.Presenter{
    IHotGood.Model model;

    public HotGoodPresenter() {
        model=new HotGoodModel();
    }

    @Override
    public void getHot() {
        model.getHot(new Callback<HotGoodBean>() {
            @Override
            public void success(HotGoodBean data) {
                if (mView!=null){
                    mView.getHot(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getGoodList(HashMap<String, String> map) {
        model.getGoodlist(map, new Callback<GoodListBean>() {
            @Override
            public void success(GoodListBean data) {
                if (mView!=null){
                    mView.getGoodlist(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
