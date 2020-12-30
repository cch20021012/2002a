package com.example.verynb.ui.shop;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.ChannelTypeBean;
import com.example.verynb.model.shop.GoodRelatedBean;

import java.util.List;

public class RelatedAdapter extends BaseAdapter {

    public RelatedAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_channeltype_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        TextView tv_price = (TextView) vh.getViewById(R.id.tv_price);
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        GoodRelatedBean.DataBean.GoodsListBean listBean= (GoodRelatedBean.DataBean.GoodsListBean) data;

        Glide.with(context).load(listBean.getList_pic_url()).into(img_pic);
        tv_name.setText(listBean.getName());
        tv_price.setText("￥"+listBean.getRetail_price());
    }
}
