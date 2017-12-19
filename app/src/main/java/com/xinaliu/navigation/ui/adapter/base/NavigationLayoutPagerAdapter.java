package com.xinaliu.navigation.ui.adapter.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by liuwei on 2017/12/13 13:33
 */

public abstract class NavigationLayoutPagerAdapter<T> extends PagerAdapter {

    protected Context mContext;
    protected List<T> list;
    private int mItemLayoutId;

    public NavigationLayoutPagerAdapter(Context mContext, List<T> list, int mItemLayoutId) {
        this.mContext = mContext;
        this.list = list;
        this.mItemLayoutId = mItemLayoutId;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NavigationPageViewHolder viewHolder = getViewHolder(mContext, container, mItemLayoutId, position);
        convert(viewHolder, list.get(position), position);
        View convertView = viewHolder.getConvertView();
        container.addView(convertView);
        return convertView;
    }

    public void convert(NavigationPageViewHolder helper, T item, int position) {

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //加载当前页面的左右两侧数据，其他的都会实时消除
        container.removeView((View) object);
    }

    public NavigationPageViewHolder getViewHolder(Context context, ViewGroup parent, int layoutId, int position) {
        return NavigationPageViewHolder.get(context, parent, layoutId, position);
    }

    public NavigationPageViewHolder getViewHolder(View view, int position) {
        return NavigationPageViewHolder.get(view, position);
    }

}
