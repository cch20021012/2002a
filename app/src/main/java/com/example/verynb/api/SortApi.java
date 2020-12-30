package com.example.verynb.api;

import com.example.verynb.model.sort.CurrentBean;
import com.example.verynb.model.sort.SortBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SortApi {
    //https://cdplay.cn/api/index
    String BASE_URL = "https://cdplay.cn/";


    @GET("api/catalog/index")
    Flowable<SortBean> getSort();
    //api/catalog/current?id=1005000
    @GET("api/catalog/current")
    Flowable<CurrentBean> getCurrent(@Query("id")int id);

}
