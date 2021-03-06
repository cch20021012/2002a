package com.example.verynb.ui.shop;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.model.shop.CarBean;
import com.example.verynb.utils.ImageLoader;
import com.example.verynb.widget.NumberSelect;

import java.util.List;

public class CarListAdapter extends BaseAdapter<CarBean.DataBean.CartListBean> {

    private boolean isEdit; //是否是编辑状态

    private UpdateItem updateItem;
    public void setUpdateItem(UpdateItem item){
        this.updateItem = item;
    }
    public void setEditState(boolean bool){
        isEdit = bool;
    }
    public CarListAdapter(Context context, List data) {
        super(context, data);
    }

    @Override
    protected int getLayout(int type) {
        return R.layout.rlv_car_list_item;
    }

    @Override
    protected void bindData(CarBean.DataBean.CartListBean data, VH vh) {

        CheckBox checkBox = (CheckBox) vh.getViewById(R.id.checkbox);
        ImageView imgItem = (ImageView) vh.getViewById(R.id.img_item);
        TextView txtName = (TextView) vh.getViewById(R.id.txt_name);
        TextView txtPrice = (TextView) vh.getViewById(R.id.txt_price);
        TextView txtNumber = (TextView) vh.getViewById(R.id.txt_number);
        TextView txtEditTitle = (TextView) vh.getViewById(R.id.txt_edit_title);
        NumberSelect numberSelect = (NumberSelect) vh.getViewById(R.id.layout_change);

        txtName.setVisibility(isEdit? View.GONE:View.VISIBLE);
        txtNumber.setVisibility(isEdit?View.GONE:View.VISIBLE);
        txtEditTitle.setVisibility(isEdit?View.VISIBLE:View.GONE);
        numberSelect.setVisibility(isEdit?View.VISIBLE:View.GONE);

        // 设置选中状态
        checkBox.setChecked(isEdit?data.selectEdit:data.selectOrder);
        Glide.with(context).load(data.getList_pic_url()).into(imgItem);
        txtName.setText(data.getGoods_name());
        txtPrice.setText("￥"+data.getRetail_price());
        txtNumber.setText("X "+String.valueOf(data.getNumber()));
        numberSelect.addPage(R.layout.layout_number_change);
        numberSelect.setNumber(data.getNumber());
        numberSelect.addChangeNumber(new NumberSelect.ChangeNumber() {
            @Override
            public void change(int number) {
                //修改本地数据得值
                data.setNumber(number);
                if(updateItem != null){
                    updateItem.updateItemDate(data);
                }
            }
        });

        checkBox.setTag(data.getId());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(iItemViewClick != null){
                    int id = (int) buttonView.getTag();
                    iItemViewClick.itemViewClick(id,isChecked);
                }
            }
        });

       /* if(isEdit){
            txtName.setVisibility(View.GONE);
            txtNumber.setVisibility(View.GONE);
            txtEditTitle.setVisibility(View.VISIBLE);
            numberSelect.setVisibility(View.VISIBLE);
        }else{
            txtName.setVisibility(View.VISIBLE);
            txtNumber.setVisibility(View.VISIBLE);
            txtEditTitle.setVisibility(View.GONE);
            numberSelect.setVisibility(View.GONE);
        }*/
    }
    public interface UpdateItem{
        void updateItemDate(CarBean.DataBean.CartListBean data);
    }
}
