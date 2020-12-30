package com.example.verynb.ui.shop;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.verynb.R;
import com.example.verynb.app.Constants;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.interfaces.IBasePresenter;
import com.example.verynb.utils.BitmapUtils;
import com.example.verynb.utils.GlideEngine;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PingActivity extends BaseActivity {
    @BindView(R.id.et_text)
    EditText etText;
    @BindView(R.id.rlv)
    RecyclerView rlv;
    @BindView(R.id.img_addimg)
    ImageView imgAdd;
    @BindView(R.id.btn_ok)
    Button btnOk;
    private PingAdapter pingAdapter;
    private ArrayList<String> strings;

    @Override
    protected int getLayout() {
        return R.layout.activity_ping;
    }

    @Override
    protected IBasePresenter createPrenter() {
        return null;
    }

    @Override
    protected void initView() {
        strings = new ArrayList<>();
        rlv.setLayoutManager(new GridLayoutManager(PingActivity.this,3));
        pingAdapter = new PingAdapter(PingActivity.this,strings);
        rlv.setAdapter(pingAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.img_addimg, R.id.btn_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.img_addimg:
                openPhoto();
                break;
            case R.id.btn_ok:
                initBtn();
                break;
        }
    }

    private void initBtn() {
        String et = etText.getText().toString();
        if (TextUtils.isEmpty(et)){
            Toast.makeText(this, "评论不能为空", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("text",et);
        bundle.putStringArrayList("list",strings);
        intent.putExtra("bundle",bundle);
        setResult(200,intent);
        finish();
    }

    private void openPhoto() {
        PictureSelector.create(this)
                .openGallery(PictureMimeType.ofImage())
                .loadImageEngine(GlideEngine.createGlideEngine()) // Please refer to the Demo GlideEngine.java
                .maxSelectNum(1)
                .imageSpanCount(4)
                .selectionMode(PictureConfig.MULTIPLE)
                .forResult(PictureConfig.CHOOSE_REQUEST);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PictureConfig.CHOOSE_REQUEST:
                // onResult Callback
                List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                if (selectList.size() == 0) return;
                //获取本地图片的选择地址，上传到服务器
                //头像的压缩和二次采样
                //把选中的图片插入到列表


                for (int i = 0; i < selectList.size(); i++) {
                    String img = selectList.get(i).getPath();
                    strings.add(img);
                }
                pingAdapter.notifyDataSetChanged();
                if (strings.size()>=9){
                    imgAdd.setVisibility(View.GONE);
                }
                break;
            default:
                break;
        }
    }
}
