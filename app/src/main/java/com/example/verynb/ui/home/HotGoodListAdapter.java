package com.example.verynb.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.GoodListBean;

import org.w3c.dom.Text;

import java.util.List;

public class HotGoodListAdapter extends BaseAdapter {

    public HotGoodListAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_hot_good_list_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        GoodListBean.DataBeanX.DataBean dataBean= (GoodListBean.DataBeanX.DataBean) data;
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);
        TextView tv_name = (TextView) vh.getViewById(R.id.tv_name);
        TextView tv_price = (TextView) vh.getViewById(R.id.tv_price);
        tv_name.setText(dataBean.getName());
        tv_price.setText(dataBean.getRetail_price());
        Glide.with(context).load(dataBean.getList_pic_url()).into(img_pic);
    }
}
