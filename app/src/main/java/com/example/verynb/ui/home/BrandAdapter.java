package com.example.verynb.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.HomeBean;

import org.w3c.dom.Text;

import java.util.List;

public class BrandAdapter extends BaseAdapter {

    public BrandAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_brand_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        HomeBean.DataBean.BrandListBean listBean = (HomeBean.DataBean.BrandListBean) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        Glide.with(context).load(listBean.getNew_pic_url()).into(img_pic);
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        TextView tv_pic = (TextView) vh.getViewById(R.id.tv_pic);

        tv_name.setText(listBean.getName());
        tv_pic.setText(listBean.getFloor_price());
    }
}
