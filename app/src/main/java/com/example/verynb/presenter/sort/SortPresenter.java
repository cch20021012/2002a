package com.example.verynb.presenter.sort;

import com.example.verynb.base.BasePresenter;
import com.example.verynb.interfaces.Callback;
import com.example.verynb.interfaces.Sort.ISort;
import com.example.verynb.model.sort.CurrentBean;
import com.example.verynb.model.sort.SortBean;
import com.example.verynb.model.sort.SortModel;

public class SortPresenter extends BasePresenter<ISort.View> implements ISort.Presenter {
    ISort.Model model;
    public SortPresenter() {
        model=new SortModel();
    }

    @Override
    public void getSort() {
        model.getSort(new Callback<SortBean>() {
            @Override
            public void success(SortBean data) {
                mView.getSort(data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }

    @Override
    public void getCurrent(int id) {
        model.getCurrent(id, new Callback<CurrentBean>() {
            @Override
            public void success(CurrentBean data) {
                mView.getCurrent(data);
            }

            @Override
            public void fail(String err) {

            }
        });
    }
}
