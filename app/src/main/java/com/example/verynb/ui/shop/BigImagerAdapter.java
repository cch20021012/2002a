package com.example.verynb.ui.shop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;

import java.util.List;

public class BigImagerAdapter extends BaseAdapter {

    public BigImagerAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_bigimager_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String imglist= (String) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        Glide.with(context).load(imglist).into(img_pic);
    }
}
