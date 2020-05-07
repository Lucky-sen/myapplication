package com.sen.myapplication.ui.Activity;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sen.myapplication.R;
import com.sen.myapplication.base.BaseActivity;
import com.sen.myapplication.bean.CategoryBean;
import com.sen.myapplication.ui.adapter.LeftAdapter;
import com.sen.myapplication.ui.adapter.RightAdapter;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 17:49
 * 内容描述:
 */
public class CategoryActivity extends BaseActivity {

    @BindView(R.id.rv_left)
    RecyclerView leftRv;
    @BindView(R.id.rv_right)
    RecyclerView rightRv;

    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;

    private LinearLayoutManager leftManager;

    private LinearLayoutManager rightManager;

    private List<CategoryBean> leftData = new ArrayList<>();

    private List<CategoryBean> rightData = new ArrayList<>();


    @Override
    protected int getLayout() {
        return R.layout.activity_category;
    }

    @Override
    protected void initView() {
        leftAdapter = new LeftAdapter(this,leftData);
        leftManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        leftRv.setLayoutManager(leftManager);
        leftRv.setAdapter(leftAdapter);
        leftAdapter.setOnItemClickListener(new LeftAdapter.onItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                leftAdapter.setSelectedPosition(position);
                rightAdapter.setSelectedPosition(position);
                smoothMoveToPosition(rightRv,position);

            }
        });
        rightRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (mShouldScroll && RecyclerView.SCROLL_STATE_IDLE == newState) {//
                    mShouldScroll = false;
                    smoothMoveToPosition(rightRv, mToPosition);
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition = rightManager.findFirstVisibleItemPosition();
                if (leftAdapter.selectedPosition != firstPosition) {
                    leftAdapter.selectedPosition = firstPosition;
                    leftAdapter.notifyDataSetChanged();

                    //此方法无置顶效果
                    leftRv.scrollToPosition(leftAdapter.selectedPosition);
                }

            }
        });
        rightAdapter = new RightAdapter(this,rightData);
        rightManager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        rightRv.setLayoutManager(rightManager);
        rightRv.setAdapter(rightAdapter);
        getData();
    }

    @Override
    protected void initData() {


    }

    private void getData(){
        leftData.clear();
        rightData.clear();
        for(int i=1;i<16;i++){
            CategoryBean bean = new CategoryBean();
            bean.setName("分类"+i);
            leftData.add(bean);
            rightData.add(bean);
        }

        leftAdapter.notifyDataSetChanged();
        rightAdapter.notifyDataSetChanged();
    }



    //目标项是否在最后一个可见项之后
    private boolean mShouldScroll;
    //记录目标项位置
    private int mToPosition;

    /**
     * 使指定的项平滑到顶部
     *
     * @param mRecyclerView
     * @param position      待指定的项
     */
    private void smoothMoveToPosition(RecyclerView mRecyclerView, final int position) {
        int firstItemPosition = -1;
        int lastItemPosition = -1;

        //todo 获取第一个和最后一个可见位置方式1
        // 第一个可见位置
        firstItemPosition = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(0));
        // 最后一个可见位置
        lastItemPosition = mRecyclerView.getChildLayoutPosition(mRecyclerView.getChildAt(mRecyclerView.getChildCount() - 1));

        //todo 获取第一个和最后一个可见位置方式2
        // 判断是当前layoutManager是否为LinearLayoutManager
        // 只有LinearLayoutManager才有查找第一个和最后一个可见view位置的方法
//        RecyclerView.LayoutManager layoutManager = mRecyclerView.getLayoutManager();
//        if (layoutManager instanceof LinearLayoutManager) {
//            LinearLayoutManager linearManager = (LinearLayoutManager) layoutManager;
//            //获取第一个可见view的位置
//            firstItemPosition = linearManager.findFirstVisibleItemPosition();
//            //获取最后一个可见view的位置
//            lastItemPosition = linearManager.findLastVisibleItemPosition();
//
//        }

        Log.i(TAG, "smoothMoveToPosition: firstItemPosition::" + firstItemPosition + " lastItemPosition::" + lastItemPosition + "\n");

        if (position < firstItemPosition) {
            // 第一种可能:跳转位置在第一个可见位置之前
            mRecyclerView.smoothScrollToPosition(position);
        } else if (position <= lastItemPosition) {
            // 第二种可能:跳转位置在第一个可见位置之后,在最后一个可见项之前
            int movePosition = position - firstItemPosition;
            if (movePosition >= 0 && movePosition < mRecyclerView.getChildCount()) {
                int top = mRecyclerView.getChildAt(movePosition).getTop();
                mRecyclerView.smoothScrollBy(0, top);//dx>0===>向左  dy>0====>向上
            }
        } else {
            // 第三种可能:跳转位置在最后可见项之后
            mRecyclerView.smoothScrollToPosition(position);
            mToPosition = position;
            mShouldScroll = true;
        }
    }
}
