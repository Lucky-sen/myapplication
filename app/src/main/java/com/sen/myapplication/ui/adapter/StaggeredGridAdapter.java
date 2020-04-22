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
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.sen.myapplication.R;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 14:09
 * 内容描述:
 */
public class StaggeredGridAdapter extends DelegateAdapter.Adapter<StaggeredGridAdapter.StaggeredGridViewHolder> {

    private Context context;
    private LayoutHelper layoutHelper;
    private List<String> titles;
    private int itemViewType = -1;

    public StaggeredGridAdapter(Context context, LayoutHelper layoutHelper, List<String> titles, int itemViewType) {
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
    public StaggeredGridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StaggeredGridViewHolder(LayoutInflater.from(context).inflate(R.layout.item_staggered_grid_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridViewHolder holder, int position) {
//        VirtualLayoutManager.LayoutParams layoutParams = new VirtualLayoutManager.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        if(position% 2 == 0){
           holder.imageView.setImageResource(R.mipmap.icon_kobe);
        }else {
            holder.imageView.setImageResource(R.mipmap.icon_banner_five);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "瀑布流"+position, Toast.LENGTH_SHORT).show();
            }
        });
        holder.textView.setText("瀑布流"+position);
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemViewType;
    }

    class StaggeredGridViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public StaggeredGridViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

}
