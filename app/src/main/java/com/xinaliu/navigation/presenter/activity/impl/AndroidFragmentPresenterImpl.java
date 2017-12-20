package com.xinaliu.navigation.presenter.activity.impl;

import com.xinaliu.navigation.entity.AndroidFragmentEntity;
import com.xinaliu.navigation.presenter.activity.AndroidFragmentPresenter;
import com.xinaliu.navigation.ui.view.AndroidFragmentView;

import java.util.List;

/**
 * Created by liuwei on 2017/12/20 10:21
 */

public class AndroidFragmentPresenterImpl implements AndroidFragmentPresenter {

    private AndroidFragmentView mAndroidFragmentView;

    public AndroidFragmentPresenterImpl(AndroidFragmentView mAndroidFragmentView) {
        this.mAndroidFragmentView = mAndroidFragmentView;
    }

    @Override
    public void getData(int pageIndex, int pageCount) {
//        JsonHepler.newInstance().
    }

    @Override
    public void getDataCallBack(List<AndroidFragmentEntity> list) {
        mAndroidFragmentView.getDataCallBack(list);
    }
}
