package com.sen.myapplication.ui.Activity;

import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.FixLayoutHelper;
import com.alibaba.android.vlayout.layout.FloatLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.alibaba.android.vlayout.layout.StaggeredGridLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;
import com.sen.myapplication.bean.DataBean;
import com.sen.myapplication.ui.adapter.BaseDelegateAdapter;
import com.sen.myapplication.ui.adapter.FixLayoutAdapter;
import com.sen.myapplication.ui.adapter.OneplusnalayoutAdapter;
import com.sen.myapplication.ui.adapter.SingleLayoutAdapter;
import com.sen.myapplication.ui.adapter.GridAdapter;
import com.sen.myapplication.ui.adapter.LinearLayoutAdapter;
import com.sen.myapplication.ui.adapter.StaggeredGridAdapter;
import com.sen.myapplication.ui.adapter.StickyAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * 作者：sen
 * 日期时间:
 * 内容描述: 商品详情
 * */
public class VlayoutActivity extends BaseActivity {

    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<DelegateAdapter.Adapter> adapterList = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_vlayout;
    }

    @Override
    protected void initView() {

        refreshLayout.setEnableLoadMore(true);

        //绑定vLayout
        VirtualLayoutManager layoutManager = new VirtualLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //设置复用池
        RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
        recyclerView.setRecycledViewPool(viewPool);
        //对ViewType为0的设置复用池的大小
        viewPool.setMaxRecycledViews(0, 5);

        //  吸顶/吸底 设置搜索栏
        StickyLayoutHelper singleLayoutHelper1 = new StickyLayoutHelper(true);
        BaseDelegateAdapter seartchAdapter = new BaseDelegateAdapter(this,singleLayoutHelper1,R.layout.item_search_layout, 1, 9);
        adapterList.add(seartchAdapter);

        //通栏布局只显示一个View
        SingleLayoutHelper singleLayoutHelper = new SingleLayoutHelper();
        SingleLayoutAdapter singleLayoutAdapter = new SingleLayoutAdapter(this, initBanner(), singleLayoutHelper);
//        SingleLayoutAdapter singleLayoutAdapter = new SingleLayoutAdapter(this,initBanner(),bannerLayoutHelper);
        adapterList.add(singleLayoutAdapter);

        //网格布局,列数
        GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
        gridLayoutHelper.setWeights(new float[]{25.0f,25.0f,25.0f,25.0f});
        gridLayoutHelper.setMarginTop(30);
        gridLayoutHelper.setMarginBottom(30);
//        BaseDelegateAdapter gridAdapter = new BaseDelegateAdapter(this, gridLayoutHelper, R.layout.item_image_text, 8, 2);
        GridAdapter gridAdapter = new GridAdapter(this, gridLayoutHelper, initGridData(),2);
        adapterList.add(gridAdapter);

        //固定布局，始终在固定的位置显示
        FixLayoutHelper fixLayoutHelper = new FixLayoutHelper(FixLayoutHelper.BOTTOM_RIGHT,50,200);
        BaseDelegateAdapter fixLlayoutAdapter = new BaseDelegateAdapter(this, fixLayoutHelper, R.layout.item_shopping_cart, 1, 3);
        adapterList.add(fixLlayoutAdapter);

        //浮动布局,可以固定在屏幕上，但用户可以拖动
//        FloatLayoutHelper floatLayoutHelper = new FloatLayoutHelper();
//        BaseDelegateAdapter floatAdapter = new BaseDelegateAdapter(this, floatLayoutHelper, R.layout.item_image_text, 1, 4);
//        adapterList.add(floatAdapter);

        //ColumnLayoutHelper: 栏格布局，都布局在一排，可以配置不同列之间的宽度比值
        ColumnLayoutHelper columnLayoutHelper = new ColumnLayoutHelper();
        columnLayoutHelper.setWeights(new float[]{70.0f,20.0f,10.0f});
        BaseDelegateAdapter columLayoutAdapter = new BaseDelegateAdapter(this, columnLayoutHelper, R.layout.item_image, 3, 5);
        adapterList.add(columLayoutAdapter);

        //OnePlusNLayoutHelper: 一拖N布局，可以配置1-5个子元素
        OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper();
        onePlusNLayoutHelper.setColWeights(new float[]{50.0f,50.f});
        onePlusNLayoutHelper.setRowWeight(50.0f);
        OneplusnalayoutAdapter oneplusnalayoutAdapter = new OneplusnalayoutAdapter(this, onePlusNLayoutHelper, initImgData(),6);
//        BaseDelegateAdapter onePlusNLayoutAdapter = new BaseDelegateAdapter(this, onePlusNLayoutHelper, R.layout.item_image, 3, 6);
        adapterList.add(oneplusnalayoutAdapter);

        //stickyLayoutHelper 吸顶效果的
//        StickyLayoutHelper stickyLayoutTopHelper = new StickyLayoutHelper(true);    //吸顶
        StickyLayoutHelper stickyLayoutBottomHelper = new StickyLayoutHelper(false);//吸底部
        StickyAdapter stickyAdapter = new StickyAdapter(this, stickyLayoutBottomHelper, 1, 7);
//        BaseDelegateAdapter stickyLayoutAdapter = new BaseDelegateAdapter(this, stickyLayoutBottomHelper, R.layout.item_title,1,7 );
        adapterList.add(stickyAdapter);

        //线性布局
        LinearLayoutHelper linearLayoutHelper = new LinearLayoutHelper(10);
//        BaseDelegateAdapter linearLayoutAdapter = new BaseDelegateAdapter(this, linearLayoutHelper, R.layout.item_title, 10, 1);
        LinearLayoutAdapter linearLayoutAdapter = new LinearLayoutAdapter(this,linearLayoutHelper,initTitle(),1);
        adapterList.add(linearLayoutAdapter);

        //瀑布流 staggeredGridLayoutHelper
        StaggeredGridLayoutHelper staggeredGridLayoutHelper = new StaggeredGridLayoutHelper(3);
        StaggeredGridAdapter staggeredGridLayouAdaper = new StaggeredGridAdapter(this, staggeredGridLayoutHelper,initTitle(),8);
        adapterList.add(staggeredGridLayouAdaper);

        //创建Adapter的管理器,并且与recycleView进行绑定
        DelegateAdapter delegateAdapter = new DelegateAdapter(layoutManager,true);
        //给Adapter管理器设置adapter List
        delegateAdapter.addAdapters(adapterList);
        Toast.makeText(this, "总条目数？？？"+delegateAdapter.getItemCount(), Toast.LENGTH_SHORT).show();
        recyclerView.setAdapter(delegateAdapter);
    }

    @Override
    protected void initData() {

    }

    private List<String> initGridData(){
        List<String> gridData = new ArrayList<>();
        for(int i= 0;i<7;i++){
            gridData.add("种类"+i);
        }
        return gridData;
    }

    private List<String> initImgData(){
        List<String> gridData = new ArrayList<>();
        for(int i= 0;i<3;i++){
            gridData.add("种类"+i);
        }
        return gridData;
    }

    private List<DataBean> initBanner(){
        List<DataBean> dataList = new ArrayList<>();
        DataBean dataBean1 = new DataBean();
        dataBean1.imageRes = R.mipmap.icon_banner_one;
        dataList.add(dataBean1);
        DataBean dataBean2 = new DataBean();
        dataBean2.imageRes = R.mipmap.icon_banner_two;
        dataList.add(dataBean2);
        DataBean dataBean3 = new DataBean();
        dataBean3.imageRes = R.mipmap.icon_banner_three;
        dataList.add(dataBean3);
        DataBean dataBean4 = new DataBean();
        dataBean4.imageRes = R.mipmap.icon_banner_four;
        dataList.add(dataBean4);
        DataBean dataBean5 = new DataBean();
        dataBean5.imageRes = R.mipmap.icon_banner_five;
        dataList.add(dataBean5);

        return  dataList;
    }

    private List<String> initTitle(){
        List<String> strList = new ArrayList<>();
        for(int i =0 ;i<10;i++){
            strList.add("Title"+i);
        }
        return  strList;
    }
}
