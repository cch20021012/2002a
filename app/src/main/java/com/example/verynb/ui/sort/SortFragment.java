package com.example.verynb.ui.sort;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.verynb.R;
import com.example.verynb.base.BaseFragment;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.interfaces.Sort.ISort;
import com.example.verynb.model.sort.CurrentBean;
import com.example.verynb.model.sort.SortBean;
import com.example.verynb.presenter.sort.SortPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.ITabView;
import q.rorbin.verticaltablayout.widget.TabView;

public class SortFragment extends BaseFragment<ISort.Presenter> implements ISort.View{
    @BindView(R.id.vtl_main)
    VerticalTabLayout vtlMain;
    @BindView(R.id.vp_main)
    ViewPager vpMain;

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort;
    }

    @Override
    protected ISort.Presenter createPrenter() {
        return new SortPresenter();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        presenter.getSort();
    }

    @Override
    public void getSort(SortBean sortBean) {
        List<SortBean.DataBean.CategoryListBean> categoryList = sortBean.getData().getCategoryList();
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < categoryList.size(); i++) {
            SortBean.DataBean.CategoryListBean categoryListBean = categoryList.get(i);
            Subfragment subfragment = new Subfragment();
            Bundle bundle = new Bundle();
            int id = categoryListBean.getId();
            bundle.putInt("id",id);
            subfragment.setArguments(bundle);
            fragments.add(subfragment);
            strings.add(categoryListBean.getName());
        }
        vpMain.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
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

        vtlMain.setTabAdapter(new TabAdapter() {
            @Override
            public int getCount() {
                return strings.size();
            }

            @Override
            public ITabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public ITabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public ITabView.TabTitle getTitle(int position) {
                return null;
            }

            @Override
            public int getBackground(int position) {
                return 0;
            }
        });
        vtlMain.setupWithViewPager(vpMain);
        for (int i = 0; i < strings.size(); i++) {
            vtlMain.getTabAt(i).getTitleView().setText(strings.get(i));
        }
    }

    @Override
    public void getCurrent(CurrentBean currentBean) {

    }



}
