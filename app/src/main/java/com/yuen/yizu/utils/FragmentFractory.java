package com.yuen.yizu.utils;

import android.support.v4.app.Fragment;

import com.yuen.yizu.fragment.FaXianFragment;
import com.yuen.yizu.fragment.ShouYeFragment;
import com.yuen.yizu.fragment.WoDeFragment;
import com.yuen.yizu.fragment.XiaoXiFragment;

import java.util.HashMap;

/**
 * fragment工厂类
 *
 * @author wangdh
 */
public class FragmentFractory {

    private static FragmentFractory instance = new FragmentFractory();
    private HashMap<Integer, Fragment> cacheFragment = new HashMap<Integer, Fragment>();

    private FragmentFractory() {
    }

    public static FragmentFractory getInstance() {
        return instance;
    }

    //根据当前位置获取对应的fragment
    public Fragment createFragment(int position) {
        Fragment fragment = null;
        fragment = cacheFragment.get(position);
        if (fragment == null) {
            if (position == 0) {//首页
                fragment = new ShouYeFragment();
            } else if (position == 1) {//消息
                fragment = new XiaoXiFragment();
            }  else if (position == 2) {//发现
                fragment = new FaXianFragment();
            }else if (position == 3) {//我的
                fragment = new WoDeFragment();
            }
            cacheFragment.put(position, fragment);
        }
        return fragment;
    }
}
