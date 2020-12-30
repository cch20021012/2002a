package com.example.verynb.interfaces.Sort;

import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.IBaseModel;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.IBaseView;
import com.example.verynb.model.sort.CurrentBean;
import com.example.verynb.model.sort.SortBean;

public interface ISort {
    interface View extends IBaseView{
        void getSort(SortBean sortBean);
        void getCurrent(CurrentBean currentBean);
    }
    interface Presenter extends IBasePresenter<View>{
        void getSort();
        void getCurrent(int id);
    }
    interface Model extends IBaseModel{
        void getSort(Callback callback);
        void getCurrent(int id,Callback callback);
    }
}
