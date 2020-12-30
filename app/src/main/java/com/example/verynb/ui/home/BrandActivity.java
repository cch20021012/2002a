package com.example.verynb.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.interfaces.home.IBrand;
import com.example.verynb.model.Home.BrandBean;
import com.example.verynb.presenter.BrandPresenter;

import java.util.ArrayList;
import java.util.List;

public class BrandActivity extends BaseActivity<IBrand.Presenter> implements IBrand.View {
    private RecyclerView rlv_brand;
    private List<BrandBean.DataBeanX.DataBean> list;
    private BrandListAdapter brandListAdapter;

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_brand;
    }

    @Override
    protected IBrand.Presenter createPrenter() {
        return new BrandPresenter();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        brandListAdapter = new BrandListAdapter(this,list);
        rlv_brand= (RecyclerView)findViewById(R.id.rlv_brand);
        rlv_brand.setLayoutManager(new LinearLayoutManager(this));
        rlv_brand.setAdapter(brandListAdapter);

        brandListAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                BrandBean.DataBeanX.DataBean dataBean = list.get(pos);
                Intent intent = new Intent(BrandActivity.this, BrandGoodActivity.class);
                intent.putExtra("id",dataBean.getId()+"");
                startActivity(intent);
            }
        });
    }

    @Override
    protected void initData() {
        presenter.getBrand();
    }

    @Override
    public void getBrand(BrandBean brandBean) {
        List<BrandBean.DataBeanX.DataBean> data = brandBean.getData().getData();
        list.addAll(data);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                brandListAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getBrandGood(BrandGoodListBean brandGoodListBean) {

    }

    @Override
    public void getBrandDetail(BrandDetailBean brandDetailBean) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
