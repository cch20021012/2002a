package com.example.verynb.ui.shop;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;

import java.util.List;

public class PingAdapter extends BaseAdapter {
    public PingAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_ping_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        String path = (String) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        Glide.with(context).load(path).into(img_pic);
    }
}
