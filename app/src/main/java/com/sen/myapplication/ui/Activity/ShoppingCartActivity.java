package com.sen.myapplication.ui.Activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;
import com.sen.myapplication.bean.CartBean;
import com.sen.myapplication.bean.ShoppingCartBean;
import com.sen.myapplication.ui.adapter.ShoppingCartAdapter;

import java.util.List;

import butterknife.BindView;

/**
 * 作者：sen
 * 日期时间:
 * 内容描述:购物车界面
 */
public class ShoppingCartActivity extends BaseActivity {

    @BindView(R.id.expand_list_view)
    ExpandableListView cartListView;
    @BindView(R.id.checkbox_all)
    CheckBox checkBoxAll;
    @BindView(R.id.tv_sum)
    TextView tvSum;
    @BindView(R.id.btn_pay)
    Button btnPay;

    private ShoppingCartAdapter adapter;
    private List<CartBean> datas;


    @Override
    protected int getLayout() {
        return R.layout.activity_shopping_cart;
    }

    @Override
    protected void initView() {
        
    }

    @Override
    protected void initData() {
        Gson gosn = new Gson();
        ShoppingCartBean shoppingCartBean = gosn.fromJson(shoppingCarData, ShoppingCartBean.class);
        datas = shoppingCartBean.getDatas();
        adapter = new ShoppingCartAdapter(this, datas);
        cartListView.setAdapter(adapter);
        expandAllGroup();
        cartListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //消费点击GroupItem的事件
                return true;
            }
        });
        //去掉系统的箭头
        cartListView.setGroupIndicator(null);

    }

    /**
     * 展开所有的Group
     */
    private void expandAllGroup(){
        for(int i=0;i< datas.size();i++){
            cartListView.expandGroup(i);
        }
    }


    //模拟的购物车数据（实际开发中使用后台返回的数据）
    private String shoppingCarData = "{\n" +
            "    \"code\": 200,\n" +
            "    \"datas\": [\n" +
            "        {\n" +
            "            \"goods\": [\n" +
            "                {\n" +
            "                    \"goods_id\": \"111111\",\n" +
            "                    \"goods_image\": \"http://pic.58pic.com/58pic/15/62/69/34K58PICbmZ_1024.jpg\",\n" +
            "                    \"goods_name\": \"三国演义\",\n" +
            "                    \"goods_num\": \"2\",\n" +
            "                    \"goods_price\": \"15.00\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"store_id\": \"1\",\n" +
            "            \"store_name\": \"书店杂货铺\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"goods\": [\n" +
            "                {\n" +
            "                    \"goods_id\": \"222221\",\n" +
            "                    \"goods_image\": \"http://file06.16sucai.com/2016/0511/9711205e4c003182edeed83355e6f1c7.jpg\",\n" +
            "                    \"goods_name\": \"西游记\",\n" +
            "                    \"goods_num\": \"2\",\n" +
            "                    \"goods_price\": \"12.00\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"goods_id\": \"222222\",\n" +
            "                    \"goods_image\": \"http://img01.taopic.com/150424/240473-1504240U13615.jpg\",\n" +
            "                    \"goods_name\": \"封神榜\",\n" +
            "                    \"goods_num\": \"1\",\n" +
            "                    \"goods_price\": \"28.00\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"store_id\": \"2\",\n" +
            "            \"store_name\": \"亚马逊书店\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"goods\": [\n" +
            "                {\n" +
            "                    \"goods_id\": \"333331\",\n" +
            "                    \"goods_image\": \"http://pic22.nipic.com/20120718/8002769_100147127333_2.jpg\",\n" +
            "                    \"goods_name\": \"水浒传\",\n" +
            "                    \"goods_num\": \"3\",\n" +
            "                    \"goods_price\": \"18.00\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"goods_id\": \"333332\",\n" +
            "                    \"goods_image\": \"http://pic.58pic.com/58pic/14/71/50/40e58PICy54_1024.jpg\",\n" +
            "                    \"goods_name\": \"封神演义\",\n" +
            "                    \"goods_num\": \"3\",\n" +
            "                    \"goods_price\": \"32.00\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"goods_id\": \"333333\",\n" +
            "                    \"goods_image\": \"http://img01.taopic.com/150518/318750-15051PS40671.jpg\",\n" +
            "                    \"goods_name\": \"轩辕剑\",\n" +
            "                    \"goods_num\": \"3\",\n" +
            "                    \"goods_price\": \"3.80\"\n" +
            "                }\n" +
            "            ],\n" +
            "            \"store_id\": \"3\",\n" +
            "            \"store_name\": \"三味书屋\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";
}
