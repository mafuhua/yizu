package com.yuen.yizu.fragment;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.yuen.yizu.R;
import com.yuen.yizu.adapter.ShouYeVPAdapter;
import com.yuen.yizu.base.BaseFragment;
import com.yuen.yizu.base.BasePager;
import com.yuen.yizu.base.MyViewPager;
import com.yuen.yizu.pagers.FangKePage;
import com.yuen.yizu.pagers.JingXuanPage;
import com.yuen.yizu.pagers.ZuFangPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/10.
 */
public class ShouYeFragment extends BaseFragment implements View.OnClickListener {
    private Context context;
    private MyViewPager viewpagers;
    private List<BasePager> pagers = new ArrayList<>();
    private TextView tv_jingxuan;
    private TextView tv_fangke;
    private TextView tv_zufang;

    @Override
    public View initView() {
        context = getActivity();
        View view = View.inflate(context, R.layout.fragment_shouye, null);
        viewpagers = (MyViewPager) view.findViewById(R.id.viewpager);
        tv_jingxuan = (TextView) view.findViewById(R.id.tv_jingxuan);
        tv_fangke = (TextView) view.findViewById(R.id.tv_fangke);
        tv_zufang = (TextView) view.findViewById(R.id.tv_zufang);
        tv_jingxuan.setOnClickListener(this);
        tv_fangke.setOnClickListener(this);
        tv_zufang.setOnClickListener(this);
        //准备数据源
        pagers.add(new JingXuanPage(context));
        pagers.add(new FangKePage(context));
        pagers.add(new ZuFangPage(context));
        //给viewPager设置适配器

        viewpagers.setAdapter(new ShouYeVPAdapter(context, pagers));
        return view;
    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_jingxuan:
                viewpagers.setCurrentItem(0);
                break;
            case R.id.tv_fangke:
                viewpagers.setCurrentItem(1);
                break;
            case R.id.tv_zufang:
                viewpagers.setCurrentItem(2);
                break;
        }
    }
}
