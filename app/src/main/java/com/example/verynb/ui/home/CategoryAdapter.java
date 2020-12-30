package com.example.verynb.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.HomeBean;
import com.example.verynb.ui.shop.CarActivity;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends BaseAdapter {
    public CategoryAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_category_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        RecyclerView rlv_cat = (RecyclerView) vh.getViewById(R.id.rlv_cat);
        HomeBean.DataBean.CategoryListBean categoryListBean= (HomeBean.DataBean.CategoryListBean) data;
        tv_name.setText(categoryListBean.getName());
        List<HomeBean.DataBean.CategoryListBean.GoodsListBean>goodsList=new ArrayList<>();
        goodsList.addAll(categoryListBean.getGoodsList());
        GoodsAdapter goodsAdapter = new GoodsAdapter(context,goodsList);
        rlv_cat.setLayoutManager(new GridLayoutManager(context,2));
        rlv_cat.setAdapter(goodsAdapter);
        goodsAdapter.addListClick(new IListClick() {
            @Override
            public void itemClick(int pos) {
                Intent intent = new Intent(context, CarActivity.class);
                intent.putExtra("goodid",categoryListBean.getGoodsList().get(pos).getId());
                context.startActivity(intent);
            }
        });
    }
}
