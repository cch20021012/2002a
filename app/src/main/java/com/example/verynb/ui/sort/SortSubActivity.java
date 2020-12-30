package com.example.verynb.ui.sort;

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
import com.example.verynb.ui.home.ChannelFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class SortSubActivity extends BaseActivity<ChannelPresenter> implements IChannel.View {

    @BindView(R.id.tab_main)
    TabLayout tabMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;
    private String type;
    private String name;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

    }

    @Override
    protected void initData() {
        type = getIntent().getStringExtra("type");
        name = getIntent().getStringExtra("name");
        presenter.getChannel(type);
    }

    @Override
    public void getChannel(ChannelBean channelBean) {
        List<ChannelBean.DataBean.CurrentCategoryBean.SubCategoryListBean> categoryList = channelBean.getData().getCurrentCategory().getSubCategoryList();
        ArrayList<Fragment> fragments = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            ChannelBean.DataBean.CurrentCategoryBean.SubCategoryListBean categoryListBean = categoryList.get(i);
            Bundle bundle = new Bundle();
            bundle.putInt("id",categoryListBean.getId());
            bundle.putString("name",categoryListBean.getName());
            bundle.putString("front_desc",categoryListBean.getFront_desc());
            ChannelFragment channelFragment = new ChannelFragment();
            channelFragment.setArguments(bundle);
            fragments.add(channelFragment);
        }
        vpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tabMain.setupWithViewPager(vpMain);
        for (int i = 0; i < categoryList.size(); i++) {
            ChannelBean.DataBean.CurrentCategoryBean.SubCategoryListBean categoryListBean = categoryList.get(i);
            tabMain.getTabAt(i).setText(categoryListBean.getName());
        }
        for (int i = 0; i < categoryList.size(); i++) {
            if (name.equals(categoryList.get(i).getName())){
                tabMain.getTabAt(i).select();
                return;
            }
        }
    }

    @Override
    public void getChannelType(ChannelTypeBean channelTypeBean) {

    }
}
