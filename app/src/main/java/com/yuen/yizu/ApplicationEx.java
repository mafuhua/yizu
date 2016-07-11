package com.yuen.yizu;

import android.app.Application;
import android.graphics.Color;

import com.yuen.yizu.galleryfinal.GlideImageLoader;
import com.yuen.yizu.galleryfinal.GlidePauseOnScrollListener;

import cn.finalteam.galleryfinal.CoreConfig;
import cn.finalteam.galleryfinal.FunctionConfig;
import cn.finalteam.galleryfinal.GalleryFinal;
import cn.finalteam.galleryfinal.ThemeConfig;

/**
 * Created by BaoHang on 15/3/23.
 * Description:
 * 进行系统初始化操作，且用于系统级的数据缓存，防止在应用运行过程中被app回收掉。在Application里面我们主要进行显示屏幕数据
 * ，系统SDK缓存目录，图片异步加载，友盟统计等初始化操作. <br/>
 */
public class ApplicationEx extends Application {

    private static ApplicationEx mApplication = null;

    /**
     * 单例方法
     *
     *
     * @return ApplicationEx
     */
    public static ApplicationEx getInstance() {
        return mApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mApplication = this;


        //建议在application中配置
        //设置主题
        // ThemeConfig theme = ThemeConfig.ORANGE;
        ThemeConfig theme = new ThemeConfig.Builder()
                .setTitleBarBgColor(Color.parseColor("#FF7478"))
                .setTitleBarTextColor(Color.WHITE)
                .setTitleBarIconColor(Color.WHITE)
                .setFabNornalColor(Color.parseColor("#FF7478"))
                .setFabPressedColor(Color.parseColor("#FF7478"))
                .setCheckNornalColor(Color.WHITE)
                .setCheckSelectedColor(Color.parseColor("#FF7478"))
                .build();

      /*  ThemeConfig theme = new ThemeConfig.Builder()
                .build();*/
        //配置功能
        FunctionConfig functionConfig = new FunctionConfig.Builder()
                .setEnableCamera(false)
                .setEnableEdit(true)
                .setEnableCrop(true)
                .setEnableRotate(true)
                .setCropSquare(true)
                .setEnablePreview(true)
                .build();
        CoreConfig coreConfig = new CoreConfig.Builder(this, new GlideImageLoader(), theme)
                .setFunctionConfig(functionConfig)
                .setPauseOnScrollListener(new GlidePauseOnScrollListener(false, true))
                .build();
        GalleryFinal.init(coreConfig);
        // sHA1(context);

    }




}
