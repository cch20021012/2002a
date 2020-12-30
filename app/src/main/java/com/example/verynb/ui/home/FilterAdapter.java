package com.example.verynb.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.GoodListBean;

import java.util.List;

public class FilterAdapter extends BaseAdapter {
    public FilterAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_filter_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        GoodListBean.DataBeanX.FilterCategoryBean filterCategoryBean= (GoodListBean.DataBeanX.FilterCategoryBean) data;
        tv_name.setText(filterCategoryBean.getName());
    }
}
