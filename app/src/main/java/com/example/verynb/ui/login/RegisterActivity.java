package com.example.verynb.ui.login;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.login.IRegister;
import com.example.verynb.model.login.RegisterBean;
import com.example.verynb.presenter.login.RegisterPresenter;
import com.example.verynb.utils.SpUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends BaseActivity<IRegister.Presenter> implements IRegister.View {
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_pw)
    EditText etPw;
    @BindView(R.id.et_pw1)
    EditText etPw1;
    @BindView(R.id.et_yz)
    EditText etYz;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private String username;

    @Override
    protected int getLayout() {
        return R.layout.activity_register;
    }

    @Override
    protected IRegister.Presenter createPrenter() {
        return new RegisterPresenter();
    }

    @Override
    protected void initView() {
        
    }

    @Override
    protected void initData() {

    }

    @Override
    public void getRegister(RegisterBean registerBean) {
        String errmsg = registerBean.getErrmsg();
        //if (!errmsg.equals("用户名已注册")){
        String token = registerBean.getData().getToken();
        if (!TextUtils.isEmpty(token)){
            SpUtils.getInstance().setValue(username,token);
            Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            finish();
        }

        //}else {
           // Toast.makeText(this, "用户名已存在", Toast.LENGTH_SHORT).show();
        //}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_ok)
    public void onViewClicked() {
        username = etUsername.getText().toString();
        String pw = etPw.getText().toString();
        String pw1 = etPw1.getText().toString();
        if (!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(pw)&&!TextUtils.isEmpty(pw1)){
            if (pw.equals(pw1)){
                String string = SpUtils.getInstance().getString(username);
                if (TextUtils.isEmpty(string)){
                    zhuce(username,pw);
                }else {
                    Toast.makeText(this, "该用户已注册", Toast.LENGTH_SHORT).show();
                    return;
                }
            }else {
                Toast.makeText(this, "俩次密码输入不一致", Toast.LENGTH_SHORT).show();
                return;
            }
        }else {
            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private void zhuce(String username, String pw) {
        presenter.getRegister(username,pw);
    }
}
