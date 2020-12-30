package com.example.verynb.ui.sort;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.sort.CurrentBean;

import java.util.List;

public class SubAdapter extends BaseAdapter {

    public SubAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_sub_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean= (CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean) data;
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        tv_name.setText(subCategoryListBean.getName());
        Glide.with(context).load(subCategoryListBean.getWap_banner_url()).into(img_pic);
    }
}
