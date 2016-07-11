package com.yuen.yizu.pagers;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.yuen.yizu.base.BasePager;

/**
 * Created by Administrator on 2016/7/10.
 */
public class FangKePage extends BasePager{
    private Context context;

    public FangKePage(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View initView() {
        TextView textView = new TextView(context);
        textView.setText("房客");
        return textView;
    }
    @Override
    public void initData() {

    }
}
