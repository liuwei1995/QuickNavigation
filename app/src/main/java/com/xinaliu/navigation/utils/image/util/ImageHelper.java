package com.xinaliu.navigation.utils.image.util;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;


import java.io.File;

/**
 * Created by liuwei on 2017/12/14 11:41
 */

public class ImageHelper implements ImagePresenter {

    private ImagePresenter mImagePresenter;

    public void init(ImagePresenter iHttpPresenter) {
        mImagePresenter = iHttpPresenter;
//        if (mImagePresenter == null) {
//            synchronized (HttpHelper.class) {
//                if (mImagePresenter == null)
//                    mImagePresenter = iHttpPresenter;
//            }
//        }
    }

    private static ImageHelper mImageHelper;

    public static ImageHelper newInstance() {
        if (mImageHelper == null) {
            synchronized (ImageHelper.class) {
                if (mImageHelper == null)
                    mImageHelper = new ImageHelper();
            }
        }
        return mImageHelper;
    }


    @Override
    public void displayImage(String uri, ImageView imageView) {
        if (mImagePresenter != null) {
           mImagePresenter.displayImage(uri, imageView);
        }
    }

    @Override
    public void displayImage(String uri, ImageView imageView, @DrawableRes int defaultPic) {
        if (mImagePresenter != null) {
            mImagePresenter.displayImage(uri, imageView, defaultPic);
        }
    }


    @Override
    public Bitmap loadImageSync(String uri) {
        if (mImagePresenter != null) {
            return mImagePresenter.loadImageSync(uri);
        }
        return null;
    }

    @Override
    public Bitmap loadImageSync(String uri, int width, int height) {
        if (mImagePresenter != null) {
            return mImagePresenter.loadImageSync(uri, width, height);
        }
        return null;
    }

    @Override
    public Bitmap loadImageSync(String uri, @DrawableRes int defaultPic) {
        if (mImagePresenter != null) {
            return mImagePresenter.loadImageSync(uri, defaultPic);
        }
        return null;
    }

    @Override
    public Bitmap loadImageSync(String uri, int width, int height, @DrawableRes int defaultPic) {
        if (mImagePresenter != null) {
            return mImagePresenter.loadImageSync(uri, width, height, defaultPic);
        }
        return null;
    }

    @Override
    public File getDiskCacheDirectory() {
        if (mImagePresenter != null)
            return mImagePresenter.getDiskCacheDirectory();
        return null;
    }

    @Override
    public long getCacheSize() {
        if (mImagePresenter != null)
            return mImagePresenter.getCacheSize();
        return 0;
    }

    @Override
    public <T> T getLoaderPresenter() {
        if (mImagePresenter != null)
            return mImagePresenter.getLoaderPresenter();
        return null;
    }

    @Override
    public void onClearMemoryClick() {
        if (mImagePresenter != null)
            mImagePresenter.onClearMemoryClick();
    }

    @Override
    public void onClearDiskClick() {
        if (mImagePresenter != null)
            mImagePresenter.onClearDiskClick();
    }

    @Override
    public void onClearImageUrl(String url) {
        if (mImagePresenter != null)
            mImagePresenter.onClearImageUrl(url);
    }

    @Override
    public void clearAll() {
        if (mImagePresenter != null) {
            mImagePresenter.clearAll();
        }
    }

    @Override
    public void resume() {
        if (mImagePresenter != null) {
            mImagePresenter.resume();
        }
    }

    @Override
    public void pause() {
        if (mImagePresenter != null) {
            mImagePresenter.pause();
        }
    }

    @Override
    public void stop() {
        if (mImagePresenter != null) {
            mImagePresenter.stop();
        }
    }

    @Override
    public void destroy() {
        if (mImagePresenter != null) {
            mImagePresenter.destroy();
        }
    }
}
