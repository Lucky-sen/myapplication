package com.sen.myapplication.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.sen.myapplication.R;
import com.sen.myapplication.bean.DataBean;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.listener.OnPageChangeListener;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.util.BannerUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：admin016
 * 日期时间: 2020/4/21 10:12
 * 内容描述:
 */
public class SingleLayoutAdapter extends DelegateAdapter.Adapter<SingleLayoutAdapter.BannerViewHolder> {

    private Context context;
    private List<DataBean> dataBeans;
    private LayoutHelper layoutHelper;

    public SingleLayoutAdapter(Context context, List<DataBean> dataBeans, LayoutHelper layoutHelper) {
        this.context = context;
        this.dataBeans = dataBeans;
        this.layoutHelper = layoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return layoutHelper;
    }

    @NonNull
    @Override
    public BannerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, parent, false);
        return new BannerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BannerViewHolder holder, int position) {
        //显示图片
        ImageAdapter imageAdapter = new ImageAdapter(dataBeans);

        holder.banner.setAdapter(imageAdapter)
        .setIndicator(new CircleIndicator(context))
        .setIndicatorSelectedColorRes(R.color.yellow)
        .setIndicatorNormalColorRes(R.color.graywhite)
        .setIndicatorGravity(IndicatorConfig.Direction.CENTER)
//        .setIndicatorSpace(BannerUtils.dp2px(20))
        .setIndicatorMargins(new IndicatorConfig.Margins((int) BannerUtils.dp2px(10)))
        .setIndicatorWidth(10,20)
//        .addItemDecoration(new MarginItemDecoration((int) BannerUtils.dp2px(50)));
//        .setPageTransformer(new DepthPageTransformer());
        .setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object data, int position) {
                Toast.makeText(context, "点击了Banner"+position, Toast.LENGTH_SHORT).show();
            }
        })
        .addOnPageChangeListener(new OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        })
        .start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    class BannerViewHolder extends RecyclerView.ViewHolder{

        Banner banner;
        public BannerViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

}
