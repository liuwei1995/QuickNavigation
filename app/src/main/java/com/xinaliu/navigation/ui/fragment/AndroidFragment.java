package com.xinaliu.navigation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinaliu.navigation.R;
import com.xinaliu.navigation.entity.AndroidFragmentEntity;
import com.xinaliu.navigation.presenter.activity.AndroidFragmentPresenter;
import com.xinaliu.navigation.presenter.activity.impl.AndroidFragmentPresenterImpl;
import com.xinaliu.navigation.ui.adapter.base.NavigationAdapter;
import com.xinaliu.navigation.ui.adapter.base.NavigationViewHolder;
import com.xinaliu.navigation.ui.view.AndroidFragmentView;
import com.xinaliu.navigation.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuwei on 2017/12/19 15:29
 */

public class AndroidFragment extends BaseFragment implements AndroidFragmentView, NavigationAdapter.OnItemClickListener<AndroidFragmentEntity> {


    private View view;
    private CardView mCvAndroid;

    public static synchronized AndroidFragment newInstance(boolean isPrepared) {
        Bundle args = new Bundle();
        args.putBoolean(IS_PREPARED, isPrepared);
        AndroidFragment fragment = new AndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private AndroidFragmentPresenter mAndroidFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);
        initView(view);
        mAndroidFragmentPresenter = new AndroidFragmentPresenterImpl(this);
        return view;
    }

    private int pageIndex = 1;
    private int pageCount = 20;

    @Override
    public void firstExecute() {
        if (mAndroidFragmentPresenter != null)
            mAndroidFragmentPresenter.getData(pageIndex, pageCount);
    }

    private RecyclerView mRecyclerView;

    private void initView(View view) {
        mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
//设置布局管理器
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
//设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//设置adapter
//添加分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//                getActivity(), DividerItemDecoration.HORIZONTAL_LIST));

//        mCvAndroid = (CardView) view.findViewById(R.id.cv_android);
//        mCvAndroid.setRadius(8);//设置图片圆角的半径大小
//
//        mCvAndroid.setCardElevation(8);//设置阴影部分大小
//
//        mCvAndroid.setContentPadding(5, 5, 5, 5);//设置图片距离阴影大小
    }

    private List<AndroidFragmentEntity> list;

    private NavigationAdapter<AndroidFragmentEntity> adapter;
    public synchronized void setAdapter(List<AndroidFragmentEntity> list) {
        if (this.list == null){
            this.list = new ArrayList<>();
        }
        if (pageIndex == 1){
            this.list.clear();
        }
        if (list != null)
        this.list.addAll(list);
        if (adapter == null){
            adapter = new NavigationAdapter<AndroidFragmentEntity>(this.list, R.layout.item_fragment_android) {
                @Override
                public void convert(NavigationViewHolder holder, AndroidFragmentEntity item, int position) {
                    holder.setText(R.id.tvTitle, item.getTitle());
                }
            };
            adapter.setOnItemClickListener(this);
            mRecyclerView.setAdapter(adapter);
        }else {
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void getDataCallBack(List<AndroidFragmentEntity> list) {
        setAdapter(list);
    }

    @Override
    public void showToast(Integer stateCode, String message, Object methodName) {

    }

    @Override
    public void showLoading(Object methodName) {

    }

    @Override
    public void hideLoading(boolean isSuccess, Object methodName) {

    }

    @Override
    public void onItemClick(View view, AndroidFragmentEntity item, int position) {
        ToastUtil.show(mContext, item.toString());
    }
}
