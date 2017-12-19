package com.xinaliu.navigation.ui.adapter.base;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.xinaliu.navigation.R;
import com.xinaliu.navigation.utils.image.util.ImageHelper;


public class NavigationPageViewHolder {
    private final SparseArray<View> mViews;
    private int mPosition;
    private View mConvertView;

    private NavigationPageViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        mConvertView.setTag(this);
    }

    private NavigationPageViewHolder(View view, int position) {
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = view;
        mConvertView.setTag(this);
    }

    /**
     * 拿到一个ViewHolder对象
     */
    public static NavigationPageViewHolder get(Context context, ViewGroup parent, int layoutId, int position) {
        return new NavigationPageViewHolder(context, parent, layoutId, position);
    }

    public static NavigationPageViewHolder get(View view, int position) {
        return new NavigationPageViewHolder(view, position);
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
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
     */
    public NavigationPageViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        if (view != null)
            view.setText(text);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public NavigationPageViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        if (view != null)
            view.setImageResource(drawableId);
        return this;
    }

    /**
     * 为ImageView设置图片
     */
    public NavigationPageViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        if (view != null)
            view.setImageBitmap(bm);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @return
     */
    public NavigationPageViewHolder setImageByUrl(int viewId, String url) {
        ImageView view = getView(viewId);
        if (view != null)
            ImageHelper.newInstance().displayImage(url, (ImageView) getView(viewId), R.drawable.default_picture);
        return this;
    }

    public NavigationPageViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = getView(viewId);
        if (view != null)
            view.setOnClickListener(listener);
        return this;
    }

    public int getPosition() {
        return mPosition;
    }

}
