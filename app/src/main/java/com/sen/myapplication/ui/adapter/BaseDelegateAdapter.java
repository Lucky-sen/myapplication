package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;

/**
 * 作者：admin016
 * 日期时间: 2020/4/20 13:55
 * 内容描述:
 */
public class BaseDelegateAdapter extends DelegateAdapter.Adapter<BaseDelegateAdapter.BaseViewHolder> {
    private LayoutHelper mLayoutHelper;  //布局Helper
    private int mCount = -1;    //要显示的元素的个数
    private int mLayoutId = -1; //布局的id
    private Context mContext;
    private int mViewTypeItem = -1;  //ViewType的item

    /**
     *
     * @param context
     * @param layoutHelper  布局帮助类
     * @param layoutId
     * @param count
     * @param viewTypeItem
     */
    public BaseDelegateAdapter(Context context, LayoutHelper layoutHelper, int layoutId, int count, int viewTypeItem) {
        this.mContext = context;
        this.mCount = count;
        this.mLayoutHelper = layoutHelper;
        this.mLayoutId = layoutId;
        this.mViewTypeItem = viewTypeItem;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return mLayoutHelper;
    }


    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == mViewTypeItem) {
            return new BaseViewHolder(LayoutInflater.from(mContext).inflate(mLayoutId, parent, false)) {
            };
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {

    }


    /**
     * 必须重写不然会出现滑动不流畅的情况
     */
    @Override
    public int getItemViewType(int position) {
        return mViewTypeItem;
    }

    //条目数量
    @Override
    public int getItemCount() {
        return mCount;
    }

    class BaseViewHolder extends RecyclerView.ViewHolder{

        public BaseViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
