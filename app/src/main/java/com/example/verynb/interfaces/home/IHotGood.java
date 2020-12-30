package com.example.verynb.interfaces.home;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.Home.GoodListBean;
import com.example.verynb.model.Home.HotGoodBean;

import java.util.HashMap;

public interface IHotGood {
    interface View extends IBaseView{
        void getHot(HotGoodBean hotGoodBean);
        void getGoodlist(GoodListBean goodListBean);
        //void getGoodFl(GoodListBean goodListBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void getHot();
        void getGoodList(HashMap<String,String> map);
        //void getGoodFl(String id);
    }
    interface Model extends IBaseModel{
        void getHot(Callback callback);
        void getGoodlist(HashMap<String,String> map,Callback callback);
        //void getGoodFl(String id,Callback callback);
    }
}
