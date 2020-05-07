package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sen.myapplication.R;
import com.sen.myapplication.bean.CategoryBean;

import java.util.List;
import java.util.zip.Inflater;

/**
 * 作者：admin016
 * 日期时间: 2020/5/7 14:48
 * 内容描述:
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.MyHolder> {
    private Context context;
    private List<CategoryBean> data;
    private onItemClickListener onItemClickListener;
    public int selectedPosition = 0;


    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(LeftAdapter.onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public LeftAdapter(Context context, List<CategoryBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_left, parent, false);
        MyHolder holder = new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            holder.tvTitle.setText(data.get(position).getName());
            if(selectedPosition == position){
                holder.tvTitle.setTextColor(context.getResources().getColor(R.color.red));
            }else{
                holder.tvTitle.setTextColor(context.getResources().getColor(R.color.black));
            }
            holder.tvTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onItemClickListener!=null){
                        onItemClickListener.onItemClick(holder.itemView, position);
                    }
                }
            });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface  onItemClickListener{
        void onItemClick(View v,int position);
    }
}
