package com.xinaliu.navigation.handler;

import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Created by liuwei on 2017/6/30 14:20
 * @see TaskHandlerImpl
 */

public interface TaskHandler {

      void handleMessage(WeakReference weakReference, Message msg);

}
