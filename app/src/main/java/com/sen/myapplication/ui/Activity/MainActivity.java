package com.sen.myapplication.ui.Activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;

public class MainActivity extends BaseActivity  implements View.OnClickListener{

    private Button btnVlayout;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnVlayout = findViewById(R.id.btn_vlayout);
        btnVlayout.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_vlayout:
                Intent intent = new Intent();
                intent.setClass(this, VlayoutActivity.class);
                startActivity(intent);
                break;
        }
    }
}
