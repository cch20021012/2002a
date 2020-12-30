package com.example.verynb.api;

import com.example.verynb.model.Home.BrandBean;
import com.example.verynb.model.Home.ChannelBean;
import com.example.verynb.model.Home.ChannelTypeBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChannelApi {



    String base_url="https://cdplay.cn/";
    @GET("api/catalog/index")
    Flowable<ChannelBean> getChannel(@Query("url")String rul);


    @GET("api/goods/list?page=1&size=200x")
    Flowable<ChannelTypeBean> getChannelType(@Query("categoryId")int categoryId);


}
