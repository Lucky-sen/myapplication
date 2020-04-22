package com.sen.myapplication.bean;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 16:15
 * 内容描述:
 */
public class ShoppingCartBean {

    private int code;
    private List<CartBean> datas;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CartBean> getDatas() {
        return datas;
    }

    public void setDatas(List<CartBean> datas) {
        this.datas = datas;
    }
}
