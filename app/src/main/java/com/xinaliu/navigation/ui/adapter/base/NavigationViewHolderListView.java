package com.xinaliu.navigation.ui.adapter.base;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.xinaliu.navigation.utils.image.util.ImageHelper;


/**
 * 
 * @author liuWei
 *
 */
public class NavigationViewHolderListView
{
	private final SparseArray<View> mViews;
	private int mPosition;
	private View mConvertView;
	private NavigationViewHolderListView(Context context, ViewGroup parent, int layoutId,
										 int position)
	{
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mConvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		// setTag
		mConvertView.setTag(this);
	}

	/**
	 * 拿到一个ViewHolder对象
	 *
	 * @param context
	 * @param convertView
	 * @param parent
	 * @param layoutId
	 * @param position
	 * @return
	 */
	public static NavigationViewHolderListView get(Context context, View convertView,
												   ViewGroup parent, int layoutId, int position)
	{
		if (convertView == null)
		{
			return new NavigationViewHolderListView(context, parent, layoutId, position);
		}
		return (NavigationViewHolderListView) convertView.getTag();
	}

	public View getConvertView()
	{
		return mConvertView;
	}

	/**
	 * 通过控件的Id获取对于的控件，如果没有则加入views
	 * 
	 * @param viewId
	 * @return
	 */
	public <T extends View> T getView(int viewId)
	{
		View view = mViews.get(viewId);
		if (view == null)
		{
			view = mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return (T) view;
	}
	public <T extends ListView> T getListView(int viewId)
	{
		ListView view = (ListView) mViews.get(viewId);
		if (view == null)
		{
			view =  (ListView) mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return  (T) view;
	}
	public <T extends ImageView> T getImageView(int viewId)
	{
		ImageView view = (ImageView) mViews.get(viewId);
		if (view == null)
		{
			view =  (ImageView) mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return  (T) view;
	}
	public <T extends TextView> T getTextView(int viewId)
	{
		TextView view = (TextView) mViews.get(viewId);
		if (view == null)
		{
			view =  (TextView) mConvertView.findViewById(viewId);
			mViews.put(viewId, view);
		}
		return  (T) view;
	}

	/**
	 * 为TextView设置字符串
	 * 
	 * @param viewId
	 * @param text
	 * @return
	 */
	public NavigationViewHolderListView setText(int viewId, String text)
	{
		TextView view = getView(viewId);
		if (view != null)
		view.setText(text);
		return this;
	}
	public NavigationViewHolderListView setBtnText(int viewId, String text)
	{
		Button view = getView(viewId);
		if (view != null)
		view.setText(text);
		return this;
	}
	public NavigationViewHolderListView setRatingBar(int viewId, float rating)
	{
		RatingBar view = getView(viewId);
		if (view != null)
		view.setRating(rating);
		return this;
	}
	/**
	 * 为ImageView设置图片
	 * 
	 * @param viewId
	 * @param drawableId
	 * @return
	 */
	public NavigationViewHolderListView setImageResource(int viewId, int drawableId)
	{
		ImageView view = getView(viewId);
		if (view != null)
		view.setImageResource(drawableId);

		return this;
	}

	/**
	 * 为ImageView设置图片
	 * 
	 * @param  viewId
	 * @return
	 */
	public NavigationViewHolderListView setImageBitmap(int viewId, Bitmap bm)
	{
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
	public NavigationViewHolderListView setImageByUrl(int viewId, String url)
	{
		ImageView view = getView(viewId);
		if (view != null)
		ImageHelper.newInstance().displayImage(url, view);
		return this;
	}

	public int getPosition()
	{
		return mPosition;
	}

}
