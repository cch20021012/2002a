package com.example.verynb;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.verynb.ui.home.HomeFragment;
import com.example.verynb.ui.me.MeFragment;
import com.example.verynb.ui.shop.ShopFragment;
import com.example.verynb.ui.sort.SortFragment;
import com.example.verynb.ui.topic.TopicFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager vp_main;
    private TabLayout tl_main;
    private ConstraintLayout con_main;
    private ViewpagerAdapter viewpagerAdapter;
    private ViewPager vp_ld;
    private Button btn_ok;
    private TextView tv_time;
    private Timer timer;
    private ImageView img_1;
    private ImageView img_2;
    private ImageView img_3;
    private LinearLayout ll;
//    private BottomNavigationView bottomNavigationView;
//    private HomeFragment homeFragment;
//    private MeFragment mineFragment;
//    private ShopFragment shopFragment;
//    private SortFragment sortFragment;
//    private TopicFragment topicFragment;
//    private LinearLayout content;
//    private RadioButton home;
//    private RadioButton topic;
//    private RadioButton sort;
//    private RadioButton shop;
//    private RadioButton mine;
//    private RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
//        FragmentManager supportFragmentManager = getSupportFragmentManager();
//        homeFragment = new HomeFragment();
//        mineFragment = new MeFragment();
//        shopFragment = new ShopFragment();
//        sortFragment = new SortFragment();
//        topicFragment = new TopicFragment();
//        FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//        fragmentTransaction.add(R.id.content, homeFragment)
//                .add(R.id.content, topicFragment)
//                .add(R.id.content, sortFragment)
//                .add(R.id.content, shopFragment)
//                .add(R.id.content, mineFragment)
//                .hide(topicFragment)
//                .hide(sortFragment)
//                .hide(shopFragment)
//                .hide(mineFragment)
//                .commit();
    }

    String[] str = {"四", "三", "二", "一"};
    int sum = 0;

    private void initView() {


        vp_main = (ViewPager) findViewById(R.id.vp_main);
        tl_main = (TabLayout) findViewById(R.id.tl_main);
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new TopicFragment());
        fragments.add(new SortFragment());
        fragments.add(new ShopFragment());
        fragments.add(new MeFragment());
        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
        tl_main.setupWithViewPager(vp_main);
        tl_main.getTabAt(0).setText("首页");
        tl_main.getTabAt(1).setText("专题");
        tl_main.getTabAt(2).setText("分类");
        tl_main.getTabAt(3).setText("购物车");
        tl_main.getTabAt(4).setText("我的");


//        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                FragmentManager supportFragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = supportFragmentManager.beginTransaction();
//                switch (checkedId){
//                    case R.id.home:
//                        fragmentTransaction.hide(topicFragment)
//                                .hide(sortFragment)
//                                .hide(shopFragment)
//                                .hide(mineFragment)
//                                .show(homeFragment).commit();
//                        break;
//                    case R.id.topic:
//                        fragmentTransaction.hide(homeFragment)
//                                .hide(sortFragment)
//                                .hide(shopFragment)
//                                .hide(mineFragment)
//                                .show(topicFragment).commit();
//                        break;
//                    case R.id.sort:
//                        fragmentTransaction.hide(homeFragment)
//                                .hide(topicFragment)
//                                .hide(shopFragment)
//                                .hide(mineFragment)
//                                .show(sortFragment).commit();
//                        break;
//                    case R.id.shop:
//                        fragmentTransaction.hide(homeFragment)
//                                .hide(sortFragment)
//                                .hide(topicFragment)
//                                .hide(mineFragment)
//                                .show(shopFragment).commit();
//                        break;
//                    case R.id.mine:
//                        fragmentTransaction.hide(topicFragment)
//                                .hide(sortFragment)
//                                .hide(shopFragment)
//                                .hide(homeFragment)
//                                .show(mineFragment).commit();
//                        break;
//
//
//                }
//            }
//        });


//        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_topic, R.id.navigation_sort, R.id.navigation_shop, R.id.navigation_me)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(bottomNavigationView, navController);

//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                switch (item.getItemId()){
//                    case R.id.navigation_home:
//                        item.setIcon(R.mipmap.ic_menu_choice_pressed);
//                        break;
//                    case R.id.navigation_topic:
//                        item.setIcon(R.mipmap.ic_menu_topic_pressed);
//                        break;
//                    case R.id.navigation_sort:
//                        item.setIcon(R.mipmap.ic_menu_sort_pressed);
//                        break;
//                    case R.id.navigation_shop:
//                        item.setIcon(R.mipmap.ic_menu_shoping_pressed);
//                        break;
//                    case R.id.navigation_me:
//                        item.setIcon(R.mipmap.ic_menu_me_pressed);
//                        break;
//                }
//                return true;
//            }
//        });

//        content = (LinearLayout) findViewById(R.id.content);
//        home = (RadioButton) findViewById(R.id.home);
//        topic = (RadioButton) findViewById(R.id.topic);
//        sort = (RadioButton) findViewById(R.id.sort);
//        shop = (RadioButton) findViewById(R.id.shop);
//        mine = (RadioButton) findViewById(R.id.mine);
//        radiogroup = (RadioGroup) findViewById(R.id.radiogroup);

        con_main = (ConstraintLayout) findViewById(R.id.con_main);
        vp_ld = (ViewPager) findViewById(R.id.vp_ld);
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_ok.setOnClickListener(this);
        tv_time = (TextView) findViewById(R.id.tv_time);
        initCCh();
        img_1 = (ImageView) findViewById(R.id.img_1);
        img_2 = (ImageView) findViewById(R.id.img_2);
        img_3 = (ImageView) findViewById(R.id.img_3);
        ll = (LinearLayout) findViewById(R.id.ll);
    }

    private void initCCh() {
        View vp1 = LayoutInflater.from(this).inflate(R.layout.layout_vp_item1, null);
        View vp2 = LayoutInflater.from(this).inflate(R.layout.layout_vp_item2, null);
        View vp3 = LayoutInflater.from(this).inflate(R.layout.layout_vp_item3, null);
        ArrayList<View> views = new ArrayList<>();
        views.add(vp1);
        views.add(vp2);
        views.add(vp3);
        viewpagerAdapter = new ViewpagerAdapter(views, this);
        vp_ld.setAdapter(viewpagerAdapter);
        timer = new Timer();

        vp_ld.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    img_1.setImageResource(R.drawable.selec);
                    img_2.setImageResource(R.drawable.noselect);
                    img_3.setImageResource(R.drawable.noselect);
                    sum = 0;
                    tv_time.setText("五");
                    tv_time.setVisibility(View.GONE);
                    btn_ok.setVisibility(View.GONE);
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                }else if (position==1){
                    img_1.setImageResource(R.drawable.noselect);
                    img_2.setImageResource(R.drawable.selec);
                    img_3.setImageResource(R.drawable.noselect);
                    sum = 0;
                    tv_time.setText("五");
                    tv_time.setVisibility(View.GONE);
                    btn_ok.setVisibility(View.GONE);
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                }else if (position == 2) {
                    img_1.setImageResource(R.drawable.noselect);
                    img_2.setImageResource(R.drawable.noselect);
                    img_3.setImageResource(R.drawable.selec);
                    if (timer == null) {
                        timer = new Timer();
                    }
                    tv_time.setVisibility(View.VISIBLE);
                    btn_ok.setVisibility(View.VISIBLE);
                    TimerTask timerTask = new TimerTask() {
                        @Override
                        public void run() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (sum < 4) {
                                        tv_time.setText(str[sum]);
                                        sum++;
                                    } else {
                                        timer.cancel();
                                        ll.setVisibility(View.GONE);
                                        btn_ok.setVisibility(View.GONE);
                                        tv_time.setVisibility(View.GONE);
                                        vp_ld.setVisibility(View.GONE);
                                        con_main.setVisibility(View.VISIBLE);
                                    }
                                }
                            });
                        }
                    };
                    timer.schedule(timerTask, 1000, 1000);
                } else {
                    ll.setVisibility(View.GONE);
                    sum = 0;
                    tv_time.setText("五");
                    tv_time.setVisibility(View.GONE);
                    btn_ok.setVisibility(View.GONE);
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
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
                timer = null;
                ll.setVisibility(View.GONE);
                btn_ok.setVisibility(View.GONE);
                tv_time.setVisibility(View.GONE);
                vp_ld.setVisibility(View.GONE);
                con_main.setVisibility(View.VISIBLE);
                break;
        }
    }
}