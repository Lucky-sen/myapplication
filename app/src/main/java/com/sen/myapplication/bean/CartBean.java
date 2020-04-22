package com.sen.myapplication.bean;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 16:11
 * 内容描述:
 */
public class CartBean {
    private String storeId;
    private String storeName;
    private boolean isSelectShop;      //店铺是否在购物车中被选中
    private List<GoodsBean> goods;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public boolean isSelectShop() {
        return isSelectShop;
    }

    public void setSelectShop(boolean selectShop) {
        isSelectShop = selectShop;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }
}
