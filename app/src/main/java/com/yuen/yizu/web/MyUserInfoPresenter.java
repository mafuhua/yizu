package com.yuen.yizu.web;

import android.widget.Toast;

import com.yuen.yizu.ApplicationEx;
import com.yuen.yizu.module.UserInfo;

/**
 * Created by Administrator on 2016/6/28.
 */
public class MyUserInfoPresenter implements UserInfoContract.UserInfoPresenter {

    private final WebService webService;

    public MyUserInfoPresenter() {
        webService = RestClient.getClient().create(WebService.class);
    }

    @Override
    public void requestUserInfo( String uid) {
        webService.getMyInfo(uid).enqueue(new RestCallback<UserInfo>() {
            @Override
            public void onSuccess(UserInfo userInfo) {
                Toast.makeText(ApplicationEx.getInstance(), userInfo.getName(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Error error) {

            }        });

    }
}
