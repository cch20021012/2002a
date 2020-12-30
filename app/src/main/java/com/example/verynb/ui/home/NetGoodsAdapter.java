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

public class NetGoodsAdapter extends BaseAdapter {
    public NetGoodsAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_goods_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.NewGoodsListBean goodsListBean = (HomeBean.DataBean.NewGoodsListBean) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        TextView tv_price = (TextView) vh.getViewById(R.id.tv_price);

        tv_name.setText(goodsListBean.getName());
        tv_price.setText("￥"+goodsListBean.getRetail_price());
        Glide.with(context).load(goodsListBean.getList_pic_url()).into(img_pic);
    }
}
