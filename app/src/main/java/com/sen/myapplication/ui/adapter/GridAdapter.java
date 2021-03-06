package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.sen.myapplication.R;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/21 10:51
 * 内容描述:
 */
public class GridAdapter extends DelegateAdapter.Adapter<GridAdapter.TitleViewHolder> {
    private Context context;
    private LayoutHelper layoutHelper;
    private List<String> titles;
    private int itemViewType = -1;

    public GridAdapter(Context context, LayoutHelper layoutHelper, List<String> titles,int itemViewType) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.titles = titles;
        this.itemViewType = itemViewType;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public GridAdapter.TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GridAdapter.TitleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image_text, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.TitleViewHolder holder, int position) {
        if(holder!=null){
            holder.tvTitle.setText(titles.get(position));
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "点击了种类"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return itemViewType;
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    class TitleViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvTitle;
        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }
}
