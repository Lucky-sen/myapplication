package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.sen.myapplication.R;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 11:22
 * 内容描述:
 */
public class StickyAdapter extends DelegateAdapter.Adapter<StickyAdapter.StickViewHoler> {

    private Context context;
    private LayoutHelper layoutHelper;
    private int count = -1;
    private int itemViewType = -1;

    public StickyAdapter(Context context, LayoutHelper layoutHelper, int count, int itemViewType) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.count = count;
        this.itemViewType = itemViewType;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public StickViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StickViewHoler(LayoutInflater.from(context).inflate(R.layout.item_sticklayout, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StickViewHoler holder, int position) {
        if(holder!=null){
        }
    }

    @Override
    public int getItemCount() {
        return count;
    }

    class StickViewHoler extends RecyclerView.ViewHolder{
        TextView tvTitle;
        public StickViewHoler(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
