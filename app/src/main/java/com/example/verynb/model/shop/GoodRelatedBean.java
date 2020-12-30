package com.example.verynb.model.shop;

import java.util.List;

public class GoodRelatedBean {

    /**
     * errno : 0
     * errmsg :
     * data : {"goodsList":[{"id":1009024,"name":"日式和风懒人沙发","list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png","retail_price":599},{"id":1015007,"name":"典雅美式全棉刺绣抱枕","list_pic_url":"http://yanxuan.nosdn.127.net/a2045004de8a6225289376ad54317fc8.png","retail_price":59},{"id":1020000,"name":"升级款记忆绵护椎腰靠","list_pic_url":"http://yanxuan.nosdn.127.net/819fdf1f635a694166bcfdd426416e8c.png","retail_price":79},{"id":1030001,"name":"160*230羊毛手工地毯","list_pic_url":"http://yanxuan.nosdn.127.net/88dc5d80c6f84102f003ecd69c86e1cf.png","retail_price":969},{"id":1030002,"name":"160*230羊毛圈绒枪刺地毯","list_pic_url":"http://yanxuan.nosdn.127.net/8b9328496990357033d4259fda250679.png","retail_price":899},{"id":1030003,"name":"160*230羊毛手工几何地毯","list_pic_url":"http://yanxuan.nosdn.127.net/1d1ab099dc0e254c15e57302e78e200b.png","retail_price":1469},{"id":1035006,"name":"全棉单面割绒浴室地垫","list_pic_url":"http://yanxuan.nosdn.127.net/ee92704f3b8323905b51fc647823e6e5.png","retail_price":56},{"id":1039051,"name":"多功能午睡枕","list_pic_url":"http://yanxuan.nosdn.127.net/c8ca0600fa7ba11ca8be6a3173dd38c9.png","retail_price":79}]}
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
             * id : 1009024
             * name : 日式和风懒人沙发
             * list_pic_url : http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png
             * retail_price : 599
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
