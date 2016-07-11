package com.yuen.yizu.pagers;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.yuen.yizu.R;
import com.yuen.yizu.adapter.ImageAdapter;
import com.yuen.yizu.base.BasePager;

/**
 * Created by Administrator on 2016/7/10.
 */
public class JingXuanPage extends BasePager{
    private Context context;
    private RecyclerView pic;
    private RecyclerView pic1;
    private RecyclerView pic2;

    public JingXuanPage(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View initView() {
        View view = View.inflate(context, R.layout.pager_jingxuan, null);

        pic = (RecyclerView) view.findViewById(R.id.rv_pic);
        pic1 = (RecyclerView) view.findViewById(R.id.rv_pic1);
        pic2 = (RecyclerView) view.findViewById(R.id.rv_pic2);

       // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        pic.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        pic1.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        pic2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        pic.setAdapter(new ImageAdapter(context));
        pic1.setAdapter(new ImageAdapter(context));
        pic2.setAdapter(new ImageAdapter(context));
        return view;
    }

    @Override
    public void initData() {

    }
}
