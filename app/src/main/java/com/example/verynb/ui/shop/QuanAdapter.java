package com.example.verynb.ui.shop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;

import java.util.List;

public class QuanAdapter extends BaseAdapter {
    public QuanAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv__quanping;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        QingBean qingBean = (QingBean) data;
        TextView tv_text = (TextView) vh.getViewById(R.id.tv_text);
        RecyclerView rlv = (RecyclerView) vh.getViewById(R.id.rlv);
        tv_text.setText(qingBean.getNaem());
        PingAdapter pingAdapter = new PingAdapter(context, qingBean.getList());
        rlv.setLayoutManager(new GridLayoutManager(context,3));
        rlv.setAdapter(pingAdapter);
    }
}
