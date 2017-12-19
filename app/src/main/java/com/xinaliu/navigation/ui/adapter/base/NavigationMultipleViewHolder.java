package com.xinaliu.navigation.ui.adapter.base;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinaliu.navigation.utils.image.util.ImageHelper;


/**
 * Created by liuwei on 2017/6/8 10:20
 */

public class NavigationMultipleViewHolder<T>  extends RecyclerView.ViewHolder {

    private static final String TAG = "SearchActivity1ViewHold";

    private int viewType;

    private final SparseArray<View> mViews;
    private View mConvertView;

    public NavigationMultipleViewHolder(ViewGroup parent, int viewType, int mItemLayoutId) {
        super(LayoutInflater.from(parent.getContext()).inflate(mItemLayoutId, parent, false));
        this.viewType = viewType;
        this.mViews = new SparseArray<View>();
        mConvertView = itemView;
        mConvertView.setTag(this);
    }

    public  void convert(NavigationMultipleViewHolder holder, T item, int position, int viewType){

    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId id
     * @return T
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }


    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    public NavigationMultipleViewHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        if (view != null)
        view.setText(text);
        return this;
    }
    public NavigationMultipleViewHolder setText(int viewId, @StringRes int resid) {
        TextView view = getView(viewId);
        if (view != null)
        view.setText(resid);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @param drawableId drawableId
     * @return this
     */
    public NavigationMultipleViewHolder setImageResource(@IdRes int viewId, @DrawableRes int drawableId) {
        ImageView view = getView(viewId);
        if (view != null)
        view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId viewId
     * @param bm bm
     * @return
     */
    public NavigationMultipleViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        if (view != null)
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * @param viewId viewId
     * @param uri uri
     * @return
     */
    public NavigationMultipleViewHolder setImageByUrl(int viewId, String uri) {
        ImageView view = getView(viewId);
        if (view != null)
        ImageHelper.newInstance().displayImage(uri, view);
        return this;
    }

    public void stop() {
        ImageHelper.newInstance().stop();
    }

    public void resume() {
        ImageHelper.newInstance().resume();
    }

    public void destroy() {
        ImageHelper.newInstance().destroy();
    }
}
