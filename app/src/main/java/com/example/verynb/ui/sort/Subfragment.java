package com.example.verynb.ui.sort;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.base.BaseFragment;
import com.example.verynb.interfaces.Sort.ISort;
import com.example.verynb.model.sort.CurrentBean;
import com.example.verynb.model.sort.SortBean;
import com.example.verynb.presenter.sort.SortPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class Subfragment extends BaseFragment<ISort.Presenter> implements ISort.View {

    @BindView(R.id.img_pic)
    ImageView imgPic;
    @BindView(R.id.tv_front_name)
    TextView tvFrontName;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.rlv_sub)
    RecyclerView rlvSub;
    private int id;
    private List<CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> list;
    private SubAdapter subAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_sort_sub;
    }

    @Override
    protected ISort.Presenter createPrenter() {
        return new SortPresenter();
    }

    @Override
    protected void initView() {
        list = new ArrayList<>();
        subAdapter = new SubAdapter(getActivity(), list);
        rlvSub.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rlvSub.setAdapter(subAdapter);

    }

    @Override
    protected void initData() {
        presenter.getCurrent(id);
    }

    @Override
    public void getSort(SortBean sortBean) {

    }

    @Override
    public void getCurrent(CurrentBean currentBean) {
        CurrentBean.DataBean.CurrentCategoryBean currentCategory = currentBean.getData().getCurrentCategory();
        Glide.with(getActivity()).load(currentCategory.getWap_banner_url()).into(imgPic);
        tvName.setText(currentCategory.getName());
        tvFrontName.setText("————"+currentCategory.getFront_name()+ "分类————");
        List<CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean> subCategoryList = currentBean.getData().getCurrentCategory().getSubCategoryList();
        list.clear();
        list.addAll(subCategoryList);
        subAdapter.notifyDataSetChanged();
        subAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                CurrentBean.DataBean.CurrentCategoryBean.SubCategoryListBean subCategoryListBean = list.get(pos);
                int id = currentBean.getData().getCurrentCategory().getId();
                String name = subCategoryListBean.getName();
                Intent intent = new Intent(getActivity(), SortSubActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("type",id+"");
                startActivity(intent);
            }
        });
    }
}
