package com.example.verynb.ui.shop;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.Home.GoodDetailBean;

import java.util.List;

public class AttributeAdapter extends BaseAdapter {
    public AttributeAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_attribute;
    }

    @Override
    protected void bindData(Object data, VH vh) {
        GoodDetailBean.DataBeanX.AttributeBean attributeBean= (GoodDetailBean.DataBeanX.AttributeBean) data;
        TextView name = (TextView) vh.getViewById(R.id.name);
        TextView value = (TextView) vh.getViewById(R.id.value);
        name.setText(attributeBean.getName());
        value.setText(attributeBean.getValue());
    }
}
