package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.sen.myapplication.R;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 11:07
 * 内容描述:
 */
public class OneplusnalayoutAdapter extends DelegateAdapter.Adapter<OneplusnalayoutAdapter.OneplusnaLayoutViewHolder> {


    private Context context;
    private LayoutHelper layoutHelper;
    private List<String> imgs;
    private int itemViewType = -1;

    public OneplusnalayoutAdapter(Context context, LayoutHelper layoutHelper, List<String> imgs, int itemViewType) {
        this.context = context;
        this.layoutHelper = layoutHelper;
        this.imgs = imgs;
        this.itemViewType = itemViewType;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public OneplusnaLayoutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OneplusnaLayoutViewHolder(LayoutInflater.from(context).inflate(R.layout.item_oneplusnlayout, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull OneplusnaLayoutViewHolder holder, int position) {
        if(holder!=null){
            holder.imageView.setImageResource(R.mipmap.icon_banner_one);
            holder.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "点击了品牌"+position, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    class OneplusnaLayoutViewHolder extends RecyclerView.ViewHolder{

        private ImageView imageView;

        public OneplusnaLayoutViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }
}
