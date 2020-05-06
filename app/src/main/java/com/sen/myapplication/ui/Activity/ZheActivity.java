package com.sen.myapplication.ui.Activity;

import android.widget.TextView;

import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;

import butterknife.BindView;

/**
 * 作者：admin016
 * 日期时间: 2020/5/6 16:06
 * 内容描述:
 */
public class ZheActivity extends BaseActivity {

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @Override
    protected int getLayout() {
        return R.layout.activity_zhe;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 50; i++) {
            stringBuilder.append("item" + i + "\n");
        }
        tvTitle.setText(stringBuilder.toString());
    }
}
