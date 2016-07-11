package com.yuen.yizu.web;


import com.yuen.yizu.BuildConfig;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * RESTFull客户端<br/>
 * 单例的,管理所有的Http请求
 *
 * @author 53dada
 * @version 1.0
 * @since 2.0
 */
public class RestClient {

    private static RestClient mClient;
    private Retrofit mRetrofit;

    private RestClient() {
        init();
    }

    public static RestClient getClient() {
        if (null == mClient) mClient = new RestClient();
        return mClient;
    }

    private Interceptor mInterceptor = new Interceptor() {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request oldRequest = chain.request();
            Request.Builder build = oldRequest.newBuilder()
                    .method(oldRequest.method(), oldRequest.body())
                    .url(oldRequest.url());

            return chain.proceed(build.build());
        }
    };


    public void init() {
        //调试信息
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(mInterceptor)
                .addInterceptor(loggingInterceptor)
                .connectTimeout(BuildConfig.CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(BuildConfig.READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(BuildConfig.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .build();

        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(ConverterFactory.create())
                .build();
    }

    private boolean isInit() {
        return null != mRetrofit;
    }


    /**
     * 得到代理后的service
     *
     * @param service ...
     * @param <T>     ...
     * @return 代理后的service
     */
    public <T> T create(final Class<T> service) {
        if (!isInit()) throw new NullPointerException("RestClient没有被初始化,需执行init().");
        return mRetrofit.create(service);
    }

}

