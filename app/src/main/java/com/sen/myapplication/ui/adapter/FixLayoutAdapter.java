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
 * 日期时间: 2020/4/21 11:05
 * 内容描述:
 */
public class FixLayoutAdapter extends DelegateAdapter.Adapter<FixLayoutAdapter.FixViewHolder> {

    private Context context;
    private LayoutHelper layoutHelper;
    private List<String> datas;

    public FixLayoutAdapter(Context context, LayoutHelper layoutHelper, List<String> datas) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.datas = datas;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public FixViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FixViewHolder(LayoutInflater.from(context).inflate(R.layout.item_title, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FixViewHolder holder, int position) {
        holder.tvTitle.setText("FixLalyout"+ datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class FixViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        public FixViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
