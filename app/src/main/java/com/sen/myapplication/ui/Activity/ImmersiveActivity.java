package com.sen.myapplication.ui.Activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 作者：admin016
 * 日期时间: 2020/4/24 15:32
 * 内容描述: 沉浸式模式
 * 状态栏
 * ActionBar
 * 导航栏
 */
public class ImmersiveActivity extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.iv_img)
    ImageView ivImg;
    @BindView(R.id.btn_hide_status)
    Button btnHideStatus;
    @BindView(R.id.btn_hide_actionbar)
    Button btnHideActionBar;
    @BindView(R.id.btn_transparent_status)
    Button btnTransparentStatus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immersive);
        ButterKnife.bind(this);
        btnHideStatus.setOnClickListener(this);
        btnHideActionBar.setOnClickListener(this);
        btnTransparentStatus.setOnClickListener(this);
        //隐藏ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_hide_status:
                //获取DecorView
                View decorView = getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
                //设置系统UI可见元素
                decorView.setSystemUiVisibility(option);
                break;
            case R.id.btn_hide_actionbar:

                break;
            case R.id.btn_transparent_status:   //透明状态栏
                if (Build.VERSION.SDK_INT >= 21) {
                    View decorView1 = getWindow().getDecorView();
                    int option1 = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
                    decorView1.setSystemUiVisibility(option1);
                    getWindow().setStatusBarColor(Color.TRANSPARENT);
                }
                break;
        }
    }
}
