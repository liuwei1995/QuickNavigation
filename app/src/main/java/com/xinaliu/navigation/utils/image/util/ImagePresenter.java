package com.xinaliu.navigation.utils.image.util;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by liuwei on 2017/12/14 11:42
 */

public interface ImagePresenter {

    void displayImage(String uri, ImageView imageView);

    void displayImage(String uri, ImageView imageView, @DrawableRes int defaultPic);

    Bitmap loadImageSync(String uri);

    Bitmap loadImageSync(String uri, int width, int height);

    Bitmap loadImageSync(String uri, @DrawableRes int defaultPic);

    Bitmap loadImageSync(String uri, int width, int height, @DrawableRes int defaultPic);

    /***
     * 获取缓存的磁盘路径
     * @return 路径
     */
    File getDiskCacheDirectory();

    /***
     * 获取缓存的内容大小
     * @return d
     */
    long getCacheSize();


    <T extends Object> T getLoaderPresenter();

    /**
     * 清除内存缓存
     */
    void onClearMemoryClick();

    /**
     * 清除本地缓存
     */
    void onClearDiskClick();

    /**
     * 清除某一张图片
     *
     * @param url u
     */
    void onClearImageUrl(String url);

    /**
     * <li>清除内存缓存</li>
     * <li>清除本地缓存</li>
     * @see #onClearMemoryClick()
     * @see #onClearDiskClick()
     */
    void clearAll();

    void resume();

    /**
     * 暂停加载
     */
    void pause();

    /**
     * 停止加载
     */
    void stop();

    /**
     * 销毁加载
     */
    void destroy();

}
