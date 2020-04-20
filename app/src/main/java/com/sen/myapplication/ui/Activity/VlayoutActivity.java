package com.sen.myapplication.ui.Activity;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * 作者：admin016
 * 日期时间: 2020/4/20 11:06
 * 内容描述:
 */
public class VlayoutActivity extends BaseActivity {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<DelegateAdapter.Adapter> adapterList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_vlayout;
    }

    @Override
    protected void initView() {
        //绑定vLayout
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);

        //设置复用池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        //对ViewType为0的设置复用池的大小
        viewPool.setMaxRecycledViews(0, 10);

        //创建Adapter的管理器,并且与recycleView进行绑定
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager,true);
        recyclerView.setAdapter(delegateAdapter);





    }

    @Override
    protected void initData() {

    }
}
