package com.example.verynb.model.Home;

import java.util.List;

public class GoodsRelatedBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"goodsList":[{"id":1045000,"name":"绿茶蛋黄酥 200克/4枚入","list_pic_url":"http://yanxuan.nosdn.127.net/b2adc3fd9b84a289a1be03e8ee400e61.png","retail_price":28},{"id":1070000,"name":"星云酥 180克/3颗","list_pic_url":"http://yanxuan.nosdn.127.net/8392725765cdd57fdae3f173877f4bda.png","retail_price":26},{"id":1111007,"name":"妙曲奇遇记曲奇礼盒 520克","list_pic_url":"http://yanxuan.nosdn.127.net/8d228f767b136a67aaf2cbbf6deb46fa.png","retail_price":78},{"id":1116011,"name":"蔓越莓曲奇 200克","list_pic_url":"http://yanxuan.nosdn.127.net/767b370d07f3973500db54900bcbd2a7.png","retail_price":36},{"id":1134036,"name":"凤梨酥 360克","list_pic_url":"http://yanxuan.nosdn.127.net/9356cc27b22bd47ad43913d13226555f.png","retail_price":38},{"id":1143018,"name":"粽情乡思端午粽礼盒 640克","list_pic_url":"http://yanxuan.nosdn.127.net/d1fd69cee4990f4de1109baef30efeeb.png","retail_price":68},{"id":1143019,"name":"粽夏冰晶端午粽礼盒 480克","list_pic_url":"http://yanxuan.nosdn.127.net/277b07c1e5e6fb57cf9ca47fcd3903d5.png","retail_price":98},{"id":1143020,"name":"粽横四海端午粽礼盒 800克","list_pic_url":"http://yanxuan.nosdn.127.net/200d4d59763af9a0781cca4a06175de7.png","retail_price":168}]}
     */

    private int errno;
    private String errmsg;
    private DataBean data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<GoodsListBean> goodsList;

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            /**
             * id : 1045000
             * name : 绿茶蛋黄酥 200克/4枚入
             * list_pic_url : http://yanxuan.nosdn.127.net/b2adc3fd9b84a289a1be03e8ee400e61.png
             * retail_price : 28
             */

            private int id;
            private String name;
            private String list_pic_url;
            private String retail_price;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getList_pic_url() {
                return list_pic_url;
            }

            public void setList_pic_url(String list_pic_url) {
                this.list_pic_url = list_pic_url;
            }

            public String getRetail_price() {
                return retail_price;
            }

            public void setRetail_price(String retail_price) {
                this.retail_price = retail_price;
            }
        }
    }
}
