package com.yuen.yizu.web;

import android.content.Context;

import com.yuen.yizu.utils.ToastUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * RestClient请求的回调接口
 *
 * @param <T> 返回的数据类型
 * @author 53dada
 * @version 1.0
 * @since 2.0
 */
public abstract class RestCallback<T> implements Callback<T> {

    private Context mContext;
    private boolean mLoading;

    public RestCallback() {
        this(null);
    }

    public RestCallback(Context context) {
        this.mContext = context;
    }

    public abstract void onSuccess(T t);

    public abstract void onFailure(Error error);

    protected boolean showToast() {
        return true;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            onSuccess(response.body());
        } else {
            Error error = parseCode(response.code());
            onFailure(error);
            if (showToast()) {
                ToastUtil.toastShortShow(error.msg);
            }
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable throwable) {

        if (showToast()) {
            ToastUtil.toastShortShow("失败");
        }

    }

    /**
     * 解析ResponseCode
     *
     * @param code code
     * @return Error
     */
    private Error parseCode(int code) {
        Error error = new Error();
        error.code = code;
        if (error.code >= 400 && error.code < 500) {
            //4xx client error
            error.msg = "发生了一些意外,请稍后重试.";
        } else {
            //5xx server error
            error.msg = "服务器正在开小差,请稍后重试.";
        }
        return error;
    }



    public static class Error {
        public int code;
        public String msg;
    }
}
