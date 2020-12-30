package com.example.verynb.ui.shop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.viewpager.widget.ViewPager;

import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BIgImagerActivity extends BaseActivity {


    @BindView(R.id.tv_big_image_return)
    TextView tvBigImageReturn;
    @BindView(R.id.tv_big_image_count)
    TextView tvBigImageCount;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.mVp_big_image)
    ViewPager mVpBigImage;
    private ArrayList<String> list;
    private int pos;
    private BigImagerlistAdapter bigImagerlistAdapter;

    @Override
    protected int getLayout() {
        return R.layout.activity_bigimager;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("bundle")) {
            Bundle bundle = intent.getBundleExtra("bundle");
            if (bundle != null) {
                list = bundle.getStringArrayList("list");
                pos = bundle.getInt("pos");

            }
        }
        bigImagerlistAdapter = new BigImagerlistAdapter(this,list);
        mVpBigImage.setAdapter(bigImagerlistAdapter);//绑定适配器
        mVpBigImage.setCurrentItem(pos);//通过下标来改变集合里面的ViewPager的页面
        tvBigImageCount.setText(pos+1+"");
        mVpBigImage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tvBigImageCount.setText(position+1+"");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
