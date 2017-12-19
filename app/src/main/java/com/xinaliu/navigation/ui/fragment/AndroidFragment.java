package com.xinaliu.navigation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xinaliu.navigation.R;

/**
 * Created by liuwei on 2017/12/19 15:29
 */

public class AndroidFragment extends BaseFragment {


    private View view;
    private CardView mCvAndroid;

    public static synchronized AndroidFragment newInstance(boolean isPrepared) {
        Bundle args = new Bundle();
        args.putBoolean(IS_PREPARED, isPrepared);
        AndroidFragment fragment = new AndroidFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_android, container, false);

        initView(view);
        return view;
    }

    private void initView(View view) {
        RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.id_recyclerview);
//设置布局管理器
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//设置Item增加、移除动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

//设置adapter
        mRecyclerView.setAdapter(null);
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
}
