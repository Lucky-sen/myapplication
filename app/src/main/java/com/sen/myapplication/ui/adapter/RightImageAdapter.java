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

import com.sen.myapplication.R;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/5/7 15:38
 * 内容描述:
 */
public class RightImageAdapter extends RecyclerView.Adapter<RightImageAdapter.ImageHolder> {

    private Context context;
    private List<String> data;

    public RightImageAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImageHolder(LayoutInflater.from(context).inflate(R.layout.item_recycle_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImageHolder holder, int position) {
        holder.textView.setText(data.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了文字"+data.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "点击了图片"+data.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ImageHolder extends RecyclerView.ViewHolder{

        TextView textView;
        ImageView imageView;

        public ImageHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_name);
            imageView = itemView.findViewById(R.id.iv_image);
        }
    }
}
