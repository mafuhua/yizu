package com.yuen.yizu.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.yuen.yizu.R;
import com.yuen.yizu.base.BaseActivity;
import com.yuen.yizu.fragment.FaXianFragment;
import com.yuen.yizu.fragment.ShouYeFragment;
import com.yuen.yizu.fragment.WoDeFragment;
import com.yuen.yizu.fragment.XiaoXiFragment;
import com.yuen.yizu.utils.FragmentFractory;
import com.yuen.yizu.utils.MyUtils;
import com.yuen.yizu.utils.SysExitUtil;
import com.yuen.yizu.web.MyUserInfoPresenter;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private FrameLayout fl_home_content;
    private RadioButton rb_home_shouye;
    private RadioButton rb_home_xiaoxi;
    private RadioButton rb_home_tianjia;
    private RadioButton rb_home_faxian;
    private RadioButton rb_home_wode;
    private RadioGroup rg_home;
    private FaXianFragment faxianFragment;
    private ShouYeFragment shouYeFragment;
    private XiaoXiFragment xiaoxiFragment;
    private WoDeFragment woDeFragment;
    private Fragment currentFragment;
    private FragmentTransaction transaction;
    private Toolbar toolbar;
    private FragmentManager supportFragmentManager;
    private MyUserInfoPresenter myUserInfoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            Log.d("mafuhua", "savedInstanceState----------:" + savedInstanceState);
            savedInstanceState = null;
            if (savedInstanceState == null) {
                Log.d("mafuhua", "savedInstanceState**********----------:" + savedInstanceState);
            }
        }
        super.onCreate(savedInstanceState);
        SysExitUtil.activityList.add(this);
        setContentView(R.layout.activity_main);
        initView();
        loadData();
    }

    @Override
    public void initView() {

        fl_home_content = (FrameLayout) findViewById(R.id.fl_home_content);
        fl_home_content.setOnClickListener(this);
        rb_home_shouye = (RadioButton) findViewById(R.id.rb_home_shouye);
        rb_home_shouye.setOnClickListener(this);
        rb_home_xiaoxi = (RadioButton) findViewById(R.id.rb_home_xiaoxi);
        rb_home_xiaoxi.setOnClickListener(this);
        rb_home_tianjia = (RadioButton) findViewById(R.id.rb_home_tianjia);
        rb_home_tianjia.setOnClickListener(this);
        rb_home_faxian = (RadioButton) findViewById(R.id.rb_home_faxian);
        rb_home_faxian.setOnClickListener(this);
        rb_home_wode = (RadioButton) findViewById(R.id.rb_home_wode);
        rb_home_wode.setOnClickListener(this);
        rg_home = (RadioGroup) findViewById(R.id.rg_home);
        rg_home.setOnClickListener(this);

        Drawable drawable = getResources().getDrawable(R.drawable.ic_launcher);
        int dp = MyUtils.dip2px(context, 30);
        drawable.setBounds(0, 0, dp, dp);
        rb_home_shouye.setCompoundDrawables(null, drawable, null, null);
        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_launcher);
        drawable1.setBounds(0, 0, dp, dp);
        rb_home_xiaoxi.setCompoundDrawables(null, drawable1, null, null);
        Drawable drawable2 = getResources().getDrawable(R.drawable.ic_launcher);
        drawable2.setBounds(0, 0, dp, dp);
        rb_home_tianjia.setCompoundDrawables(null, drawable2, null, null);
        Drawable drawable3 = getResources().getDrawable(R.drawable.ic_launcher);
        drawable3.setBounds(0, 0, dp, dp);
        rb_home_faxian.setCompoundDrawables(null, drawable3, null, null);
        Drawable drawable4 = getResources().getDrawable(R.drawable.ic_launcher);
        drawable4.setBounds(0, 0, dp, dp);
        rb_home_wode.setCompoundDrawables(null, drawable4, null, null);
        rg_home.check(R.id.rb_home_faxian);
        supportFragmentManager = getSupportFragmentManager();
        shouYeFragment = (ShouYeFragment) FragmentFractory.getInstance().createFragment(0);
        xiaoxiFragment = (XiaoXiFragment) FragmentFractory.getInstance().createFragment(1);
        faxianFragment = (FaXianFragment) FragmentFractory.getInstance().createFragment(2);
        woDeFragment = (WoDeFragment) FragmentFractory.getInstance().createFragment(3);
        getSupportFragmentManager().beginTransaction().add(R.id.fl_home_content, shouYeFragment, "shouYeFragment")
                .add(R.id.fl_home_content, xiaoxiFragment, "xiaoxiFragment").hide(xiaoxiFragment)
                .add(R.id.fl_home_content, faxianFragment, "faxianFragment").hide(faxianFragment)
                .add(R.id.fl_home_content, woDeFragment, "woDeFragment").hide(woDeFragment)
                .show(faxianFragment)
                .commit();
        currentFragment = shouYeFragment;

        // toolbar = (Toolbar) findViewById(R.id.toolbar);

    }

    @Override
    public void loadData() {
        myUserInfoPresenter = new MyUserInfoPresenter();
        myUserInfoPresenter.requestUserInfo("10000005");
    }

    @Override
    public void onClick(View v) {
        transaction = supportFragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.rb_home_shouye:
                if (currentFragment != shouYeFragment) {
                    switchContent(currentFragment, shouYeFragment, "首页", View.GONE);
                }
                break;
            case R.id.rb_home_xiaoxi:
                switchContent(currentFragment, xiaoxiFragment, "快递", View.GONE);
                break;
            case R.id.rb_home_tianjia:
                //   startActivity(TianJiaActivity.class);
                ShowSnack(rb_home_wode, "tandhufhd", "jfd", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ShowSnack(rb_home_faxian, "hahah");
                    }
                });
                break;
            case R.id.rb_home_faxian:
                switchContent(currentFragment, faxianFragment, "个人中心", View.GONE);
                //  initToolbar(toolbar,true);
                break;

            case R.id.rb_home_wode:
                switchContent(currentFragment, woDeFragment, "购物车", View.VISIBLE);

                break;
        }
    }

    public void switchContent(Fragment from, Fragment to, String title, int gone) {
        currentFragment = to;
        if (!to.isAdded()) {    // 先判断是否被add过
            transaction.hide(from).add(R.id.fl_home_content, to).commit(); // 隐藏当前的fragment，add下一个到Activity中
        } else {
            transaction.hide(from).show(to).commit(); // 隐藏当前的fragment，显示下一个
        }
    }
}
