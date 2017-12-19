package com.xinaliu.navigation.application;

import android.app.Application;
import android.content.Context;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by liuwei on 2017/12/19 10:45
 */

public class NavigationApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        QbSdk.initX5Environment(this, null);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }
}
