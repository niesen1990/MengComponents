package com.cmbb.smartkids.testmenglist;

import android.app.Application;

import com.cmbb.smartkids.testmenglist.utils.ImagePipelineConfigFactory;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;

/**
 * 项目名称：MengBao
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：2015/6/26 13:07
 */
public class App extends Application {
    public static Application application;
    public static String PGY_APPID = "3d6a2e5da7ffd8e3fb191bf7bb932729";

    @Override
    public void onCreate() {
        super.onCreate();
        // chrome debug
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                .build());
        application = this;
        //初始化
        Fresco.initialize(this, ImagePipelineConfigFactory.getOkHttpImagePipelineConfig(this));

        //PgyCrashManager.register(this, PGY_APPID);
    }
}
