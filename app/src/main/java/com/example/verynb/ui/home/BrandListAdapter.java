package com.example.verynb.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.BrandBean;

import java.util.List;

import butterknife.BindView;

public class BrandListAdapter extends BaseAdapter {

    public BrandListAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_brand_list_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        BrandBean.DataBeanX.DataBean dataBean= (BrandBean.DataBeanX.DataBean) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        TextView tv_name_price = (TextView) vh.getViewById(R.id.tv_name_price);
        tv_name_price.setText(dataBean.getName()+" | "+dataBean.getFloor_price());
        Glide.with(context).load(dataBean.getApp_list_pic_url()).into(img_pic);
    }
}
