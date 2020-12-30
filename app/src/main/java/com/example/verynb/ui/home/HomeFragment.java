package com.example.verynb.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.base.BaseFragment;
import com.example.verynb.interfaces.home.IHome;
import com.example.verynb.model.Home.HomeBean;
import com.example.verynb.presenter.HomePresenter;
import com.example.verynb.ui.shop.CarActivity;
import com.example.verynb.utils.TxtUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<IHome.Presenter> implements IHome.View {
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.txt_brand_title)
    TextView txtBrandTitle;
    @BindView(R.id.recy_brand)
    RecyclerView recyBrand;
    @BindView(R.id.txt_newgood_title)
    TextView txtNewgoodTitle;
    @BindView(R.id.recy_newgood)
    RecyclerView recyNewgood;
    TextView tv5;
    @BindView(R.id.txt_hot_title)
    TextView txtHotTitle;
    @BindView(R.id.rlv_hot)
    RecyclerView rlvHot;
    @BindView(R.id.txt_topic_title)
    TextView txtTopicTitle;
    @BindView(R.id.rlv_topic)
    RecyclerView rlvTopic;
    @BindView(R.id.rlv_category)
    RecyclerView rlvCategory;
    @BindView(R.id.layout_tab)
    LinearLayout layoutTab;
    @BindView(R.id.tv_vis)
    TextView tvVis;
    @BindView(R.id.ll_vis)
    LinearLayout llVis;
    private BrandAdapter brandAdapter;
    private List<HomeBean.DataBean.BrandListBean> brandList;
    private NetGoodsAdapter netgoodsAdapter;
    private List<HomeBean.DataBean.NewGoodsListBean> netgoodsList;
    private List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList;
    private HotGoodsAdapter hotGoodsAdapter;
    private List<HomeBean.DataBean.TopicListBean> topicList;
    private TopicAdapter topicAdapter;
    private List<HomeBean.DataBean.CategoryListBean> categoryList;
    private CategoryAdapter categoryAdapter;

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void showLoading(int visible) {
        super.showLoading(visible);
        TxtUtils.VisibilityText(tvVis, visible);
        if (tvVis.getVisibility()==View.GONE){
            llVis.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected IHome.Presenter createPrenter() {
        return new HomePresenter();
    }

    @Override
    protected void initView() {
        brandList = new ArrayList<>();
        brandAdapter = new BrandAdapter(getActivity(), brandList);
        recyBrand.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyBrand.setAdapter(brandAdapter);

        netgoodsList = new ArrayList<>();
        netgoodsAdapter = new NetGoodsAdapter(getActivity(), netgoodsList);
        recyNewgood.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyNewgood.setAdapter(netgoodsAdapter);

        hotGoodsList = new ArrayList<>();
        hotGoodsAdapter = new HotGoodsAdapter(getActivity(), hotGoodsList);
        rlvHot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvHot.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
        rlvHot.setAdapter(hotGoodsAdapter);

        topicList = new ArrayList<>();
        topicAdapter = new TopicAdapter(getActivity(), topicList);
        rlvTopic.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rlvTopic.setAdapter(topicAdapter);

        categoryList = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(getActivity(), categoryList);
        rlvCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rlvCategory.setAdapter(categoryAdapter);

        txtBrandTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), BrandActivity.class));
            }
        });

        txtNewgoodTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), HotGoodActivity.class));
            }
        });


    }

    @Override
    protected void initData() {
        presenter.getHome();
    }

    @Override
    public void getHomeReturn(HomeBean homeBean) {
        if (homeBean.getData() != null) {
            initBanner(homeBean.getData().getBanner());
            initChannel(homeBean.getData().getChannel());
            initBrand(homeBean.getData().getBrandList());
            initNewgood(homeBean.getData().getNewGoodsList());
            initHotGood(homeBean.getData().getHotGoodsList());
            initTopic(homeBean.getData().getTopicList());
            initCategory(homeBean.getData().getCategoryList());
        }
    }

    private void initCategory(List<HomeBean.DataBean.CategoryListBean> categoryList1) {
        categoryList.addAll(categoryList1);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                categoryAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initTopic(List<HomeBean.DataBean.TopicListBean> topicList1) {
        topicList.addAll(topicList1);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                topicAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initHotGood(List<HomeBean.DataBean.HotGoodsListBean> hotGoodsList1) {
        hotGoodsList.addAll(hotGoodsList1);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                hotGoodsAdapter.notifyDataSetChanged();
            }
        });
    }

    private void initNewgood(List<HomeBean.DataBean.NewGoodsListBean> newGoodsList) {
        netgoodsList.addAll(newGoodsList);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                netgoodsAdapter.notifyDataSetChanged();
            }
        });
        netgoodsAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                HomeBean.DataBean.NewGoodsListBean newGoodsListBean = newGoodsList.get(pos);
                Intent intent = new Intent(getActivity(), CarActivity.class);
                intent.putExtra("goodid", newGoodsListBean.getId());
                startActivity(intent);
            }
        });
    }

    private void initBrand(List<HomeBean.DataBean.BrandListBean> brandList1) {
        brandList.addAll(brandList1);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                brandAdapter.notifyDataSetChanged();
            }
        });
        brandAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                HomeBean.DataBean.BrandListBean listBean = brandList.get(pos);
                Intent intent = new Intent(getActivity(), BrandGoodActivity.class);
                intent.putExtra("id", listBean.getId() + "");
                startActivity(intent);
            }
        });

    }

    private void initChannel(List<HomeBean.DataBean.ChannelBean> ChannelList) {
        layoutTab.removeAllViews();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1);
        for (HomeBean.DataBean.ChannelBean item : ChannelList) {
            View channel = LayoutInflater.from(getContext()).inflate(R.layout.layout_channel_item, layoutTab, false);
            ImageView img = channel.findViewById(R.id.img_channel);
            TextView txtChannel = channel.findViewById(R.id.txt_channel);
            Glide.with(getActivity()).load(item.getIcon_url()).into(img);
            TxtUtils.setTextView(txtChannel, item.getName());
            txtChannel.setGravity(Gravity.CENTER);
            channel.setLayoutParams(params);
            layoutTab.addView(channel);
            channel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getActivity(), ChannelActivity.class);
                    intent.putExtra("type", item.getUrl());
                    intent.putExtra("name", item.getName());
                    startActivity(intent);
                }
            });
        }
    }

    private void initBanner(List<HomeBean.DataBean.BannerBean> bannerBeans) {
        banner.setImages(bannerBeans).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                HomeBean.DataBean.BannerBean data = (HomeBean.DataBean.BannerBean) path;
                String image_url = data.getImage_url();
                Glide.with(context).load(image_url).into(imageView);
            }
        }).start();
    }

}
