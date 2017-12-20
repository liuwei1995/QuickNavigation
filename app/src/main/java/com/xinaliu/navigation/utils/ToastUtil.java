package com.xinaliu.navigation.utils;

import android.content.Context;
import android.widget.Toast;

/***
 * toast工具
 *
 * @author zhaoyaba3
 *
 */
public class ToastUtil {

    private static Toast mToast;

    public static void show(Context context, String text) {
        if (context == null) return;
        if (mToast == null) {
            mToast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public static void cancelToast() {
        if (mToast != null) {
            mToast.cancel();
        }
    }

    public static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
