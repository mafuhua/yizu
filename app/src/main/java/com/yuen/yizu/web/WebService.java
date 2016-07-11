package com.yuen.yizu.web;

import com.yuen.yizu.module.UserInfo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Administrator on 2016/6/28.
 */
public interface WebService {
    @POST("xiuka/jiekou/my")
    @FormUrlEncoded
    Call<UserInfo> getMyInfo(@Field("uid") String uid);

}
