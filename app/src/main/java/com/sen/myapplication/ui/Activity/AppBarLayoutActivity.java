package com.sen.myapplication.ui.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;

import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;

import butterknife.BindView;

/**
 * 作者：admin016
 * 日期时间: 2020/4/26 16:55
 * 内容描述: 打造折叠悬浮效果
 * 备注：AppBarLayout必须作为CoordinatorLayout的直接子View，否则它的大部分功能将不会生效，如layout_scrollFlags等。
 */
public class AppBarLayoutActivity extends BaseActivity implements View.OnClickListener {


    @BindView(R.id.btn_xiding)
    Button btnXiding;
    @BindView(R.id.btn_zhe)
    Button btnZhe;

    @Override
    protected int getLayout() {
        return R.layout.activity_app_bar_layout;
    }

    @Override
    protected void initView() {
        btnXiding.setOnClickListener(this);
        btnZhe.setOnClickListener(this);
    }

    @Override
    protected void initData() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for(int i =0;i<50;i++){
//            stringBuilder.append("item"+i +"\n");
//        }
//        tv.setText(stringBuilder.toString());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_xiding:
                Intent intent = new Intent(this,XidingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_zhe:
                Intent intent1 = new Intent(this,ZheActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
