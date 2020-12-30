package com.example.verynb.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.login.ILogin;
import com.example.verynb.model.login.LoginBean;
import com.example.verynb.presenter.login.LoginPresenter;
import com.example.verynb.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivivty extends BaseActivity<ILogin.Presenter> implements ILogin.View {
    @BindView(R.id.input_username)
    EditText inputUsername;
    @BindView(R.id.input_pw)
    EditText inputPw;
    @BindView(R.id.img_pw)
    ImageView imgPw;
    @BindView(R.id.layout_pw)
    FrameLayout layoutPw;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.zhuce)
    TextView zhuce;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected ILogin.Presenter createPrenter() {
        return new LoginPresenter();
    }

    @Override
    protected void initView() {
        imgPw.setTag(1);
        zhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(LoginActivivty.this,RegisterActivity.class),100);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getLogin(LoginBean loginBean) {
        if (!TextUtils.isEmpty(loginBean.getData().getToken())) {
            SpUtils.getInstance().setValue("token", loginBean.getData().getToken());
            SpUtils.getInstance().setValue("uid", loginBean.getData().getUserInfo().getUid());
            SpUtils.getInstance().setValue("nickname",loginBean.getData().getUserInfo().getNickname());
            SpUtils.getInstance().setValue("avatar",loginBean.getData().getUserInfo().getAvatar());
            SpUtils.getInstance().setValue("username",loginBean.getData().getUserInfo().getUsername());
            SpUtils.getInstance().setValue("mark","");
            finish();
        }
    }

    @OnClick({R.id.btn_login, R.id.img_pw})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                login();
                break;
            case R.id.img_pw:
                int tag = (int) imgPw.getTag();
                if (tag == 1) {
                    imgPw.setImageResource(R.mipmap.ic_pw_open);
                    imgPw.setTag(2);
                    inputPw.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    imgPw.setImageResource(R.mipmap.ic_pw_close);
                    imgPw.setTag(1);
                    inputPw.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }

    private void login() {
        String username = inputUsername.getText().toString();
        String pw = inputPw.getText().toString();
        if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(pw)) {
            presenter.getLogin(username, pw);
        } else {
            Toast.makeText(this, "用户名密码不能为空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
