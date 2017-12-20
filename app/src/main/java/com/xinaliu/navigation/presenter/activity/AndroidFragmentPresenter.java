package com.xinaliu.navigation.presenter.activity;

import com.xinaliu.navigation.entity.AndroidFragmentEntity;

import java.util.List;

/**
 * Created by liuwei on 2017/12/20 10:19
 */

public interface AndroidFragmentPresenter {

    void getData(int pageIndex, int pageCount);

    void getDataCallBack(List<AndroidFragmentEntity> list);

}
