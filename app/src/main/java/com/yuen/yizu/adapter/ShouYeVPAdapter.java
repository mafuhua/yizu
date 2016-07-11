package com.yuen.yizu.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.yuen.yizu.base.BasePager;

import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ShouYeVPAdapter extends PagerAdapter {

    private Context context;
    private List<BasePager> pagers;

    public ShouYeVPAdapter(Context context, List<BasePager> pagers) {

        this.context = context;
        this.pagers = pagers;
    }

    @Override
    public int getCount() {
        return pagers.size();
    }

    /**
     * 1.根据position，返回对应的view
     * 2.view添加到container
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Log.d("mafuhua", "instantiateItem:"+position);
        BasePager currentPager = pagers.get(position);
        View currentPagerView = currentPager.initView();
        container.addView(currentPagerView);
        //一旦初始化界面，就需要初始化数据
        currentPager.initData();
        return currentPagerView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("destroyItem:"+position);
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


}