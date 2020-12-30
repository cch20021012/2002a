package com.example.verynb.ui.home;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.HomeBean;

import java.util.List;

public class TopicAdapter extends BaseAdapter {
    public TopicAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_topic_item;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        TextView tv_title = (TextView) vh.getViewById(R.id.tv_title);
        TextView tv_price = (TextView) vh.getViewById(R.id.tv_pricr);
        TextView tv_subtitle = (TextView) vh.getViewById(R.id.tv_subtitle);
        ImageView img_pic = (ImageView) vh.getViewById(R.id.img_pic);

        HomeBean.DataBean.TopicListBean topicListBean= (HomeBean.DataBean.TopicListBean) data;
        tv_title.setText(topicListBean.getTitle());
        tv_subtitle.setText(topicListBean.getSubtitle());
        tv_price.setText(topicListBean.getPrice_info()+"");
        Glide.with(context).load(topicListBean.getItem_pic_url()).into(img_pic);
    }
}
