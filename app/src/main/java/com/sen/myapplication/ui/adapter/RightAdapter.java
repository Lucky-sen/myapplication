package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sen.myapplication.R;
import com.sen.myapplication.bean.CategoryBean;
import com.sen.myapplication.ui.widget.MyRecycleView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/5/7 15:01
 * 内容描述:
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.RightViewHolder> {


    private Context context;
    private List<CategoryBean> data;
    private int selectedPosition = 0;

    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        notifyDataSetChanged();
    }

    public RightAdapter(Context context, List<CategoryBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public RightAdapter.RightViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_right, parent, false);
        RightViewHolder viewHolder = new RightViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.RightViewHolder holder, int position) {
        holder.tvTitle.setText(data.get(position).getName());
        holder.tvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "一级分类名称",Toast.LENGTH_SHORT).show();
            }
        });
        if(selectedPosition == position){
            holder.tvTitle.setTextColor(context.getResources().getColor(R.color.red));
        }else {
            holder.tvTitle.setTextColor(context.getResources().getColor(R.color.black));
        }
        holder.recycleView.setLayoutManager(new GridLayoutManager(context, 3));
        List<String> list = new ArrayList<>();
         for(int i=1;i<6;i++){
            list.add("种类"+i);
        }
        RightImageAdapter rightImageAdapter = new RightImageAdapter(context, list);
        holder.recycleView.setAdapter(rightImageAdapter);
        holder.recycleView.setNestedScrollingEnabled(false);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class RightViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        RecyclerView recycleView;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            recycleView = itemView.findViewById(R.id.recycler_view);
        }
    }
}
