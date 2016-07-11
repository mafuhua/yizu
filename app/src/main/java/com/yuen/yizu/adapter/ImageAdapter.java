package com.yuen.yizu.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.yuen.yizu.R;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private Context context;
    private LayoutInflater mInflater;
    public ImageAdapter(Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_home_recycle_iconview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.mImg.setBackgroundResource(R.drawable.img);
    }



    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImg;

        public ViewHolder(View view) {
            super(view);
            mImg = (ImageView) view;
        }
    }
}
