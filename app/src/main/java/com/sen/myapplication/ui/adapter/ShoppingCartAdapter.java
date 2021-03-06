package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sen.myapplication.R;
import com.sen.myapplication.bean.CartBean;

import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/22 16:04
 * 内容描述: ExpandableListView  Adapter
 */
public class ShoppingCartAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<CartBean> datas;

    public ShoppingCartAdapter(Context context,List<CartBean> datas) {
        this.context = context;
        this.datas = datas;
    }

    @Override
    public int getGroupCount() {
        return datas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return datas.get(groupPosition).getGoods().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return datas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return datas.get(groupPosition).getGoods().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_group_layout, null);
            groupViewHolder = new GroupViewHolder(convertView);
            convertView.setTag(groupViewHolder);
        }else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.tvShop.setText(datas.get(groupPosition).getStoreName());
        if(datas.get(groupPosition).isSelectShop()){
            groupViewHolder.checkboxShop.setChecked(true);
        }else {
            groupViewHolder.checkboxShop.setChecked(false);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder = null;
        if(convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_child_layout, parent,false);
            childViewHolder = new ChildViewHolder(convertView);
            convertView.setTag(childViewHolder);
        }else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder{
        TextView tvShop;
        CheckBox checkboxShop;

        GroupViewHolder(View view){
            tvShop = view.findViewById(R.id.tv_shop);
            checkboxShop = view.findViewById(R.id.checkbox_shop);
        }
    }

    static class ChildViewHolder{
        CheckBox checkBox;
        ImageView ivGood;
        TextView tvGoodName;
        TextView tvGoodExplain;
        TextView tvSumPrice;


        ChildViewHolder(View view){
            checkBox = view.findViewById(R.id.checkbox);
            ivGood = view.findViewById(R.id.iv_good);
            tvGoodName = view.findViewById(R.id.tv_good_name);
            tvGoodExplain = view.findViewById(R.id.tv_good_explain);
            tvSumPrice = view.findViewById(R.id.tv_sum_price);

        }
    }
}
