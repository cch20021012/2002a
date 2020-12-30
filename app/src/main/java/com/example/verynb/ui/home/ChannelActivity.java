package com.example.verynb.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.home.IChannel;
import com.example.verynb.model.Home.ChannelBean;
import com.example.verynb.model.Home.ChannelTypeBean;
import com.example.verynb.presenter.ChannelPresenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ChannelActivity extends BaseActivity<ChannelPresenter> implements IChannel.View {
    String type;
    private TabLayout tab_main;
    private ViewPager vp_main;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        type = getIntent().getStringExtra("type");
        name = getIntent().getStringExtra("name");
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_channel;
    }

    @Override
    protected ChannelPresenter createPrenter() {
        return new ChannelPresenter();
    }

    @Override
    protected void initView() {
        tab_main = (TabLayout) findViewById(R.id.tab_main);
        vp_main = (ViewPager) findViewById(R.id.vp_main);

    }

    @Override
    protected void initData() {
        presenter.getChannel(type);
    }

    @Override
    public void getChannel(ChannelBean channelBean) {
        List<ChannelBean.DataBean.CategoryListBean> categoryList = channelBean.getData().getCategoryList();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            ChannelBean.DataBean.CategoryListBean categoryListBean = categoryList.get(i);
            Bundle bundle = new Bundle();
            bundle.putInt("id",categoryListBean.getId());
            bundle.putString("name",categoryListBean.getName());
            bundle.putString("front_desc",categoryListBean.getFront_desc());
            ChannelFragment channelFragment = new ChannelFragment();
            channelFragment.setArguments(bundle);
            fragments.add(channelFragment);
        }
        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        tab_main.setupWithViewPager(vp_main);
        for (int i = 0; i < categoryList.size(); i++) {
            ChannelBean.DataBean.CategoryListBean categoryListBean = categoryList.get(i);
            tab_main.getTabAt(i).setText(categoryListBean.getName());
        }
        for (int i = 0; i < categoryList.size(); i++) {
            if (name.equals(categoryList.get(i).getName())){
                tab_main.getTabAt(i).select();
            }
        }
    }

    @Override
    public void getChannelType(ChannelTypeBean channelTypeBean) {

    }
}
