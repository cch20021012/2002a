package com.example.verynb;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NeoActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp_main;
    private ViewpagerAdapter viewpagerAdapter;
    private Button btn_ok;
    private TextView tv_time;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neo);
        initView();
        initData();
    }

    private void initView() {
        vp_main = (ViewPager) findViewById(R.id.vp_main);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(this);
        tv_time = (TextView) findViewById(R.id.tv_time);

    }

    String[] str = {"四", "三", "二", "一"};
    int sum=0;
    private void initData() {
        View vp1 = LayoutInflater.from(this).inflate(R.layout.layout_vp_item1, null);
        View vp2 = LayoutInflater.from(this).inflate(R.layout.layout_vp_item2, null);
        View vp3 = LayoutInflater.from(this).inflate(R.layout.layout_vp_item3, null);
        ArrayList<View> views = new ArrayList<>();
        views.add(vp1);
        views.add(vp2);
        views.add(vp3);
        viewpagerAdapter = new ViewpagerAdapter(views, this);
        vp_main.setAdapter(viewpagerAdapter);
        timer = new Timer();

        vp_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    if (timer==null){
                        timer=new Timer();
                    }
                    tv_time.setVisibility(View.VISIBLE);
                    btn_ok.setVisibility(View.VISIBLE);
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (sum<4){
                                        tv_time.setText(str[sum]);
                                        sum++;
                                    }else {
                                        timer.cancel();
                                        startActivity(new Intent(NeoActivity.this,MainActivity.class));
                                    }
                                }
                            });
                        }
                    };
                    timer.schedule(timerTask,1000,1000);
                }else {
                    sum=0;
                    tv_time.setText("五");
                    tv_time.setVisibility(View.GONE);
                    btn_ok.setVisibility(View.GONE);
                    if (timer !=null){
                        timer.cancel();
                        timer=null;
                    }
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:
                timer.cancel();
                timer=null;
                startActivity(new Intent(this,MainActivity.class));
                break;
        }
    }
}