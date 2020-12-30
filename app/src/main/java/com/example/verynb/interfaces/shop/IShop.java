package com.example.verynb.interfaces.shop;


import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.Home.GoodDetailBean;
import com.example.verynb.model.shop.AddCarBean;
import com.example.verynb.model.shop.GoodRelatedBean;

import java.util.Map;

public interface IShop {
    interface View extends IBaseView {
        void getGoodDetail(GoodDetailBean goodDetailBean);
        void getGoodRelated(GoodRelatedBean goodRelatedBean);
        void addGoodCarReturn(AddCarBean addCarBean);
    }

    interface Presenter extends IBasePresenter<View> {
        void getGoodDetail(int id);
        void getGoodRelated(int id);
        //添加进购物车
        void addGoodCar(Map<String,String> map);
    }


    interface Model extends IBaseModel {
        void getGoodDetail(int id, Callback callback);
        void getGoodRelated(int id, Callback callback);
        //添加进购物车
        void addGoodCar(Map<String,String> map,Callback callback);
    }
}
