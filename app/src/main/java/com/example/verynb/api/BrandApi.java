package com.example.verynb.api;

import com.example.verynb.model.Home.BrandBean;
import com.example.verynb.ui.home.BrandDetailBean;
import com.example.verynb.ui.home.BrandGoodListBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BrandApi {

    String base_url="https://cdplay.cn/";
    @GET("api/brand/list?page=1&size=1000")
    Flowable<BrandBean> getBrand();

    //https://cdplay.cn/api/goods/list?brandId=1001000&page=1&size=1000
    //https://cdplay.cn/api/brand/detail?id=1001000
    @GET("api/goods/list?page=1&size=1000&")
    Flowable<BrandGoodListBean>getGoodList(@Query("brandId")String  brandId);

    @GET("brand/detail?")
    Flowable<BrandDetailBean> getBrandDetail(@Query("id")String id);
}
