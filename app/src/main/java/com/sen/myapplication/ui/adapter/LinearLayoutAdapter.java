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
 * 日期时间: 2020/4/21 10:22
 * 内容描述:
 */
public class LinearLayoutAdapter extends DelegateAdapter.Adapter<LinearLayoutAdapter.TitleViewHolder> {

    private Context context;
    private LayoutHelper layoutHelper;
    private List<String> titles;
    private int itemViewType = -1;

    public LinearLayoutAdapter(Context context, LayoutHelper layoutHelper, List<String> titles,int itemViewType) {
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
    public TitleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TitleViewHolder(LayoutInflater.from(context).inflate(R.layout.item_linearlayout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TitleViewHolder holder, int position) {
        if(holder!=null){
           holder.tvOne.setText("标题"+position);
           holder.tvTwo.setText("内容"+position);
           holder.tvThree.setText("日期"+position);
           holder.imageView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Toast.makeText(context, "商品推荐"+position, Toast.LENGTH_SHORT).show();
               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    @Override
    public int getItemViewType(int position) {
        return itemViewType;
    }

    class TitleViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView tvOne;
        TextView tvTwo;
        TextView tvThree;
        public TitleViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_recommed);
            tvOne = itemView.findViewById(R.id.tv_one);
            tvTwo = itemView.findViewById(R.id.tv_two);
            tvThree = itemView.findViewById(R.id.tv_three);
        }
    }
}
