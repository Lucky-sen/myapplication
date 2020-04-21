package com.sen.myapplication.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * author:sen
 * email:562605446@qq.com
 * describtion: Acitivty基类
 */

public abstract class BaseActivity extends AppCompatActivity  {

    //获取当前Activity的类名
    protected final String TAG = this.getClass().getSimpleName();

    //是否显示标题栏
    protected boolean isShowTitle = false;

    //是否显示状态栏
    protected boolean isShowStatusBar = false;

    //是否允许旋转屏幕
    protected boolean isAllowScreenRoate = false;

    //Context
    public Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        if(!isShowTitle){
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }

        if(isShowStatusBar){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                    , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }

        //设置布局
        setContentView(getLayout());
        ButterKnife.bind(this);
        //设置屏幕是否可旋转
        if (isAllowScreenRoate) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }

        //初始化控件
        initView();

        //初始化数据
        initData();
    }

    //返回布局
    protected abstract int getLayout();

    //初始化布局
    protected abstract void initView();

    //初始化数据
    protected abstract void initData();

    /**
     * 是否显示标题栏
     * @param showTitle true-显示 false-不显示 默认true
     */
    public void setShowTitle(boolean showTitle) {
        isShowTitle = showTitle;
    }

    /**
     * 是否显示状态栏
     * @param showStatusBar true-显示 false-不显示 默认true
     */
    public void setShowStatusBar(boolean showStatusBar) {
        isShowStatusBar = showStatusBar;
    }

    /**
     * 是否允许屏幕旋转
     * @param allowScreenRoate true-允许 false-不允许 默认false
     */
    public void setAllowScreenRoate(boolean allowScreenRoate) {
        isAllowScreenRoate = allowScreenRoate;
    }

    /**
     * 隐藏软键盘
     */
    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null && null != imm) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    /**
     * 显示软键盘
     */
    public void showSoftInput() {
        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        if (getCurrentFocus() != null && null != imm) {
            imm.showSoftInputFromInputMethod(getCurrentFocus().getWindowToken(), 0);
        }
    }


    /**
     * 保证同一按钮在1秒内只会响应一次点击事件
     */
    public abstract class OnSingleClickListener implements View.OnClickListener {
        //两次点击按钮之间的间隔，目前为1000ms
        private static final int MIN_CLICK_DELAY_TIME = 1000;
        private long lastClickTime;

        public abstract void onSingleClick(View view);

        @Override
        public void onClick(View view) {
            long curClickTime = System.currentTimeMillis();
            if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
                lastClickTime = curClickTime;
                onSingleClick(view);
            }
        }
    }

    /**
     * 同一按钮在短时间内可重复响应点击事件
     */
    public abstract class OnMultiClickListener implements View.OnClickListener {
        public abstract void onMultiClick(View view);

        @Override
        public void onClick(View v) {
            onMultiClick(v);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //activity管理
        ActivityCollector.removeActivity(this);
    }
}
