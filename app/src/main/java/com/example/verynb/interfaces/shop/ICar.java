package com.example.verynb.interfaces.shop;


import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.shop.CarBean;
import com.example.verynb.model.shop.DeleteCarBean;
import com.example.verynb.model.shop.UpdateCarBean;

import java.util.Map;

public interface ICar {
    interface View extends IBaseView {
        void getCarListReturn(CarBean carBean);
        //更新 购物车
        void updateCarReturn(UpdateCarBean result);

        //删除购物车
        void deleteCarReturn(DeleteCarBean result);
    }

    interface Presenter extends IBasePresenter<View> {
        void getCarList();
        void  updateCar(Map<String,String> map);

        //删除购物车列表
        void deleteCar(String pIds);
    }


    interface Model extends IBaseModel {
        void getCarList(Callback callback);
        void updateCar(Map<String,String> map,Callback callback);

        void deleteCar(String pIds,Callback callback);
    }

}
