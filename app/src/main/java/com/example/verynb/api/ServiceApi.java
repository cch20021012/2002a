package com.example.verynb.api;



import com.example.verynb.model.Home.GoodDetailBean;
import com.example.verynb.model.Home.GoodListBean;
import com.example.verynb.model.Home.HomeBean;
import com.example.verynb.model.Home.HotGoodBean;

import java.util.HashMap;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface ServiceApi {
    //https://cdplay.cn/api/index
    String BASE_URL = "https://cdplay.cn/";

    @GET("api/index")
    Flowable<HomeBean> getHome();


    @GET("api/goods/hot")
    Flowable<HotGoodBean> getHotGood();
    //新品发布的条件筛选数据接口
    @GET("api/goods/list")
    Flowable<GoodListBean> getHotGoodList(@QueryMap HashMap<String,String> map);
    //https://cdplay.cn/api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=price&categoryId=1011000
    @GET("api/goods/list?isNew=1&page=1&size =1000&order=asc&sort=price")
    Flowable<GoodListBean> getHotGoodFL(@Query("categoryId")String id);


}
