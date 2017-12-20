package com.xinaliu.navigation.application;

import android.app.Application;
import android.content.Context;

import com.tencent.smtt.sdk.QbSdk;
import com.xinaliu.navigation.utils.json.GsonHelper;
import com.xinaliu.navigation.utils.json.base.JsonHepler;

/**
 * Created by liuwei on 2017/12/19 10:45
 */

public class NavigationApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(this, null);
        JsonHepler.newInstance().init(GsonHelper.newInstance());
//        JsonHepler.newInstance().init(AliasActivity..newInstance());
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
