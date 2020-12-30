package com.example.verynb.presenter.shop;

import android.util.Log;
import android.view.View;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.shop.ICar;
import com.example.verynb.model.shop.CarBean;
import com.example.verynb.model.shop.CarModel;
import com.example.verynb.model.shop.DeleteCarBean;
import com.example.verynb.model.shop.UpdateCarBean;

import java.util.Map;

public class CarPresenter extends BasePresenter<ICar.View> implements ICar.Presenter {
    ICar.Model model;
    public CarPresenter() {
        model=new CarModel();
    }

    @Override
    public void getCarList() {
        mView.showLoading(View.VISIBLE);
        model.getCarList(new Callback<CarBean>() {
            @Override
            public void success(CarBean data) {
                if (mView!=null){
                    mView.showLoading(View.GONE);
                    mView.getCarListReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void updateCar(Map<String, String> map) {
        mView.showLoading(View.VISIBLE);
        model.updateCar(map,new Callback<UpdateCarBean>() {
            @Override
            public void success(UpdateCarBean data) {
                if(mView != null){
                    mView.showLoading(View.GONE);
                    mView.updateCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void deleteCar(String pIds) {
        mView.showLoading(View.VISIBLE);
        model.deleteCar(pIds,new Callback<DeleteCarBean>() {
            @Override
            public void success(DeleteCarBean data) {
                if(mView != null){
                    mView.showLoading(View.GONE);
                    Log.i("TAG","CarPresenter delete return:");
                    mView.deleteCarReturn(data);
                }
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
