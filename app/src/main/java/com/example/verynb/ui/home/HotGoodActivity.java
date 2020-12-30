package com.example.verynb.ui.home;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.interfaces.home.IHotGood;
import com.example.verynb.model.Home.GoodListBean;
import com.example.verynb.model.Home.HotGoodBean;
import com.example.verynb.presenter.HotGoodPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotGoodActivity extends BaseActivity<IHotGood.Presenter> implements IHotGood.View {
    private static final String ASC = "asc";
    private static final String DESC = "desc";
    private static final String DEFAULT = "default";
    private static final String PRICE = "price";
    private static final String CATEGORY = "category";


    @BindView(R.id.img_hotgood)
    ImageView imgHotgood;
    @BindView(R.id.txt_info)
    TextView txtInfo;
    @BindView(R.id.layout_info)
    ConstraintLayout layoutInfo;
    @BindView(R.id.txt_all)
    TextView txtAll;
    @BindView(R.id.txt_price)
    TextView txtPrice;
    @BindView(R.id.img_arrow_up)
    ImageView imgArrowUp;
    @BindView(R.id.img_arrow_down)
    ImageView imgArrowDown;
    @BindView(R.id.layout_price)
    LinearLayout layoutPrice;
    @BindView(R.id.txt_sort)
    TextView txtSort;
    @BindView(R.id.layout_sort)
    ConstraintLayout layoutSort;
    @BindView(R.id.recy_goodList)
    RecyclerView recyGoodList;
    @BindView(R.id.rlv_pop)
    RecyclerView rlvPop;

    private int isNew = 1;
    private int page = 1;
    private int size = 100;
    private String order;
    private String sort;
    private int categoryId;
    private List<GoodListBean.DataBeanX.DataBean> list;
    private HotGoodListAdapter hotGoodListAdapter;
    private List<GoodListBean.DataBeanX.FilterCategoryBean> filterCategoryList;
    private FilterAdapter filterAdapter;

    @Override
    protected int getLayout() {
        return R.layout.layout_activity_hotgood;
    }

    @Override
    protected IHotGood.Presenter createPrenter() {
        return new HotGoodPresenter();
    }

    @SuppressLint("ResourceType")

    @Override
    protected void initView() {
        order = ASC;
        sort = DEFAULT;
        categoryId = 0;
        layoutPrice.setTag(0);
        txtAll.setTextColor(Color.parseColor(HotGoodActivity.this.getString(R.color.red)));

        list = new ArrayList<>();
        hotGoodListAdapter = new HotGoodListAdapter(this, list);
        recyGoodList.setLayoutManager(new GridLayoutManager(this, 2));
        recyGoodList.setAdapter(hotGoodListAdapter);


        filterCategoryList = new ArrayList<>();
        filterAdapter = new FilterAdapter(this,filterCategoryList);
        rlvPop.setLayoutManager(new GridLayoutManager(this,5));
        rlvPop.setAdapter(filterAdapter);

        filterAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                GoodListBean.DataBeanX.FilterCategoryBean filterCategoryBean = filterCategoryList.get(pos);
                int id = filterCategoryBean.getId();
                categoryId=id;
                sort = CATEGORY;
                presenter.getGoodList(getParam());
                filterAdapter.notifyDataSetChanged();
                rlvPop.setVisibility(View.GONE);
                isSelect=false;
            }
        });
    }

    @SuppressLint("ResourceType")
    @Override
    protected void initData() {
        presenter.getHot();
        resetPriceState();
        txtAll.setTextColor(Color.parseColor(HotGoodActivity.this.getString(R.color.red)));
        sort = DEFAULT;
        presenter.getGoodList(getParam());
    }
    boolean isSelect=false;
    @SuppressLint("ResourceType")
    @OnClick({R.id.layout_price, R.id.txt_all, R.id.txt_sort})
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.layout_price:
                int tag = (int) layoutPrice.getTag();
                if (tag == 0) {
                    resetPriceState();
                    priceStateUp();
                    layoutPrice.setTag(1);
                    order = ASC;
                } else if (tag == 1) {
                    resetPriceState();
                    priceStateDown();
                    layoutPrice.setTag(0);
                    order = DESC;
                }
                sort = PRICE;
                presenter.getGoodList(getParam());
                if (isSelect){
                    isSelect=false;
                    rlvPop.setVisibility(View.GONE);
                }
                break;
            case R.id.txt_all:
                resetPriceState();
                txtAll.setTextColor(Color.parseColor(HotGoodActivity.this.getString(R.color.red)));
                sort = DEFAULT;
                categoryId = 0;
                presenter.getGoodList(getParam());
                if (isSelect){
                    isSelect=false;
                    rlvPop.setVisibility(View.GONE);
                }
                break;
            case R.id.txt_sort:

                if (isSelect){
                    isSelect=false;
                }else {
                    isSelect=true;
                }

                if (isSelect){
                    rlvPop.setVisibility(View.VISIBLE);
                }else {
                    rlvPop.setVisibility(View.GONE);
                }
                resetPriceState();
                txtSort.setTextColor(Color.parseColor(HotGoodActivity.this.getString(R.color.red)));
                sort = CATEGORY;
                presenter.getGoodList(getParam());
                break;
        }
    }

    private HashMap<String, String> getParam() {
        HashMap<String, String> map = new HashMap<>();
        map.put("isNew", String.valueOf(isNew));
        map.put("page", String.valueOf(page));
        map.put("size", String.valueOf(size));
        map.put("order", order);
        map.put("sort", sort);
        map.put("categoryId", String.valueOf(categoryId));
        return map;
    }

    /**
     * 按价格升序排序
     */
    @SuppressLint("ResourceType")
    private void priceStateUp() {
        imgArrowUp.setImageResource(R.mipmap.ic_arrow_up_select);
        imgArrowDown.setImageResource(R.mipmap.ic_arrow_down_normal);
        txtPrice.setTextColor(Color.parseColor(getString(R.color.red)));
    }

    /**
     * 价格的降序排列
     */
    @SuppressLint("ResourceType")
    private void priceStateDown() {
        imgArrowUp.setImageResource(R.mipmap.ic_arrow_up_normal);
        imgArrowDown.setImageResource(R.mipmap.ic_arrow_down_select);
        txtPrice.setTextColor(Color.parseColor(getString(R.color.red)));
    }

    /**
     * 重置条件选择的所有状态
     */
    @SuppressLint("ResourceType")
    private void resetPriceState() {
        imgArrowUp.setImageResource(R.mipmap.ic_arrow_up_normal);
        imgArrowDown.setImageResource(R.mipmap.ic_arrow_down_normal);
        txtPrice.setTextColor(Color.parseColor(getString(R.color.black)));
        txtAll.setTextColor(Color.parseColor(getString(R.color.black)));
        txtSort.setTextColor(Color.parseColor(getString(R.color.black)));
        layoutPrice.setTag(0);
    }

    @Override
    public void getHot(HotGoodBean hotGoodBean) {
        HotGoodBean.DataBean.BannerInfoBean bannerInfo = hotGoodBean.getData().getBannerInfo();

        txtInfo.setText(bannerInfo.getName());
        Glide.with(this).load(bannerInfo.getImg_url()).into(imgHotgood);
    }

    @Override
    public void getGoodlist(GoodListBean goodListBean) {
        List<GoodListBean.DataBeanX.DataBean> data = goodListBean.getData().getData();
        list.clear();
        list.addAll(data);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hotGoodListAdapter.notifyDataSetChanged();
            }
        });
        List<GoodListBean.DataBeanX.FilterCategoryBean> filterCategory = goodListBean.getData().getFilterCategory();
        filterCategoryList.clear();
        filterCategoryList.addAll(filterCategory);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                filterAdapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
