package com.example.verynb.api;

import com.example.verynb.model.Home.GoodDetailBean;
import com.example.verynb.model.login.LoginBean;
import com.example.verynb.model.login.RegisterBean;
import com.example.verynb.model.me.UserInfoBean;
import com.example.verynb.model.shop.AddCarBean;
import com.example.verynb.model.shop.CarBean;
import com.example.verynb.model.shop.DeleteCarBean;
import com.example.verynb.model.shop.GoodRelatedBean;
import com.example.verynb.model.shop.UpdateCarBean;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ShopApi {
    //https://cdplay.cn/api/index
    String BASE_URL = "https://cdplay.cn/";

    //商品详情购买页
    @GET("api/goods/detail")
    Flowable<GoodDetailBean> getGoodDetail(@Query("id") int id);

    @GET("api/goods/related")
    Flowable<GoodRelatedBean> getGoodRelated(@Query("id") int id);

    @POST("api/auth/login")
    @FormUrlEncoded
    Flowable<LoginBean> login(@Field("username") String username, @Field("password") String pw);


    //添加到购物车
    @POST("api/cart/add")
    @FormUrlEncoded
    Flowable<AddCarBean> addCar(@FieldMap Map<String,String> map);

    //购物车列表
    @GET("api/cart/index")
    Flowable<CarBean> getCarList();

    //注册接口
    @POST("api/auth/register")
    @FormUrlEncoded
    Flowable<RegisterBean> getRegister(@Field("username") String username, @Field("password") String password);


    //更新购物车的数据
    @POST("api/cart/update")
    @FormUrlEncoded
    Flowable<UpdateCarBean> updateCar(@FieldMap Map<String,String> map);
    //删除购物车数据
    @POST("api/cart/delete")
    @FormUrlEncoded
    Flowable<DeleteCarBean> deleteCar(@Field("productIds") String productIds);

    //用户信息更新
    @POST("api/user/updateUserInfo")
    @FormUrlEncoded
    Flowable<UserInfoBean> updateUserInfo(@FieldMap Map<String,String> map);

}
