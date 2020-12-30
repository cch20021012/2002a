package com.example.verynb.ui.me;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.verynb.R;
import com.example.verynb.base.BaseFragment;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.ui.login.LoginActivivty;
import com.example.verynb.utils.SpUtils;

;import butterknife.BindView;

public class MeFragment extends BaseFragment {
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.img_header)
    ImageView imgHeader;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.img_right)
    ImageView imgRight;

    @Override
    protected int getLayout() {
        return R.layout.fragment_me;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        imgHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),UserInfoDetailActivity.class));
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(getActivity(), LoginActivivty.class), 100);
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected void initData() {
        String token = SpUtils.getInstance().getString("token");
        if(!TextUtils.isEmpty(token)){
            isLogin(true);
        }else{
            isLogin(false);
        }
    }

    private void isLogin(boolean bool) {
        if (bool){

        }
    }
}
