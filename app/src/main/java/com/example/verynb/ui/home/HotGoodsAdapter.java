package com.example.verynb.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.HomeBean;

import java.util.List;

public class HotGoodsAdapter extends BaseAdapter {
    public HotGoodsAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_hotgoods_list;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        TextView tv_drief = (TextView) vh.getViewById(R.id.tv_drief);
        TextView tv_price = (TextView) vh.getViewById(R.id.tv_price);
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);

        HomeBean.DataBean.HotGoodsListBean hotGoodsList= (HomeBean.DataBean.HotGoodsListBean) data;
        tv_name.setText(hotGoodsList.getName());
        tv_drief.setText(hotGoodsList.getGoods_brief());
        tv_price.setText("￥"+hotGoodsList.getRetail_price());
        Glide.with(context).load(hotGoodsList.getList_pic_url()).into(img_pic);
    }
}
