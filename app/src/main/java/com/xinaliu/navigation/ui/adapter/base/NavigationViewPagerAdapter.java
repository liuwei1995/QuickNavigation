package com.xinaliu.navigation.ui.adapter.base;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by liuwei on 2017/12/13 13:33
 */

public abstract class NavigationViewPagerAdapter<T> extends PagerAdapter {

    protected Context mContext;
    protected List<View> listView;
    protected List<T> list;

    public NavigationViewPagerAdapter(Context mContext, List<View> listView) {
        this.mContext = mContext;
        this.listView = listView;
    }
    public NavigationViewPagerAdapter(Context mContext, List<View> listView, List<T> list) {
        this.mContext = mContext;
        this.listView = listView;
        this.list = list;
    }

    @Override
    public int getCount() {
        return listView == null ? 0 : listView.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        NavigationPageViewHolder viewHolder = getViewHolder(listView.get(position), position);
        if (list != null && list.size() > position){
            convert(viewHolder, list.get(position), position);
        }else {
            convert(viewHolder, null, position);
        }
        View convertView = viewHolder.getConvertView();
        container.addView(convertView);
        return convertView;
    }

    /**
     *
     * @param helper {@link  NavigationViewPagerAdapter#listView}
     * @param item {@link  NavigationViewPagerAdapter#list}
     * @param position p
     */
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
