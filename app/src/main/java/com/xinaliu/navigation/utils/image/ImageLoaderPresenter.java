//package com.xinaliu.navigation.utils.image;
//
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.support.annotation.DrawableRes;
//import android.widget.ImageView;
//
//import com.xinaliu.navigation.utils.image.util.ImagePresenter;
//
//import java.io.File;
//
///**
// * Created by liuwei on 2017/12/14 13:23
// */
//
//public class ImageLoaderPresenter implements ImagePresenter {
//
//    private static ImageLoaderPresenter mImageLoaderPresenter;
//
//    private static ImageLoader imageLoader = ImageLoader.getInstance();
//
//    public static ImageLoaderPresenter newInstance() {
//        if (mImageLoaderPresenter == null) {
//            synchronized (ImageLoaderPresenter.class) {
//                if (mImageLoaderPresenter == null) {
//                    mImageLoaderPresenter = new ImageLoaderPresenter();
//                }
//            }
//        }
////        imageLoader.getDiskCache().getDirectory();
//        return mImageLoaderPresenter;
//    }
//
//    public synchronized void setContext(Context context) {
//        if (context != null && context.getApplicationContext() != null) {
//            initImageLoader(context.getApplicationContext());
//        } else {
//            initImageLoader(context);
//        }
//    }
//
//    private synchronized boolean checkImageLoader() {
//        return imageLoader.isInited();
//    }
//
//
//    /**
//     * 配置imageLoader
//     *
//     * @param context
//     */
//    private void initImageLoader(Context context) {
//        //缓存文件的目录
//        String IMAGELOADER_CACHE = context.getPackageName() + "/" + "imageloader/Cache";
//
//        File cacheDir = StorageUtils.getOwnCacheDirectory(context, IMAGELOADER_CACHE);
//        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
//                .memoryCacheExtraOptions(480, 800) // max width, max height，即保存的每个缓存文件的最大长宽
//                .threadPoolSize(3) //线程池内加载的数量
//                .threadPriority(Thread.NORM_PRIORITY - 2)
//                .denyCacheImageMultipleSizesInMemory()
//                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //将保存的时候的URI名称用MD5 加密
//                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You can pass your own memory cache implementation/你可以通过自己的内存缓存实现
//                .memoryCacheSize(2 * 1024 * 1024) // 内存缓存的最大值
//                .diskCacheSize(50 * 1024 * 1024)  // 50 Mb sd卡(本地)缓存的最大值
//                .tasksProcessingOrder(QueueProcessingType.LIFO)
//                // 由原先的discCache -> diskCache
//                .diskCache(new UnlimitedDiskCache(cacheDir))//自定义缓存路径
//                .imageDownloader(new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // connectTimeout (5 s), readTimeout (30 s)超时时间
//                .writeDebugLogs() // Remove for release app
//                .build();
//        //全局初始化此配置
//        ImageLoader.getInstance().init(config);
//    }
//
//    private DisplayImageOptions setOptions(int defaultPic, BitmapDisplayer displayer) {
//        return new DisplayImageOptions.Builder()
//                // .showImageOnLoading(defaultPic)
//				.showImageOnLoading(defaultPic)
//                .showImageForEmptyUri(defaultPic).showImageOnFail(defaultPic)
//                .cacheInMemory(true).cacheOnDisk(true).considerExifParams(true)
//                .bitmapConfig(Bitmap.Config.RGB_565)
//                .imageScaleType(ImageScaleType.EXACTLY).displayer(displayer)
//                .build();
//    }
//
//
//    @Override
//    public void displayImage(String uri, ImageView imageView) {
//        imageLoader.displayImage(uri, imageView);
//    }
//
//    @Override
//    public void displayImage(String uri, ImageView imageView, @DrawableRes int defaultPic) {
//        DisplayImageOptions options = setOptions(defaultPic, new SimpleBitmapDisplayer());
//        imageLoader.displayImage(uri, imageView, options);
//    }
//
//    @Override
//    public void displayImage(String uri, ImageAware imageAware) {
//        imageLoader.displayImage(uri, imageAware);
//    }
//
//    @Override
//    public void displayImage(String uri, ImageAware imageAware, @DrawableRes int defaultPic) {
//        DisplayImageOptions options = setOptions(defaultPic, new SimpleBitmapDisplayer());
//        imageLoader.displayImage(uri, imageAware, options);
//    }
//
//    @Override
//    public Bitmap loadImageSync(String uri) {
//        return imageLoader.loadImageSync(uri);
//    }
//
//    @Override
//    public Bitmap loadImageSync(String uri, int width, int height) {
//        DisplayImageOptions options = setOptions(0, new SimpleBitmapDisplayer());
//        ImageSize targetSize = new ImageSize(width, height); // result Bitmap
//        return imageLoader.loadImageSync(uri, targetSize, options);
//    }
//
//    @Override
//    public Bitmap loadImageSync(String uri, @DrawableRes int defaultPic) {
//        DisplayImageOptions options = setOptions(defaultPic, new SimpleBitmapDisplayer());
//        return imageLoader.loadImageSync(uri, null, options);
//    }
//
//    @Override
//    public Bitmap loadImageSync(String uri, int width, int height, @DrawableRes int defaultPic) {
//        DisplayImageOptions options = setOptions(defaultPic, new SimpleBitmapDisplayer());
//        ImageSize targetSize = new ImageSize(width, height); // result Bitmap
//        return imageLoader.loadImageSync(uri, targetSize, options);
//    }
//
//    @Override
//    public File getDiskCacheDirectory() {
//        if (imageLoader.getDiskCache() == null) return null;
//        File directory = imageLoader.getDiskCache().getDirectory();
//        if (directory == null) return null;
//        else return directory;
//    }
//
//    @Override
//    public long getCacheSize() {
//        if (imageLoader.getDiskCache() == null) return 0;
//        File directory = imageLoader.getDiskCache().getDirectory();
//        if (directory == null) return 0;
//        return DataCleanManager.getFolderSize(directory);
//    }
//
//    @Override
//    public <T> T getLoaderPresenter() {
//        return (T) this;
//    }
//
//
//    /**
//     * 清除内存缓存
//     */
//    public void onClearMemoryClick() {
//        ImageLoader.getInstance().clearMemoryCache();
//    }
//
//    /**
//     * 清除本地缓存
//     */
//    public  void onClearDiskClick() {
//        ImageLoader.getInstance().clearDiskCache();
//    }
//
//    /**
//     * 清除某一张图片
//     *
//     * @param url
//     */
//    public void onClearImageUrl(String url) {
//        DiskCacheUtils.removeFromCache(url, ImageLoader.getInstance().getDiskCache());
//        MemoryCacheUtils.removeFromCache(url, ImageLoader.getInstance().getMemoryCache());
//    }
//
//
//    @Override
//    public void clearAll() {
//        imageLoader.clearMemoryCache();
//        imageLoader.clearDiskCache();
//    }
//
//    @Override
//    public void resume() {
//        imageLoader.resume();
//    }
//
//    @Override
//    public void pause() {
//        imageLoader.pause();
//    }
//
//    @Override
//    public void stop() {
//        imageLoader.stop();
//    }
//
//    @Override
//    public void destroy() {
//        imageLoader.destroy();
//    }
//}
