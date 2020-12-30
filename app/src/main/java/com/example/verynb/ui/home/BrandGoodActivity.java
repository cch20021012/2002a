package com.example.verynb.ui.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.home.IBrand;
import com.example.verynb.model.Home.BrandBean;
import com.example.verynb.presenter.BrandPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BrandGoodActivity extends BaseActivity<IBrand.Presenter> implements IBrand.View {
    @BindView(R.id.img_pic)
    ImageView imgPic;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_simple_desc)
    TextView tvSimpleDesc;
    @BindView(R.id.vw)
    View vw;
    @BindView(R.id.rlv_brand)
    RecyclerView rlvBrand;
    private String id;
    private List<BrandGoodListBean.DataBeanX.DataBean> list;
    private BrandGoodAdapter brandGoodAdapter;

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_brand_good;
    }

    @Override
    protected IBrand.Presenter createPrenter() {
        return new BrandPresenter();
    }

    @Override
    protected void initView() {
        id = getIntent().getStringExtra("id");
        list = new ArrayList<>();
        brandGoodAdapter = new BrandGoodAdapter(this,list);
        rlvBrand.setLayoutManager(new GridLayoutManager(this,2));
        rlvBrand.setAdapter(brandGoodAdapter);
    }

    @Override
    protected void initData() {
        presenter.getBrandDetail(id);
        presenter.getBrandGood(id);
    }

    @Override
    public void getBrand(BrandBean brandBean) {

    }

    @Override
    public void getBrandGood(BrandGoodListBean brandGoodListBean) {
        List<BrandGoodListBean.DataBeanX.DataBean> data = brandGoodListBean.getData().getData();
        list.addAll(data);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                brandGoodAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void getBrandDetail(BrandDetailBean brandDetailBean) {
        BrandDetailBean.DataBean.BrandBean brand = brandDetailBean.getData().getBrand();
        tvName.setText(brand.getName());
        tvSimpleDesc.setText(brand.getSimple_desc());
        Glide.with(this).load(brand.getList_pic_url()).into(imgPic);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);

    }
}
