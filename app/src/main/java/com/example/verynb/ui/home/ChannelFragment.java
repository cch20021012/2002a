package com.example.verynb.ui.home;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.base.BaseFragment;
import com.example.verynb.interfaces.home.IChannel;
import com.example.verynb.model.Home.ChannelBean;
import com.example.verynb.model.Home.ChannelTypeBean;
import com.example.verynb.presenter.ChannelPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ChannelFragment extends BaseFragment<IChannel.Presenter> implements IChannel.View {
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_front_desc)
    TextView tvFrontDesc;
    @BindView(R.id.rlv_channel)
    RecyclerView rlvChannel;
    private int id;
    private String name;
    private String front_desc;
    private List<ChannelTypeBean.DataBeanX.DataBean> list;
    private ChannelTypeAdapter channelTypeAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
        name = getArguments().getString("name");
        front_desc = getArguments().getString("front_desc");
    }

    @Override
    protected int getLayout() {
        return R.layout.layout_fragmnet_channel;
    }

    @Override
    protected IChannel.Presenter createPrenter() {
        return new ChannelPresenter();
    }

    @Override
    protected void initView() {
        tvName.setText(name);
        tvFrontDesc.setText(front_desc);
        list = new ArrayList<>();
        channelTypeAdapter = new ChannelTypeAdapter(getActivity(),list);
        rlvChannel.setLayoutManager(new GridLayoutManager(getActivity(),2));
        rlvChannel.setAdapter(channelTypeAdapter);
    }

    @Override
    protected void initData() {
        presenter.getChannelType(id);
    }

    @Override
    public void getChannel(ChannelBean channelBean) {

    }

    @Override
    public void getChannelType(ChannelTypeBean channelTypeBean) {
        list.addAll(channelTypeBean.getData().getData());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                channelTypeAdapter.notifyDataSetChanged();
            }
        });
    }
}
