package com.sen.myapplication.ui.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity  implements View.OnClickListener{

    @BindView(R.id.btn_immersive)
    Button btnImmersive;
    private Button btnVlayout;
    @BindView(R.id.btn_shopping_cart)
    Button btnCatr;
    @BindView(R.id.btn_appbar_layout)
    Button btnAppBar;
    @BindView(R.id.btn_category)
    Button btnCategory;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnVlayout = findViewById(R.id.btn_vlayout);
        btnVlayout.setOnClickListener(this);
        btnCatr.setOnClickListener(this);
        btnImmersive.setOnClickListener(this);
        btnAppBar.setOnClickListener(this);
        btnCategory.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_vlayout:
                Intent intent = new Intent(); //商城首页
                intent.setClass(this, VlayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_shopping_cart: //购物车
                Intent intent1 = new Intent(this,ShoppingCartActivity.class);
                startActivity(intent1);
                break;
            case R.id.btn_immersive: //沉浸模式
                Intent intent2 = new Intent(this,ImmersiveActivity.class);
                startActivity(intent2);
                break;
            case R.id.btn_appbar_layout:  //折叠效果
                Intent intent3 = new Intent(this,AppBarLayoutActivity.class);
                startActivity(intent3);
                break;
            case R.id.btn_category:   //分类列表
                Intent intent4 = new Intent(this,CategoryActivity.class);
                startActivity(intent4);
                break;

        }
    }
}
