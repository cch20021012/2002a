package com.example.verynb.ui.shop;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.IBasePresenter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class QuanpingActivity extends BaseActivity {
    @BindView(R.id.rlv)
    RecyclerView rlv;
    private QuanAdapter quanAdapter;
    private ArrayList<QingBean> qinglist;

    @Override
    protected int getLayout() {
        return R.layout.activity_quanping;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        qinglist = new ArrayList<>();
        quanAdapter = new QuanAdapter(this,qinglist);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        rlv.setAdapter(quanAdapter);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bundle");
        if (bundle!=null){
            ArrayList<String> list = bundle.getStringArrayList("list");
            String text = bundle.getString("text");
            QingBean qingBean = new QingBean();
            qingBean.setNaem(text);
            qingBean.setList(list);
            qinglist.add(qingBean);
            quanAdapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
