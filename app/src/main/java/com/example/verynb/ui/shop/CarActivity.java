package com.example.verynb.ui.shop;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.verynb.R;
import com.example.verynb.base.BaseActivity;
import com.example.verynb.base.BaseAdapter;
import com.example.verynb.interfaces.shop.IShop;
import com.example.verynb.model.Home.GoodDetailBean;
import com.example.verynb.model.shop.AddCarBean;
import com.example.verynb.model.shop.GoodRelatedBean;
import com.example.verynb.presenter.ShopPresenter;
import com.example.verynb.utils.TxtUtils;
import com.example.verynb.widget.NumberSelect;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CarActivity extends BaseActivity<IShop.Presenter> implements IShop.View {


    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.txt_assess)
    TextView txtAssess;
    @BindView(R.id.tv_spcs)
    TextView tvSpcs;
    @BindView(R.id.rlv_attribute)
    RecyclerView rlvAttribute;
    // @BindView(R.id.webView_car)
    WebView webViewCar;
    @BindView(R.id.rlv_issue)
    RecyclerView rlvIssue;
    @BindView(R.id.tv_dajia)
    TextView tvDajia;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;
    @BindView(R.id.img_collect)
    ImageView imgCollect;
    @BindView(R.id.layout_collect)
    FrameLayout layoutCollect;
    @BindView(R.id.img_car)
    ImageView imgCar;
    @BindView(R.id.txt_number)
    TextView txtNumber;
    @BindView(R.id.layout_car)
    FrameLayout layoutCar;
    @BindView(R.id.txt_buy)
    TextView txtBuy;
    @BindView(R.id.txt_addCar)
    TextView txtAddCar;
    @BindView(R.id.layout_shop)
    ConstraintLayout layoutShop;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.goods_brief)
    TextView goodsBrief;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.rlv_related)
    RecyclerView rlvRelated;
    @BindView(R.id.con_vis)
    ConstraintLayout conVis;
    @BindView(R.id.tv_vis)
    TextView tvVis;
    @BindView(R.id.rlv_bigimage)
    RecyclerView rlvBigimage;
    @BindView(R.id.tv_quan)
    TextView tvQuan;
    private String h5 = "<html>\n" +
            "            <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\"/>\n" +
            "            <head>\n" +
            "                <style>\n" +
            "                    p{\n" +
            "                        margin:0px;\n" +
            "                    }\n" +
            "                    img{\n" +
            "                        width:100%;\n" +
            "                        height:auto;\n" +
            "                    }\n" +
            "                </style>\n" +
            "            </head>\n" +
            "            <body>\n" +
            "                word\n" +
            "            </body>\n" +
            "        </html>";
    int buyNumber = 1; //购买的数量
    GoodDetailBean goodDetailBean;
    public static final int RECOMMEND_CAR = 1000; //打开购物车的指令

    private List<GoodDetailBean.DataBeanX.AttributeBean> attributelist;
    private AttributeAdapter attributeAdapter;
    private List<GoodRelatedBean.DataBean.GoodsListBean> relatedlist;
    private RelatedAdapter relatedAdapter;
    private GoodDetailBean.DataBeanX data;
    private BigImagerAdapter bigImagerAdapter;
    private String text;
    private ArrayList<String> pinglist;

    @Override
    protected int getLayout() {
        return R.layout.activity_car;
    }

    @Override
    public void showLoading(int visible) {
        super.showLoading(visible);
        TxtUtils.VisibilityText(tvVis, visible);
        if (tvVis.getVisibility() == View.GONE) {
            conVis.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected IShop.Presenter createPrenter() {
        return new ShopPresenter();
    }

    int arr = 1;

    @Override
    protected void initView() {
        attributelist = new ArrayList<>();
        attributeAdapter = new AttributeAdapter(this, attributelist);
        rlvAttribute.setLayoutManager(new LinearLayoutManager(this));
        rlvAttribute.setAdapter(attributeAdapter);

        relatedlist = new ArrayList<>();
        relatedAdapter = new RelatedAdapter(this, relatedlist);
        rlvRelated.setLayoutManager(new GridLayoutManager(this, 2));
        rlvRelated.setAdapter(relatedAdapter);

        txtAddCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arr == 2) {
                    addCar();
                    arr = 1;
                } else {
                    View root = LayoutInflater.from(CarActivity.this).inflate(R.layout.car_pop, null);
                    ImageView img_pic = root.findViewById(R.id.img_pic);
                    TextView tv_price = root.findViewById(R.id.tv_price);
                    NumberSelect layout_change = root.findViewById(R.id.layout_change);
                    layout_change.addPage(R.layout.layout_number_change);
                    layout_change.setNumber(buyNumber);
                    layout_change.addChangeNumber(new NumberSelect.ChangeNumber() {
                        @Override
                        public void change(int number) {
                            //修改本地数据得值
                            buyNumber = number;

                        }
                    });
                    TextView tv_type = root.findViewById(R.id.tv_type);
                    if (data.getGallery().size() > 0) {
                        Glide.with(CarActivity.this).load(data.getGallery().get(0).getImg_url()).into(img_pic);
                    }
                    tv_price.setText("价格：￥" + data.getInfo().getRetail_price());
                    tv_type.setText("请选择规格数量");
                    PopupWindow popupWindow = new PopupWindow(root, 2000, 400);
                    popupWindow.setBackgroundDrawable(new ColorDrawable());
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.showAtLocation(scrollView, Gravity.BOTTOM, 0, 160);
                    arr++;
                }

            }
        });
        txtAssess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(CarActivity.this, PingActivity.class), 100);
            }
        });

        tvQuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarActivity.this, QuanpingActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list",pinglist);
                bundle.putString("text",text);
                intent.putExtra("bundle",bundle);
                startActivity(intent);
            }
        });
        imgCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==100 && resultCode==200){
            Bundle bundle = data.getBundleExtra("bundle");
            text = bundle.getString("text");
            pinglist = bundle.getStringArrayList("list");

        }
    }

    private void addCar() {
        if (buyNumber <= 0) {
            Toast.makeText(this, "wqeqeqw", Toast.LENGTH_SHORT).show();
            return;
        }
        if (goodDetailBean.getData().getProductList().size() > 0) {
            int goodsId = this.goodDetailBean.getData().getProductList().get(0).getGoods_id();
            int productid = this.goodDetailBean.getData().getProductList().get(0).getId();
            Map<String, String> map = new HashMap<>();
            map.put("goodsId", String.valueOf(goodsId));
            map.put("number", String.valueOf(buyNumber));
            map.put("productId", String.valueOf(productid));
            presenter.addGoodCar(map);
        }

    }

    /**
     * 打开购物车
     */
    private void openGoodCar() {
        setResult(RECOMMEND_CAR);
        finish();
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        if (intent.hasExtra("goodid")) {

            int id = getIntent().getIntExtra("goodid", 0);
            if (id > 0) {
                presenter.getGoodDetail(id);
                presenter.getGoodRelated(id);
            } else {
                Toast.makeText(this, "id空", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "id空", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void getGoodDetail(GoodDetailBean goodDetailBean) {
        data = goodDetailBean.getData();
        this.goodDetailBean = goodDetailBean;
        if (goodDetailBean.getData().getInfo().getGoods_desc() != null) {
            initGoodDetail(goodDetailBean.getData().getInfo().getGoods_desc());
        }
        initBanner(goodDetailBean.getData().getGallery());
        initInFo(goodDetailBean.getData().getInfo());
        initAttribute(goodDetailBean.getData().getAttribute());
        //展示goods_desc
        showImage(goodDetailBean.getData().getInfo().getGoods_desc());
    }

    private void showImage(String goods_desc) {
        ArrayList<String> listUrl = new ArrayList<>();
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(goods_desc);

        while (matcher.find()) {
            String word = matcher.group();
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            if (end > 0) {//如果是jpg格式的就截取jpg
                String url = word.substring(start, end);
                if (url != null) {
                    url = url + ".jpg";
                    listUrl.add(url);
                } else {
                    return;
                }
            } else {
                int end1 = word.indexOf(".png");//如果是png格式的就截取png
                String url = word.substring(start, end1);
                if (url != null) {
                    url = url + ".png";
                    listUrl.add(url);
                } else {
                    return;
                }
            }
        }
        rlvBigimage.setLayoutManager(new LinearLayoutManager(CarActivity.this));
        bigImagerAdapter = new BigImagerAdapter(CarActivity.this, listUrl);
        rlvBigimage.setAdapter(bigImagerAdapter);
        bigImagerAdapter.addListClick(new BaseAdapter.IListClick() {
            @Override
            public void itemClick(int pos) {
                String s = listUrl.get(pos);
                Intent intent = new Intent(CarActivity.this, BIgImagerActivity.class);
                Bundle bundle = new Bundle();
                bundle.putStringArrayList("list", listUrl);
                bundle.putInt("pos", pos);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        });

    }

    private void initAttribute(List<GoodDetailBean.DataBeanX.AttributeBean> attribute) {
        attributelist.clear();
        attributelist.addAll(attribute);
        attributeAdapter.notifyDataSetChanged();
    }

    private void initInFo(GoodDetailBean.DataBeanX.InfoBean info) {
        tvName.setText(info.getName());
        tvPrice.setText(info.getRetail_price() + "");
        goodsBrief.setText(info.getGoods_brief());
    }

    private void initBanner(List<GoodDetailBean.DataBeanX.GalleryBean> gallery) {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < gallery.size(); i++) {
            GoodDetailBean.DataBeanX.GalleryBean galleryBean = gallery.get(i);
            String img_url = galleryBean.getImg_url();
            strings.add(img_url);
        }
        banner.setImages(strings).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context).load(path).into(imageView);
            }
        }).start();
    }

    @Override
    public void getGoodRelated(GoodRelatedBean goodRelatedBean) {
        List<GoodRelatedBean.DataBean.GoodsListBean> goodsList = goodRelatedBean.getData().getGoodsList();
        relatedlist.clear();
        relatedlist.addAll(goodsList);
        relatedAdapter.notifyDataSetChanged();
    }

    @Override
    public void addGoodCarReturn(AddCarBean addCarBean) {
        if (TextUtils.isEmpty(addCarBean.getErrmsg())) {
            Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "添加失败", Toast.LENGTH_SHORT).show();
        }
        int number = addCarBean.getData().getCartTotal().getGoodsCount();
        txtNumber.setText(String.valueOf(number));
        txtNumber.setVisibility(View.VISIBLE);
    }

    private void initGoodDetail(String webData) {
        //getHtmlImgs(webData);
        //String word = h5.replace("word", webData);
        //webViewCar.loadDataWithBaseURL("about:blank", word, "text/html", "utf-8", null);
    }

    private void getHtmlImgs(String content) {
        String img = "<img[\\s\\S]*?>";
        Pattern pattern = Pattern.compile(img);
        Matcher matcher = pattern.matcher(content);
        List<String> list = new ArrayList<>();
        while (matcher.find()) {
            String word = matcher.group();
            String fileType = ".jpg";
            int start = word.indexOf("\"") + 1;
            int end = word.indexOf(".jpg");
            if (end == -1) {
                end = word.indexOf(".png");
                fileType = ".png";
            }
            if (end == -1) continue;
            String url = word.substring(start, end);
            url = url + fileType;
            list.add(url);
        }
    }

}
